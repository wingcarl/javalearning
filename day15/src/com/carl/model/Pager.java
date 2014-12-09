package com.carl.model;

import java.util.List;

public class Pager {

	private List records;
	private int pageSize = 10;
	private int pageNum;
	private int totalPage;
	private int startIndex;
	private int totalRecords;
	
	private int startPage;
	private int endPage;
	
	private String servletUrl;
	
	public Pager(int pageNum,int totalRecords){
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		startIndex = (pageNum-1)*pageSize;
		totalPage = totalRecords%pageSize==0?(totalRecords/pageSize):(totalRecords/pageSize+1);
		if(totalPage<=9){
			startPage = 1;
			endPage = 9;
		}else{
			startPage = pageNum-4;
			endPage = pageNum+4;
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalPage){
				endPage = totalPage;
				startPage = totalPage-8;
			}
		}
	}
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getServletUrl() {
		return servletUrl;
	}
	public void setServletUrl(String servletUrl) {
		this.servletUrl = servletUrl;
	}
	
}
