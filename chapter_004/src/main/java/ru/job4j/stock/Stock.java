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
    private Map<String, TreeSet<Proposal>> purchaseBid = new TreeMap<String, TreeSet<Proposal>>();
    private Map<String, TreeSet<Proposal>> saleBid = new TreeMap<String, TreeSet<Proposal>>();

    /**
     * Обработка заявки.Возможно добавить/удалить заявку.
     * @param bid - заявка.
     */
    public void addBid(Proposal bid) {
        if (bid.getType().equals(Type.DELETE)) {
            withdrawApplication(bid); //снять с торгов
        } else {
            bidApplication(bid); //выставить на торги
        }
    }

    /**
     * Метод выставляет заявку на торги.Сначала мы пытаемся найти заявку с обратным действем.
     * Если мы такую заявку нашли то делаем взаимозачет. В противном случае,просто добавляем заявку в стакан
     * @param bid - заявка.
     */
    private void bidApplication(Proposal bid) {
        int volume = bid.getVolume();
        int resultVolume = netting(bid);
        if (resultVolume > 0) {
            bid.setVolume(resultVolume);
            Map<String, TreeSet<Proposal>> currentBid = bid.getAction().equals(Action.BID) ? purchaseBid : saleBid;
            String book = bid.getBook();
            TreeSet<Proposal> currentProposal = currentBid.get(book);
            if (currentProposal == null) {
                TreeSet<Proposal> newList = new TreeSet<Proposal>();
                newList.add(bid);
                currentBid.put(book, newList);
            } else {
                currentProposal.add(bid);
                currentBid.put(book, currentProposal);
            }
        }
    }

    /**
     * Метод для взаимозачета покупки/продажи. В результате взаимозачета заявка с обратным действием может
     * быть полностью удалена из стакана. Или возможно обновление количества в заявке.
     * @param bid - заявка.
     * @return - количество,которое осталось,после взаимозачета
     */
    private int netting(Proposal bid) {
        int result = bid.getVolume();
        int price = bid.getPrice();
        boolean checkAction = bid.getAction().equals(Action.BID);
        boolean condition;
        Map<String, TreeSet<Proposal>> currentBid = checkAction ? saleBid : purchaseBid;
        TreeSet<Proposal> currentProposal = currentBid.get(bid.getBook());
        if (currentProposal != null) {
            Iterator<Proposal> currentIterator = currentProposal.iterator();
            while (currentIterator.hasNext() || result > 0) {
                Proposal iterBid = currentIterator.next();
                condition = checkAction ? price >= iterBid.getPrice() : price <= iterBid.getPrice();
                if (condition) {
                    int currentVolume = iterBid.getVolume();
                    if (result >= currentVolume) {
                        result -= currentVolume;
                        withdrawApplication(iterBid);
                    } else {
                        iterBid.setVolume(currentVolume - result);
                        result = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Снятие заявки с торгов/целиковое удаление
     * @param bid - заявка.
     */
    private void withdrawApplication(Proposal bid) {
        Map<String, TreeSet<Proposal>> currentBid = bid.getAction().equals(Action.BID) ? purchaseBid : saleBid;
        String book = bid.getBook();
        TreeSet<Proposal> currentProposal = currentBid.get(book);
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
                    .append(printBookData(item, Action.BID))
                    .append(printBookData(item, Action.ASK));
        }
        System.out.println(stockBuilder.toString());
    }

    private String printBookData(String book, Action action) {
        String result = "";
        Map<String, TreeSet<Proposal>> currentBid = action.equals(Action.BID) ? purchaseBid : saleBid;
        TreeSet<Proposal> currentList = currentBid.get(book);
        if (currentList != null) {
            Iterator<Proposal> bidIterator = currentList.iterator();
            int currentPrice = 0, currentVolume = 0;
            while (bidIterator.hasNext()) {
                Proposal bid = bidIterator.next();
                boolean hasNext = bidIterator.hasNext();
                currentPrice = currentPrice == 0 ? bid.getPrice() : currentPrice;
                if (currentPrice == bid.getPrice() && hasNext) {
                    currentVolume += bid.getVolume();
                } else {
                    boolean printSurplus = !hasNext && currentPrice != bid.getPrice();
                    if (action.equals(Action.BID)) {
                        result += String.format("        %d    %d \n", currentPrice, (!hasNext && !printSurplus) ? currentVolume + bid.getVolume(): currentVolume);
                        if (printSurplus) {
                            result += String.format("        %d    %d \n", bid.getPrice(), bid.getVolume());
                        }
                    } else {
                        result += String.format("%d      %d\n", (!hasNext && !printSurplus) ? currentVolume + bid.getVolume() : currentVolume, currentPrice);
                        if (printSurplus) {
                            result += String.format("%d      %d\n", bid.getVolume(), bid.getPrice());
                        }
                    }
                    currentPrice = bid.getPrice();
                    currentVolume = bid.getVolume();
                }
            }
        }
        return result;
    }
}
