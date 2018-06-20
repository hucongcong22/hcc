package com.aifule.jxc.site.common;

public class MongoPage {

    public static final int DEFAULT_PAGE_SIZE = 20;

    protected int start = 0;
    protected int end = 0;
    protected int totalRecord = -1; // 总记录数, 默认为-1, 表示需要查询

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
}
