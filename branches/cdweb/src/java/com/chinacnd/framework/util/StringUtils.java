package com.chinacnd.framework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hades
 */
public class StringUtils {

    private static String PERCENTAGE_PATTERN = "###0.00%";

    public static String[] deleteDuplicat(String[] strings) {
        Set<String> as = new HashSet<String>();
        for (String s : strings) {
            as.add(s);
        }
        return as.toArray(new String[as.size()]);
    }

    public static String encodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "utf8");
        } catch (UnsupportedEncodingException ex) {
        }
        return s;
    }

    public static String decodeUTF8(String s) {
        try {
            return URLDecoder.decode(s, "utf8");
        } catch (UnsupportedEncodingException ex) {
        }
        return s;
    }

    public static String trim(String text) {
        return text == null ? null : text.trim();
    }

    public static boolean hasText(String text) {
        return text != null && text.trim().length() != 0;
    }

    public static boolean equals(String text1, String text2) {
        return text1 == null && text2 == null || text1 != null && text1.equals(text2);
    }

    /**
     * 检查字串长度是否大于等于指定长度，字串为空则为false;
     *
     * @param text   待检查字串
     * @param length 长度
     * @return
     */
    public static boolean lengthMoreThan(String text, int length) {
        return text != null && text.length() >= length;
    }

    public static boolean lengthBetween(String text, int minLen, int maxLen) {
        return text != null && text.length() >= minLen && text.length() <= maxLen;
    }

    public static String paddingLeft(String text, char paddingChar, int length) {
//      return org.apache.commons.lang.StringUtils.
        int index = 0;
        if (StringUtils.hasText(text)) {
            index = text.length();
        }
        StringBuilder stringBuilder = new StringBuilder(text == null ? "" : text);
        while (index < length) {
            stringBuilder.insert(0, paddingChar);
            index++;
        }
        return stringBuilder.toString();
    }

    public static boolean contains(String text, String target) {
        if (text == null && target != null) {
            return false;
        }
        if (text == null) {
            return true;
        }
        return target == null || text.contains(target);
    }

    public static boolean isEmpty(String text) {
        return !hasText(text);
    }

    public static String truncate(String text, int maxLength) {
        if (text == null) {
            return null;
        }
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength);
    }

    public static String[] split(String string, String delimit) {
        if (StringUtils.isEmpty(string)) {
            return new String[0];
        }
        String[] strings = string.split(delimit);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
        return strings;

    }

    public static String toString(List<String> entries, String delimit, boolean withQuote) {
        if (entries.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String entry : entries) {
            if (withQuote) {
                entry = entry.replaceAll("'", "''");
                builder.append('\'');
            }
            builder.append(entry);
            if (withQuote) {
                builder.append('\'');
            }
            builder.append(delimit);
        }
        return builder.substring(0, builder.length() - delimit.length());
    }

    public static boolean isNumber(String input) {
        return (isFloat(input) || isDouble(input) || isInteger(input) || isLong(input));
    }

    public static boolean isLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException exe) {
            return false;
        }
    }

    public static boolean isFloat(String input) {
        try {
            float f = Float.parseFloat(input);
            if (Float.isNaN(f) || f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isDouble(String input) {
        try {
            double d = Double.parseDouble(input);
            return !(Double.isNaN(d) || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY);
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    public static String formatPerenctage(double percentage) {
        if (percentage == 0) {
            return "0.00%";
        }
        return formatDicimal(percentage, PERCENTAGE_PATTERN);
    }

    public static String formatDicimal(double percentage, String pattern) {
        DecimalFormat f = new DecimalFormat(pattern);
        return f.format(percentage);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return f.format(date);
    }

    public static String formatDicimalWithFractionDigits(double percentage, int minimumFractionDigits, int maximumFractionDigits) {
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(maximumFractionDigits);
        f.setMinimumFractionDigits(minimumFractionDigits);
        return f.format(percentage);
    }

    public static String arrayToString(String[] a, String separator) {
        StringBuffer result = new StringBuffer();
        if (a == null) {
            return "";
        }
        if (a.length > 0) {
            result.append(a[0]);
            for (int i = 1; i < a.length; i++) {
                result.append(separator);
                result.append(a[i]);
            }
        }
        return result.toString();
    }

    public static List<String> splitToList(String input, String delimit) {
        return CollectionUtils.makeList(split(input, delimit));
    }

    public static String htmlEncode(String text) {
        if (text == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // encode standard ASCII characters into HTML entities where needed
            if (c < '\200') {
                switch (c) {
                    case '"':
                        builder.append("&quot;");
                        break;
                    case '&':
                        builder.append("&amp;");
                        break;
                    case '<':
                        builder.append("&lt;");
                        break;
                    case '>':
                        builder.append("&gt;");
                        break;
                    case '\n':
                        builder.append("<br>");
                        break;
                    default:
                        builder.append(c);
                }
            } else if (c < '\377') {    // encode 'ugly' characters (ie Word "curvy" quotes etc)
                String hexChars = "0123456789ABCDEF";
                int a = c % 16;
                int b = (c - a) / 16;
                String hex = "" + hexChars.charAt(b) + hexChars.charAt(a);
                builder.append("&#x").append(hex).append(";");
            } else {       //add other characters back in - to handle charactersets other than ascii
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(com.chinacnd.framework.util.StringUtils.formatDicimalWithFractionDigits(0.4300f, 3, 2));
    }
}
