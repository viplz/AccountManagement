package com.exam.base;

import java.util.List;

public class Pagination<T> {

	// 当前页第一条数据的位置
	private int start;
	// 每页记录数
	private int pageSize;
	// 总页数
	private int pageMax;
	// 总记录数(未过滤)
	private int recordsTotal;
	// 记录数(过滤后)
	private int recordsFiltered;
	//结果集存放List
    private List<T> data;

    private int draw;
    
	public Pagination() {
		start = 0;
		pageSize = 10;
	}

	public Pagination(int start, int pageSize, int recordsTotal, List<T> data) {
		this.start=start;
		this.pageSize=pageSize;
		this.recordsTotal=recordsTotal;
		this.recordsFiltered=recordsTotal;
		this.data=data;
		this.pageMax = (recordsTotal - 1) / pageSize + 1;
	}
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageMax() {
		return pageMax;
	}

	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
}
