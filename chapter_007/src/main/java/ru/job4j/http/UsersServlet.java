package ru.job4j.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents servlet for users.
 * @author Svyatoslav Sabirov.
 * @since 07.04.2018
 * @version 7.
 */
public class UsersServlet extends HttpServlet {

    private final UserStore users = UserStore.getInstance();

    /**
     * Выполняет создание нового пользователя. Пример запроса: /items/start?name=dima&login=corvin&email=qwe@mail.ru&createDate=1999-01-08
     * @param req - запрос.
     * @param resp - ответ.
     * @throws ServletException - исключение сервлета.
     * @throws IOException - сключение ввода-вывода.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        User people = new User(name, login, email, createDate);
        users.createUser(people);
        /*
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("POST complete " + email);
        writer.flush();
        */
    }

    /**
     * Получает пользователя по логину. Пример запроса: http://localhost:8080//items/start?login=corvin
     * @param req - запрос.
     * @param resp - ответ.
     * @throws ServletException - исключение сервлета.
     * @throws IOException - сключение ввода-вывода.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login").trim();
        User user = users.getUser(login);
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("I'LL"+ login  + "BE CRUD!" + user );
        writer.flush();
    }

    /**
     * Обновляет данные о почте пользователя. Пример запроса: /items/start?login=corvin&email=qwe@mail.ru
     * @param req - запрос.
     * @param resp - ответ.
     * @throws ServletException - исключение сервлета.
     * @throws IOException - сключение ввода-вывода.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //test commit
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        users.updateUser(login, email);
    }

    /**
     * Удаляет пользователя. Пример запроса: /items/start?login=corvin
     * @param req - запрос.
     * @param resp - ответ.
     * @throws ServletException - исключение сервлета.
     * @throws IOException - сключение ввода-вывода.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        users.deleteUser(login);
    }
}
