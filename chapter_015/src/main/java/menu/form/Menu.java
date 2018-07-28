package menu.form;

import java.util.LinkedList;

/**
 * This class represents class for menu.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 7.
 */
public class Menu {

    private LinkedList<Clause> menuTape = new LinkedList<>();

    public Menu(LinkedList<Clause> menuTape) {
        this.menuTape = menuTape;
    }

    public Menu() {
    }

    public LinkedList<Clause> getMenuTape() {
        return menuTape;
    }

    public void setMenuTape(LinkedList<Clause> menuTape) {
        this.menuTape = menuTape;
    }

    public void addNewClause(Clause clause ) {
        menuTape.add(clause);
    }

    public void draw() {
        menuTape.forEach(s -> {
            System.out.println(s.toString());
            LinkedList<ClauseForm> embegged = s.getSubClauses();
            drawSubMenu("----", embegged);
        });
    }

    private void drawSubMenu(String prefix, LinkedList<ClauseForm> clauses) {
        String subPrefix = new StringBuilder(prefix).append("----").toString();
        clauses.forEach(s -> {
            Clause clause = (Clause) s;
            System.out.println(String.format("\n%s%s", prefix, clause.getName()));
            LinkedList<ClauseForm> embegged = clause.getSubClauses();
            drawSubMenu(subPrefix, embegged);
        });
     }

    /**
     * Пробный прогон. Программа показательная, поэтому обойдемся без тестов.
     * @param args - параметры.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        LinkedList<ClauseForm> domesticWork = new LinkedList<>();
        domesticWork.add(new Clause("Помыть посуду"));
        domesticWork.add(new Clause("Постирать белье посуду"));
        domesticWork.add(new Clause("Выгулять собаку"));
        Clause domestic = new Clause("Домашние дела");
        domestic.setSubClauses(domesticWork);
        menu.addNewClause(domestic);
        Clause relax = new Clause("Хобби");
        menu.addNewClause(relax);
        LinkedList<ClauseForm> hardWork = new LinkedList<>();
        hardWork.add(new Clause("Обновить базу 1С"));
        hardWork.add(new Clause("Исправить запрос"));
        hardWork.add(new Clause("Написать письма"));
        Clause hard = new Clause("Рабочие дела");
        hard.setSubClauses(hardWork);
        menu.addNewClause(hard);
        menu.draw();
    }
}
