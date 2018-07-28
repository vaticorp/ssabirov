package menu.form;

import menu.actions.MenuAction;

/**
 * This class represents menu section.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 7.
 */
public interface ClauseForm {
    void addAction(MenuAction action);
    void addSubClause(ClauseForm clauseForm);
}
