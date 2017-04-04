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
            "C:\\Users\\gabriel.giorgi\\Desktop\\ExerciseSelenium\\src\\main\\resources\\config.properties";

    public static String getPropertyValue(final String key) {
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