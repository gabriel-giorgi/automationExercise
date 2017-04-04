package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import static utils.PropertiesHandler.getPropertyValue;

/**
 * Created by gabriel.giorgi on 4/4/2017.
 */
public class LogHandler {


// Static factory method for logger instance
    public static Logger initLogging () {
        Logger logger = Logger.getLogger("LogHandler");
        PropertyConfigurator.configure(getPropertyValue("pathLog4jProperties"));
        return logger;
    }
}
