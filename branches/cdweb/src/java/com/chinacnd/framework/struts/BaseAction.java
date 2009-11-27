/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.struts;

import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.framework.util.BeanUtils;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Hadeslee
 */
public abstract class BaseAction extends ActionSupport {

    protected final Logger log = Logger.getLogger(this.getClass());
    public static final String JSON_RESULT = "__JSON_RESULT__";
    private Object jsonRoot;

    public Object getJsonRoot() {
        return jsonRoot;
    }
    public void setJsonMap(Map<String,Object> map){
        map.put("success", true);
        map.put("timeout", false);
        jsonRoot = map;
    }
    /**
     * 设置一个将要被序列化成json的对象
     * 设置以后，本类会自动添加上相关的属性
     * 比如success,timeout
     * @param obj
     */
    public void setJsonObject(Object obj) {
        Map<String, Object> root = BeanUtils.convertObjectToMap(obj);
        root.put("success", true);
        root.put("timeout", false);
        jsonRoot = root;
    }

    /**
     * 设置一个请求操作的结果对象
     * 此对象将直接序列化成JSON，不会再附加相关的属性
     * @param obj
     */
    public void setJsonObject(OperationResultJson obj) {
        jsonRoot = BeanUtils.convertObjectToMap(obj);
    }

    public void setJsonTree(List<?> treeList) {
        jsonRoot = treeList;
    }

    /**
     * 设置一个列表，使之成为JSON对象里面的
     * list属性，并为之添加success,timeout的属性
     * @param list
     */
    public void setJsonList(List<?> list) {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("list", list);
        root.put("success", true);
        root.put("timeout", false);
        this.jsonRoot = root;
    }

    public void setJsonList(List<?> list, int totalSize) {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("list", list);
        root.put("success", true);
        root.put("timeout", false);
        root.put("totalSize", totalSize);
        this.jsonRoot = root;
    }

    protected SessionContext getSessionContext() {
        return SessionContext.getSessionContext();
    }
}
