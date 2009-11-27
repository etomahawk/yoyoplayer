package com.chinacnd.framework.util;

import java.util.UUID;

/**
 * @author Hades
 */
public class UUIDUtils {

    private static long b = 1180000000000L;
    private static long seedUniquifier = System.currentTimeMillis() - b;
    private static final int DEFAULT_RADIX = 36;

    public static String getUniqueId(int length, int radix) {
        seedUniquifier++;
        String uniqueId = Long.toString(seedUniquifier, radix);

        int initialLength = uniqueId.length();
        int leftLength = initialLength - length;
        if (leftLength > 0) {
            uniqueId = uniqueId.substring(leftLength, initialLength);
        } else if (leftLength < 0) {
            StringBuilder buffer = new StringBuilder();
            while (leftLength < 0) {
                buffer.append('0');
                leftLength++;
            }
            buffer.append(uniqueId);
            uniqueId = buffer.toString();
        }
        return uniqueId;
    }

    public static String getUniqueId(int length) {
        return getUniqueId(length, DEFAULT_RADIX);
    }

    public static String getUniqueId() {
        return getUniqueId(8);
    }

    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
