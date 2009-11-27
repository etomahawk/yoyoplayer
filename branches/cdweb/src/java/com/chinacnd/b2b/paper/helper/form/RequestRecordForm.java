/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form;

/**
 * 所有以AJAX请求数据的FORM
 * @author Hadeslee
 */
public class RequestRecordForm {

    private int start;//从哪里开始
    private int limit = Integer.MAX_VALUE;//最多少条
    private String sort;//排序的属性
    private String dir;//排序的方向
    private transient int totalSize;//总大小，是一个回传的参数,由serivce层写入，由action读出

    public String getDir() {
        return dir;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
