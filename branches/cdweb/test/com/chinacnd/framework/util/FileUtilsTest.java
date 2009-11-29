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
public class FileUtilsTest {

    @Test
    public void testGetExtention() {
        String f1 = "test.jpg";
        Assert.assertEquals("jpg", FileUtils.getExtention(f1));
        f1=".h";
        Assert.assertEquals("h", FileUtils.getExtention(f1));
        f1=".";
        Assert.assertEquals("", FileUtils.getExtention(f1));
        f1="Hello";
        Assert.assertEquals("", FileUtils.getExtention(f1));
    }
}
