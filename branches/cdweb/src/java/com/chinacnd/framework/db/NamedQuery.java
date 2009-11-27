/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.db;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hadeslee
 */
public class NamedQuery {

    private final String queryName;
    private final Map<String, Object> map = new HashMap<String, Object>();

    public NamedQuery(String queryName) {
        this.queryName = queryName;
    }

    public NamedQuery addParameter(String name, Object value) {
        map.put(name, value);
        return this;
    }

    public String getQueryName() {
        return queryName;
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
