package com.aifule.jxc.core.mybatispage;

public class Page<T> {

    public static final int DEFAULT_PAGE_SIZE = 4;

    // protected int pageNo = 1; // 当前页, 默认为第1页
    // protected int pageSize = DEFAULT_PAGE_SIZE; // 每页记录数
    // protected long totalRecord = -1; // 总记录数, 默认为-1, 表示需要查询
    // protected int totalPage = -1; // 总页数, 默认为-1, 表示需要计算

    //	protected List<T> results; // 当前页记录List形式
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

//	public List<T> getResults() {
//		return results;
//	}
//
//	public void setResults(List<T> results) {
//		this.results = results;
//	}

}
