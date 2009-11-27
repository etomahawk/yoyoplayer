package com.chinacnd.framework.util;

import java.util.regex.Pattern;

public class ValidationUtils {
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b");

    public static boolean isEmail(String text) {
        return EMAIL_ADDRESS_PATTERN.matcher(text).matches();
    }
}
