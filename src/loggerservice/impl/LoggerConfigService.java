package loggerservice.impl;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoggerConfigService {

    Map<LogLevel, SinkType> config = new HashMap<>();
    private LogLevel systemLogLevel;


    public void createConfig(LogLevel logLevel, SinkType sinkType) {
        System.out.println("Request received to create config for log level: " + logLevel + " and sink type: " + sinkType);
        config.put(logLevel, sinkType);
    }

    public void setLogLevel(String logLevel) {
        try {
            systemLogLevel = LogLevel.valueOf(logLevel);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid log level: " + logLevel);
            throw new IllegalArgumentException("Invalid log level: " + logLevel);
        }
    }

    public LogLevel getLogLevel() {
        return systemLogLevel;
    }

    public void displayConfig() {
        System.out.println("Current system log level: " + systemLogLevel);
        System.out.println("Current system config: " + config);
    }

    public SinkType getSinkType(LogLevel logLevel) {
        SinkType sinkType = config.get(logLevel);
        if (Objects.isNull(config)) {
            throw new IllegalArgumentException("No config found for log level: " + logLevel);
        }
        return sinkType;
    }
}
