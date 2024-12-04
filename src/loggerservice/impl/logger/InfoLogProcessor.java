package loggerservice.impl.logger;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;
import loggerservice.impl.LoggerConfigService;

import java.time.LocalDateTime;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(LogLevel logLevel, String message, String namespace, LoggerConfigService loggerConfigService) {
        if (logLevel == LogLevel.INFO) {
            SinkType sinkType =  loggerConfigService.getSinkType(logLevel);
            System.out.println(sinkType +  " INFO: " + message + " " + namespace + " " + LocalDateTime.now());
        } else if (!loggerConfigService.getLogLevel().equals(LogLevel.INFO)) {
            super.log(logLevel, message, namespace, loggerConfigService);
        }
    }
}
