package loggerservice.impl.logger;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;
import loggerservice.impl.LoggerConfigService;

import java.time.LocalDateTime;

public class FatalLogProcessor extends LogProcessor {

    public FatalLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(LogLevel logLevel, String message, String namespace, LoggerConfigService loggerConfigService) {
        if (logLevel == LogLevel.FATAL) {
            SinkType sinkType =  loggerConfigService.getSinkType(logLevel);
            System.out.println(sinkType +  "  FATAL: " + message + " " + namespace + " " + LocalDateTime.now());
        } else if (!loggerConfigService.getLogLevel().equals(LogLevel.FATAL)) {
            super.log(logLevel, message, namespace, loggerConfigService);
        }
    }
}
