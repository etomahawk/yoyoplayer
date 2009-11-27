package com.chinacnd.framework.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hades Li
 */
public class PathMapper {

    private final Set<String> patterns = new HashSet<String>();

    public void addPattern(String pattern) {
        if (pattern != null) {
            patterns.add(pattern);
        }
    }

    public void addPattern(Collection<String> pts) {
        patterns.addAll(pts);
    }

    public String toString() {
        return patterns.toString();
    }

    /**
     * find the matcher partern among the pattern
     * dafault matcher isCaseSensitive
     *
     * @param path The path to matcher
     * @return the matcher pattern
     */
    public String findMatcherPattern(String path) {
        return findKey(path, true);
    }

    public String findMatcherPattern(String path, boolean isCaseSensitive) {
        return findKey(path, isCaseSensitive);
    }

    /**
     * Find exact key in mappings.
     */
    private String findKey(String path, boolean isCaseSensitive) {
        if (path == null) {
            path = "/";
        }
        String result = findExactKey(path, isCaseSensitive);
        if (result == null) {
            result = findComplexKey(path, isCaseSensitive);
        }
        return result;
    }

    /**
     * Check if path matches exact pattern ( /blah/blah.jsp ).
     */
    private String findExactKey(String path, boolean isCaseSensitive) {
        for (String s : patterns) {
            if (s.equals(path)) {
                return s;
            } else if (!isCaseSensitive && s.equalsIgnoreCase(path)) {
                return s;
            }
        }
        return null;
    }

    private String findComplexKey(String path, boolean isCaseSensitive) {
        String result = null;
        for (String key : patterns) {
            if (key.length() > 1 && (key.indexOf('?') != -1 || key.indexOf('*') != -1) && match(key, path, isCaseSensitive)) {
                if (result == null || key.length() > result.length()) {
                    // longest key wins
                    result = key;
                }
            }
        }
        return result;
    }

    private static boolean match(String pattern, String str, boolean isCaseSensitive) {
        char[] patArr = pattern.toCharArray();
        char[] strArr = str.toCharArray();
        int patIdxStart = 0;
        int patIdxEnd = patArr.length - 1;
        int strIdxStart = 0;
        int strIdxEnd = strArr.length - 1;
        char ch;
        boolean containsStar = false;
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] == '*') {
                containsStar = true;
                break;
            }
        }
        if (!containsStar) {
            // No '*'s, so we make a shortcut
            if (patIdxEnd != strIdxEnd) {
                return false; // Pattern and string do not have the same size
            }
            for (int i = 0; i <= patIdxEnd; i++) {
                ch = patArr[i];
                if (ch != '?') {
                    if (isCaseSensitive && ch != strArr[i]) {
                        return false; // Character mismatch
                    }
                    if (!isCaseSensitive && Character.toUpperCase(ch) !=
                            Character.toUpperCase(strArr[i])) {
                        return false; // Character mismatch
                    }
                }
            }
            return true; // String matches against pattern
        }
        if (patIdxEnd == 0) {
            return true; // Pattern contains only '*', which matches anything
        }
        // Process characters before first star
        while ((ch = patArr[patIdxStart]) != '*' && strIdxStart <= strIdxEnd) {
            if (ch != '?') {
                if (isCaseSensitive && ch != strArr[strIdxStart]) {
                    return false; // Character mismatch
                }
                if (!isCaseSensitive && Character.toUpperCase(ch) !=
                        Character.toUpperCase(strArr[strIdxStart])) {
                    return false; // Character mismatch
                }
            }
            patIdxStart++;
            strIdxStart++;
        }
        if (strIdxStart > strIdxEnd) {
            // All characters in the string are used. Check if only '*'s are
            // left in the pattern. If so, we succeeded. Otherwise failure.
            for (int i = patIdxStart; i <= patIdxEnd; i++) {
                if (patArr[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        // Process characters after last star
        while ((ch = patArr[patIdxEnd]) != '*' && strIdxStart <= strIdxEnd) {
            if (ch != '?') {
                if (isCaseSensitive && ch != strArr[strIdxEnd]) {
                    return false; // Character mismatch
                }
                if (!isCaseSensitive && Character.toUpperCase(ch) !=
                        Character.toUpperCase(strArr[strIdxEnd])) {
                    return false; // Character mismatch
                }
            }
            patIdxEnd--;
            strIdxEnd--;
        }
        if (strIdxStart > strIdxEnd) {
            // All characters in the string are used. Check if only '*'s are
            // left in the pattern. If so, we succeeded. Otherwise failure.
            for (int i = patIdxStart; i <= patIdxEnd; i++) {
                if (patArr[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        // process pattern between stars. padIdxStart and patIdxEnd point
        // always to a '*'.
        while (patIdxStart != patIdxEnd && strIdxStart <= strIdxEnd) {
            int patIdxTmp = -1;
            for (int i = patIdxStart + 1; i <= patIdxEnd; i++) {
                if (patArr[i] == '*') {
                    patIdxTmp = i;
                    break;
                }
            }
            if (patIdxTmp == patIdxStart + 1) {
                // Two stars next to each other, skip the first one.
                patIdxStart++;
                continue;
            }
            // Find the pattern between padIdxStart & padIdxTmp in str between
            // strIdxStart & strIdxEnd
            int patLength = (patIdxTmp - patIdxStart - 1);
            int strLength = (strIdxEnd - strIdxStart + 1);
            int foundIdx = -1;
            strLoop:
            for (int i = 0; i <= strLength - patLength; i++) {
                for (int j = 0; j < patLength; j++) {
                    ch = patArr[patIdxStart + j + 1];
                    if (ch != '?') {
                        if (isCaseSensitive && ch != strArr[strIdxStart + i + j]) {
                            continue strLoop;
                        }
                        if (!isCaseSensitive && Character.toUpperCase(ch) !=
                                Character.toUpperCase(strArr[strIdxStart + i + j])) {
                            continue strLoop;
                        }
                    }
                }
                foundIdx = strIdxStart + i;
                break;
            }
            if (foundIdx == -1) {
                return false;
            }
            patIdxStart = patIdxTmp;
            strIdxStart = foundIdx + patLength;
        }
        // All characters in the string are used. Check if only '*'s are left
        // in the pattern. If so, we succeeded. Otherwise failure.
        for (int i = patIdxStart; i <= patIdxEnd; i++) {
            if (patArr[i] != '*') {
                return false;
            }
        }
        return true;
    }
}