package menu.form;

import menu.actions.MenuAction;

import java.util.LinkedList;

/**
 * This class represents class for single clause of menu.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 7.
 */
public class Clause implements ClauseForm {

    private MenuAction action;
    private String name;
    private LinkedList<ClauseForm> subClauses = new LinkedList<>();

    public Clause(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addAction(MenuAction action) {
        this.action = action;
    }

    public void setSubClauses(LinkedList<ClauseForm> subClauses) {
        this.subClauses = subClauses;
    }

    public LinkedList<ClauseForm> getSubClauses() {
        return subClauses;
    }

    @Override
    public void addSubClause(ClauseForm clauseForm) {
        subClauses.add(clauseForm);
    }

    @Override
    public String toString() {
        return "Задача " + name;
    }
}
