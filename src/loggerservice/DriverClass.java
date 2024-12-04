package loggerservice;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;
import loggerservice.impl.LoggerConfigService;
import loggerservice.impl.logger.*;

public class DriverClass {
    public static void main(String[] args) {

        // Setup Config Service
        LoggerConfigService loggerConfigService = new LoggerConfigService();
        loggerConfigService.setLogLevel("INFO");

        loggerConfigService.createConfig(LogLevel.INFO, SinkType.CONSOLE);
        loggerConfigService.createConfig(LogLevel.DEBUG, SinkType.CONSOLE);
        loggerConfigService.createConfig(LogLevel.WARN, SinkType.CONSOLE);
        loggerConfigService.createConfig(LogLevel.ERROR, SinkType.FILE);
        loggerConfigService.createConfig(LogLevel.FATAL, SinkType.FILE);

        loggerConfigService.displayConfig();

        // Setup Log Processor
        LogProcessor logProcessor = new FatalLogProcessor(new ErrorLogProcessor(new WarnLogProcessor(
                new InfoLogProcessor(new DebugLogProcessor(null)))));

        System.out.println("========================================================================================");

        loggerConfigService.setLogLevel("FATAL");

        loggerConfigService.displayConfig();

        logProcessor.log(LogLevel.FATAL, "This is an fatal log", "driver.java", loggerConfigService);
        logProcessor.log(LogLevel.ERROR, "This is an error log", "classroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.WARN, "This is an warm log", "classroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.INFO, "This is an info log", "teachersroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.DEBUG, "This is an debug log", "teachersroomhandler.java", loggerConfigService);


        System.out.println("=========================================================================================");

        loggerConfigService.setLogLevel("INFO");

        loggerConfigService.displayConfig();

        logProcessor.log(LogLevel.FATAL, "This is an fatal log", "driver.java", loggerConfigService);
        logProcessor.log(LogLevel.ERROR, "This is an error log", "classroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.WARN, "This is an warm log", "classroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.INFO, "This is an info log", "teachersroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.DEBUG, "This is an debug log", "teachersroomhandler.java", loggerConfigService);

        System.out.println("=========================================================================================");

        loggerConfigService.setLogLevel("WARN");

        loggerConfigService.displayConfig();

        logProcessor.log(LogLevel.FATAL, "This is an fatal log", "driver.java", loggerConfigService);
        logProcessor.log(LogLevel.ERROR, "This is an error log", "classroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.WARN, "This is an warm log", "classroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.INFO, "This is an info log", "teachersroomhandler.java", loggerConfigService);
        logProcessor.log(LogLevel.DEBUG, "This is an debug log", "teachersroomhandler.java", loggerConfigService);

        System.out.println("=========================================================================================");

        loggerConfigService.setLogLevel("WARN");
        loggerConfigService.displayConfig();
        for (int i = 0 ; i < 100; i++) {
            logProcessor.log(LogLevel.FATAL, "This is an fatal log" + i, "driver.java", loggerConfigService);
            logProcessor.log(LogLevel.ERROR, "This is an error log"+ i, "classroomhandler.java", loggerConfigService);
            logProcessor.log(LogLevel.WARN, "This is an warm log" + i, "classroomhandler.java", loggerConfigService);
            logProcessor.log(LogLevel.INFO, "This is an info log" + i, "teachersroomhandler.java", loggerConfigService);
            logProcessor.log(LogLevel.DEBUG, "This is an debug log"+ i, "teachersroomhandler.java", loggerConfigService);
        }
    }
}
