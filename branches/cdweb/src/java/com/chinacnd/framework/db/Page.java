package com.chinacnd.framework.db;

import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;
import java.io.Serializable;

public class Page implements Serializable {

    public static final int DEFAULT_PAGE_SIZE = 20;
    private int limit;//取多少条记录
    private int start;//从哪里取数据
    private int totalCount;//总共有多少条数据

    public Page() {
        this(DEFAULT_PAGE_SIZE);
    }

    public Page(int limit) {
        this.limit = limit;
    }

    public static Page from(RequestRecordForm form) {
        Page page = new Page();
        page.setLimit(form.getLimit());
        page.setStart(form.getStart());
        return page;
    }

    public int getPageCount() {
        if (totalCount > 0) {
            return totalCount % limit == 0 ? totalCount / limit : totalCount / limit + 1;
        } else {
            return 0;
        }
    }

    public int getPageIndex() {
        return (start + 1) % limit == 0 ? (start + 1) / limit : (start + 1) / limit + 1;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
