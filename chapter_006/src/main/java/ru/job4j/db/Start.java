package ru.job4j.db;

import java.io.File;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * This class represents Start.
 * @author Svyatoslav Sabirov.
 * @since 30.03.2018
 * @version 16.
 */
public class Start implements Serializable {

    private String url;
    private String login;
    private String password;
    private int numbers;
    private String pathDBFile;
    private String pathXlsFile;
    private String pathTransformationFile;

    public String getPathDBFile() {
        return pathDBFile;
    }

    public void setPathDBFile(String pathDBFile) {
        this.pathDBFile = pathDBFile;
    }

    public String getPathXlsFile() {
        return pathXlsFile;
    }

    public void setPathXlsFile(String pathXlsFile) {
        this.pathXlsFile = pathXlsFile;
    }

    public String getPathTransformationFile() {
        return pathTransformationFile;
    }

    public void setPathTransformationFile(String pathTransformationFile) {
        this.pathTransformationFile = pathTransformationFile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, login, password, numbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Start that = (Start) obj;
        return that.login.equals(this.login)
                && that.url.equals(this.url)
                && that.numbers == this.numbers
                && that.password == this.password;
    }

    /**
     * Преобразуем первый xml во второй по правилам xslt.
     * @param action - наш объект старта.
     */
    public static void covertXmlWithXLST(Start action) {

        File xmlFile = new File(action.getPathDBFile());
        File xsltFile = new File(action.getPathXlsFile());
        Source xmlSource = new StreamSource(xmlFile);
        Source xsltSource = new StreamSource(xsltFile);
        TransformerFactory transFact = TransformerFactory.newInstance();
        try {
            Transformer trans = transFact.newTransformer(xsltSource);
            trans.transform(xmlSource, new StreamResult(new File(action.getPathTransformationFile())));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Процедура получает данные из БД формирует XML
     * @param action
     */
    public static void getInfoAndCreateXML(Start action) {
        try (Connection connection = DriverManager.getConnection(action.getUrl(), action.getLogin(), action.getPassword());
            PreparedStatement prpStat = connection.prepareStatement("select field from test")) {
            try (ResultSet rs = prpStat.executeQuery();) {
                Entries entry = new Entries();
                List<Entry> list = new ArrayList<>();
                while (rs.next()) {
                    Entry innerEntry = new Entry();
                    innerEntry.setField(rs.getInt(1));
                    list.add(innerEntry);
                }
                entry.setField(list);
                try {
                    File file = new File(action.getPathDBFile());
                    JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    jaxbMarshaller.marshal(entry, file);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Процедура выполняет хранимую процедуру Postgres,которая в свою очередь, проверяет
     * есть ли таблица test в БД.Если ее нет,то создает и заполняет ее количеством значений,
     * которое передается через параметр
     * @param action - наш объект старта.
     */
    public static void createStructureAndFill(Start action) {
        try (Connection connection = DriverManager.getConnection(action.getUrl(), action.getLogin(), action.getPassword());
            PreparedStatement prpStat = connection.prepareStatement("SELECT addnumbers(?)")) {
            prpStat.setInt(1, action.getNumbers());
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    if (rs.getInt(1) != 1) {
                        throw new PostgresException("Ошибка получения данных из информационной базы!");
                    }
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Процедура преобразует xml-файл в объект entriesUnpack с помощью JAXB.
     * @param action - наш объект старта.
     * @return - преобразованный объект EntriesUnparse.
     */
    public static EntriesUnparse convertXmlToEntity(Start action) {
        EntriesUnparse entriesUnpack = null;
        try {
            File file = new File(action.getPathTransformationFile());
            JAXBContext jaxbContext = JAXBContext.newInstance(EntriesUnparse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            entriesUnpack = (EntriesUnparse) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return entriesUnpack;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {

        Start action = new Start();
        action.setLogin("postgres");
        action.setPassword("1");
        action.setNumbers(1000000);
        action.setUrl("url = jdbc:postgresql://localhost:5432/xml");
        action.setPathDBFile("chapter_006\\src\\main\\java\\ru\\job4j\\db\\1.xml");
        action.setPathXlsFile("chapter_006\\src\\main\\java\\ru\\job4j\\db\\Transformation.xsl");
        action.setPathTransformationFile("chapter_006\\src\\main\\java\\ru\\job4j\\db\\2.xml");

        createStructureAndFill(action);
        getInfoAndCreateXML(action);
        covertXmlWithXLST(action);
        EntriesUnparse entry = convertXmlToEntity(action);

        int sum = 0;
        List<EntryUnparse> list = entry.getField();
        for (EntryUnparse current : list) {
            sum += current.getField();
        }
        System.out.println(String.format("Итоговая сумма равна: %d", sum));
    }
}

