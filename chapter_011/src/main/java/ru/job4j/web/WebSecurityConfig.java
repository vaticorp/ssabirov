/*
package ru.job4j.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

*/
/**
 * This class represents class for spring-security.
 * @author Svyatoslav Sabirov.
 * @since 21.06.2018
 * @version 7.
 *//*


@Configuration
@EnableTransactionManagement
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select login, password, TRUE from users where login =?")
                .authoritiesByUsernameQuery(
                        "select login, 'ROLE_ADMIN' from users where login =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/list*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/list*").permitAll()
                */
/*.anyRequest().permitAll()*//*

                .and()
                .formLogin().loginPage("/auto.do")
                .usernameParameter("login").passwordParameter("password").failureForwardUrl("/fail")
                .and()
                .logout().logoutSuccessUrl("/login.do?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }
}
*/
