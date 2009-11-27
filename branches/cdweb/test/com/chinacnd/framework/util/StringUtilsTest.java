/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.util;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hadeslee
 */
public class StringUtilsTest {

    @Test
    public void testHasText() {
        String s1 = "hello";
        Assert.assertTrue(StringUtils.hasText(s1));
        s1 = "";
        Assert.assertFalse(StringUtils.hasText(s1));
        s1 = "   ";
        Assert.assertFalse(StringUtils.hasText(s1));
        s1 = null;
        Assert.assertFalse(StringUtils.hasText(s1));
    }
}
