package ru.job4j.repository.rolerep;

import ru.job4j.models.Role;
import ru.job4j.repository.CommonSpecification;

/**
 * This class represents specification for Roles.
 * @author Svyatoslav Sabirov.
 * @since 07.05.2018
 * @version 10.
 */
public class RoleSpecificationByGetAll implements CommonSpecification<Role> {

    private String title;

    public RoleSpecificationByGetAll(String title) {
        this.title = title;
    }

    @Override
    public boolean specified(Role value) {
        return false;
    }

    @Override
    public String toSqlClauses() {
        return String.format("Select role from roles where title = %s", title);
    }
}
