package ru.job4j.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class represents start-class for parsing.
 * @author Svyatoslav Sabirov.
 * @since 02.04.2018
 * @version 18.
 */
public class Parser {

    private String url;
    private String login;
    private String password;
    private String timeUnit;
    private int iteration;
    private String checkQuery;
    private String jobQuery;
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private final Logger logger = LoggerFactory.getLogger(Parser.class);

    public String getCheckQuery() {
        return checkQuery;
    }

    public String getJobQuery() {
        return jobQuery;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public int getIteration() {
        return iteration;
    }

    public Logger getLogger() {
        return logger;
    }

    public void readProperty() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("chapter_006/src/main/java/ru/job4j/parser/config.properties");) {
            property.load(fis);
            url = property.getProperty("url");
            login = property.getProperty("login");
            password = property.getProperty("password");
            timeUnit = property.getProperty("timeUnit");
            checkQuery = property.getProperty("checkQuery");
            jobQuery = property.getProperty("jobQuery");
            iteration = Integer.parseInt(property.getProperty("iteration"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            System.out.println(e.toString());
        }
    }

    public void startJob(Task task) {
        service.scheduleWithFixedDelay(task, 0, iteration, TimeUnit.valueOf(timeUnit));
        service.execute(task);
    }

    public static void main(String[] args) {
        Parser iteration = new Parser();
        iteration.readProperty();
        Task parsing = new Task(iteration);
        iteration.startJob(parsing);
    }
}
