/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chinacnd.framework.util;

import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hadeslee
 */
public class BeanUtilsTest {
    @Test
    public void testConvertObjectToMap(){
       OperationResultJson or = new OperationResultJson();
       String messageContent = "Hello world!";
       or.setMessage(messageContent);
       or.setSuccess(true);
       or.setTimeout(false);
       Map<String,Object> map = BeanUtils.convertObjectToMap(or);
       Assert.assertEquals(messageContent, map.get("message"));
       Assert.assertEquals(true, map.get("success"));
       Assert.assertEquals(false, map.get("timeout"));
       Assert.assertNull(map.get("errors"));
    }
}
