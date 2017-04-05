package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import static utils.PropertiesHandler.getPropertyValue;

/**
 * Created by gabriel.giorgi on 4/4/2017.
 */
public class LogHandler {

    private static String log4jConfigURL = LogHandler.class.getClassLoader().getResource("log4j.properties").getFile();

    // Static factory method for logger instance
    public static Logger initLogging () {
        Logger logger = Logger.getLogger("LogHandler");
        PropertyConfigurator.configure(log4jConfigURL);
        return logger;
    }
}
