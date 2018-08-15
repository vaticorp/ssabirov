package io.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class represents class for reading properties.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 11.
 */
public class PropertyStorage implements Property {

    private int port;
    private String initialFolder;

    public PropertyStorage() {
        readProperties();
    }

    @Override
    public void readProperties() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("chapter_015/src/main/java/io/manager/config.properties");) {
            property.load(fis);
            port = Integer.parseInt(property.getProperty("port"));
            initialFolder = property.getProperty("folder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setInitialFolder(String initialFolder) {
        this.initialFolder = initialFolder;
    }

    public String getInitialFolder() {
        return initialFolder;
    }
}
