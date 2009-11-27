package com.chinacnd.framework.util;

/**
 * @author Hades
 */
public class AssertUtils {

    public static void assertHasText(String text, String description) {
        if (!StringUtils.hasText(text)) {
            throw new AssertError(description);
        }
    }

    public static void assertNotNull(Object object, String description) {
        if (object == null) {
            throw new AssertError(description);
        }
    }

    public static class AssertError extends RuntimeException {

        public AssertError(String message) {
            super(message);
        }
    }
}
