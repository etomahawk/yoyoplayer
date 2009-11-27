package com.chinacnd.framework.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Hades
 */
public class ExceptionUtils {
    public static String stackTrace(Exception e) {
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer, true));
        return writer.toString();
    }
}
