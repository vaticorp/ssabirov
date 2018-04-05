package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents simple Task.
 * @author Svyatoslav Sabirov.
 * @since 02.04.2018
 * @version 9.
 */
public class Task extends Thread {

    private Parser entry;
    private Logger logger;
    private final Pattern pattern = Pattern.compile("(.*)(J|j)ava(?!(\\s*)(S|s)cript)(.*)");
    private final String startPage = "http://www.sql.ru/forum/job-offers";

    public Task(Parser entry) {
        this.entry = entry;
        this.logger = entry.getLogger();
    }

    public void getSetOfVacancies(String page) {
        try {
            Document doc = Jsoup.connect(startPage.concat("/").concat(page)).get();
            Elements jobsHeaderElements = doc.select("td.postslisttopic");
            Matcher matcher  = null;
            for (Element current: jobsHeaderElements) {
                Elements innerElements = current.children().get(0).getElementsByAttribute("href");
                String html = innerElements.html();
                matcher = pattern.matcher(html);
                if (matcher.matches()) {
                    doc = Jsoup.connect(innerElements.attr("href")).get();
                    Elements jobsElements = doc.select("table.msgTable");
                    Element firstMessage = jobsElements.get(0);
                    String description = firstMessage.select("td.msgBody").get(1).text();
                    String authorInfo = firstMessage.select("td.msgBody").get(0).text();
                    int position = authorInfo.indexOf("Member");
                    String author = authorInfo.substring(0, position - 1);
                    String createInfo = firstMessage.select("td.msgFooter").get(0).text();
                    position = createInfo.indexOf("[");
                    String create = createInfo.substring(0, position - 1);
                    String newcreate = create.substring(0, create.length() - 3);
                    Timestamp timeStamp = convertDataToStamp(newcreate);
                    insertNewVacancy(author, description, timeStamp);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void insertNewVacancy(String author, String description, Timestamp create) {
        try(Connection con = DriverManager.getConnection(entry.getUrl(), entry.getLogin(), entry.getPassword());
            PreparedStatement stmt = con.prepareStatement(entry.getJobQuery());) {
            stmt.setString(1, description);
            stmt.setString(2, author);
            stmt.setTimestamp(3, create);
            stmt.setString(4, description);
            stmt.setTimestamp(5, create);
            stmt.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Функция получает количество вкладок на форуме вакансий и поочередно передает номер вкладки
     * в процедуру заполнения вакансий БД.
     */
    public void handleAllPages() {
        try {
            Document doc = Jsoup.connect(startPage).get();
            Elements jobsHeaderElements = doc.select("table.sort_options");
            if (jobsHeaderElements.size() > 0) {
                Elements list = jobsHeaderElements.get(1).children().get(0).getElementsByAttribute("href");
                Element last = list.get(list.size() - 1);
                String ref = last.attr("href");
                String[] array = ref.split("/");
                int index = Integer.parseInt(array[array.length - 1]);
                for (int i = 1; i <= index; i++) {
                    String page = i == 1 ? "" : String.valueOf(i);
                    getSetOfVacancies(page);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void startLoadJobs() {
        try(Connection con = DriverManager.getConnection(entry.getUrl(), entry.getLogin(), entry.getPassword());
            PreparedStatement stmt = con.prepareStatement(entry.getCheckQuery());
            ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                int result = rs.getInt(1);
                if (result == 0) {
                    handleAllPages();
                } else {
                    getSetOfVacancies("");
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void run() {
        startLoadJobs();
    }

    public Timestamp convertDataToStamp(String dateTime) {
        if (dateTime.contains("сегодня") || dateTime.contains("вчера")) {
            SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy", new Locale("ru", "RU"));
            Calendar c = Calendar.getInstance();
            if (dateTime.contains("вчера")) {
                c.add(Calendar.DATE, -1);
            }
            String tempDateTime = sdf.format(c.getTime());
            int position = dateTime.indexOf(",");
            dateTime = tempDateTime + dateTime.substring(position + 1);
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMM yy, HH:mm", new Locale("ru", "RU"));
        LocalDateTime date = LocalDateTime.parse(dateTime, format);
        return Timestamp.valueOf(date);
    }
}
