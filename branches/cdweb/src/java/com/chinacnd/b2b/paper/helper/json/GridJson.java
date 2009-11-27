/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Genius
 */
public class GridJson<T> {

    private List<T> list = new ArrayList<T>();
    private int totalSize;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
