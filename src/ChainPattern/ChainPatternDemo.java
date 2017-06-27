
package ChainPattern;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainPatternDemo {
    
    private static AbstractLogger getChainOfLoggers(){
    
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        
        errorLogger.setNextLogger(fileLogger);
        errorLogger.setNextLogger(consoleLogger);
        
        return errorLogger;  
    }
    
    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        
        loggerChain.logMessage(AbstractLogger.INFO, "This is an info");
        
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is debug");
        
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error");

    }
 
}
