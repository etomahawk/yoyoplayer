package com.chinacnd.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class TimingLogger {

    private static final Logger logger = LoggerFactory.getLogger(TimingLogger.class);
    private static ThreadLocal<Date> startTime = new ThreadLocal<Date>();
    private static final String TIME_TOKEN = "#time#";

    public static void log(String message) {
        try {
            Date endTime = new Date();
            if (startTime.get() != null) {
                long usage = endTime.getTime() - startTime.get().getTime();
                logger.info(getLoggingMessage(message, usage));
            }
            startTime.set(endTime);
        } catch (Exception e) {
            //ignore the exception
        }
    }

    private static String getLoggingMessage(String message, long usage) {
        if (StringUtils.hasText(message)) {
            message = message.replaceAll(TIME_TOKEN, usage + " ms");
        }
        return message;
    }
}
