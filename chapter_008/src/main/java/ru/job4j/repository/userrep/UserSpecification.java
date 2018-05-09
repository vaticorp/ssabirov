package ru.job4j.repository.userrep;

import ru.job4j.repository.CommonSpecification;

/**
 * This class represents User specification.
 * @author Svyatoslav Sabirov.
 * @since 08.05.2018
 * @version 9.
 */
public class UserSpecification implements CommonSpecification {

    private String where;
    private String script = "SELECT name, age, role, address_id FROM users";

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setWhere(String where) {
        this.where = String.format(" WHERE %s",where);
    }

    public String getWhere() {
        return where;
    }

    /**
     * Как я понял,метод необходим для конкретного указания условия выполнения
     * @param value - объект.
     * @return - результат проверки условия.
     */
    @Override
    public boolean specified(Object value) {
        return false;
    }

    @Override
    public String toSqlClauses() {
        return String.format("%s %s",getScript(),getWhere());
    }
}
