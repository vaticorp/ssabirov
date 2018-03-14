package ru.job4j.stock;

import java.util.*;

/**
 * This class represents class for bid-storage.
 * @author Svyatoslav Sabirov.
 * @since 12.03.2018
 * @version 9.
 */
public class Stock {

    //Хранение заявок по эммитенту.
    private Map<String, LinkedList<Proposal>> purchaseBid = new TreeMap<String, LinkedList<Proposal>>();
    private Map<String, LinkedList<Proposal>> saleBid = new TreeMap<String, LinkedList<Proposal>>();

    /**
     * Обработка заявки.Возможно добавить/удалить заявку.
     * @param bid
     */
    public void addBid(Proposal bid) {
        if (bid.getType().equals(Type.delete)) {
            withdrawApplication(bid); //снять с торгов
        } else {
            bidApplication(bid); //выставить на торги
        }
    }

    private void bidApplication(Proposal bid) {
        //нужно найти в стакане заявки c обратной операцией и произвести взаимозачет
        int volume = bid.getVolume();
        int resultVolume = netting(bid);
        //Если обработано не все количество акций,то обновим количество в заявке и добавить в стакан
        if (resultVolume > 0) {
            bid.setVolume(resultVolume);
            Map<String, LinkedList<Proposal>> currentBid = bid.getAction().equals(Action.bid) ? purchaseBid : saleBid;
            String book = bid.getBook();
            LinkedList<Proposal> currentProposal = currentBid.get(book);
            if (currentProposal == null) { //просто добавим заявку на покупку в стакан
                LinkedList<Proposal> newList = new LinkedList<Proposal>();
                newList.add(bid);
                currentBid.put(book, newList);
            } else {
                currentProposal.add(bid);
                currentBid.put(book, currentProposal);
            }
        }
    }

    /**
     * Метод для взаимозачета покупки/продажи
     * @param bid - заявка.
     * @return - количество,которое осталось,после взаимозачета
     */
    private int netting(Proposal bid) {
        int result = bid.getVolume();
        int price = bid.getPrice();
        boolean checkAction = bid.getAction().equals(Action.bid);
        boolean condition;
        Map<String, LinkedList<Proposal>> currentBid = checkAction ? saleBid : purchaseBid;
        LinkedList<Proposal> currentProposal = currentBid.get(bid.getBook());
        if (currentProposal != null) {
            currentProposal = sortByPrice(currentProposal);
            Iterator<Proposal> currentIterator = currentProposal.iterator();
            while (currentIterator.hasNext() || result > 0) {
                Proposal iterBid = currentIterator.next();
                condition = checkAction ? price >= iterBid.getPrice() : price <= iterBid.getPrice();
                if (condition) {
                    int currentVolume = iterBid.getVolume();
                    //в таком случае удаляем старую заявку
                    if (result >= currentVolume) {
                        result -= currentVolume;
                        withdrawApplication(iterBid);
                    } else { //обновим количество в существующей заявке
                        iterBid.setVolume(currentVolume - result);
                        result = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public LinkedList<Proposal> sortByPrice(LinkedList<Proposal> linkedList) {
        linkedList.sort(new Comparator<Proposal>() {
            @Override
            public int compare(Proposal o1, Proposal o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        return linkedList;
    }

    /**
     * Снятие заявки с торгов/целиковое удаление
     * @param bid - заявка.
     */
    private void withdrawApplication(Proposal bid) {
        Map<String, LinkedList<Proposal>> currentBid = bid.getAction().equals(Action.bid) ? purchaseBid : saleBid;
        String book = bid.getBook();
        LinkedList<Proposal> currentProposal = currentBid.get(book);
        if (currentProposal != null && currentProposal.contains(bid)) {
            currentProposal.remove(bid);
            if (currentProposal.size() == 0) {
                currentBid.remove(book);
            }
        }
    }

    /**
     * Вывод стакана на печать.Сначала группируем по эммитенту,
     * потом выводим из двух списков
     */
    public void printStock() {
        StringBuilder stockBuilder = new StringBuilder();
        LinkedList<Proposal> currentList;
        Set<String> items = new HashSet<>(purchaseBid.keySet());
        items.addAll(saleBid.keySet());
        for (String item : items) {
            stockBuilder.append("Биржевой стакан для ")
                    .append(item)
                    .append("\n")
                    .append("------------------------------")
                    .append("\n")
                    .append("Продажа Цена Покупка")
                    .append("\n")
                    .append(listToString(item, Action.bid))
                    .append(listToString(item, Action.ask));
        }
        System.out.println(stockBuilder.toString());
    }

    private String listToString(String book, Action action) {
        String result = "";
        Map<String, LinkedList<Proposal>> currentBid = action.equals(Action.bid) ? purchaseBid : saleBid;
        LinkedList<Proposal> currentList = currentBid.get(book);
        if (currentList != null) {
            currentList = sortByPrice(currentList);
            Iterator<Proposal> bidIterator = currentList.iterator();
            int currentPrice = 0, currentVolume = 0;
            while (bidIterator.hasNext()) {
                Proposal bid = bidIterator.next();
                boolean hasNext = bidIterator.hasNext();
                currentPrice = currentPrice == 0 ? bid.getPrice() : currentPrice;
                if (currentPrice == bid.getPrice() && hasNext) {
                    currentVolume += bid.getVolume();
                } else {
                    if (action.equals(Action.bid)) {
                        result += String.format("        %d    %d \n", currentPrice, hasNext ? currentVolume : currentVolume + bid.getVolume());
                    } else {
                        result += String.format("%d      %d\n", hasNext ? currentVolume : currentVolume + bid.getVolume(), currentPrice);
                    }
                    currentPrice = bid.getPrice();
                    currentVolume = bid.getVolume();
                }
            }
        }
        return result;
    }
}
