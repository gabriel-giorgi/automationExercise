package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by gabriel.giorgi on 4/3/2017.
        */
public class PropertiesHandler {

    private static final String PROPERTY_PATH =
            PropertiesHandler.class.getClassLoader().getResource("config.properties").getFile();

    public static String getPropertyValue(final String key) {
            //Creating property
        Properties properties = new Properties();

        File file = new File(PROPERTY_PATH);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            //Loading property file
            properties.load(fileInput);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            //Closing the stream
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return properties.getProperty(key);
    }
}