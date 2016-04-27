package org.smart4j.framework.util;

public class Page {
	//每页20行数据
	public long pageNumber = 10;
	//
	public long recordCount = 0;
	public long pageCount = 1;
	public long pageNum = 1;
	
	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		try {
			this.pageNumber = pageNumber;
		} catch (Exception e) {
			this.pageNumber = 1;
		}
		if (pageNumber < 1) {
			this.pageNumber = 1;
		}
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
		if (recordCount < 0) {
			this.recordCount = 0;
		}
		this.pageCount = (this.recordCount + this.pageNumber -1)/this.pageNumber;
	}

	public long getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
		
	}

	public long getPageNum() {
	   if (pageNum > pageCount) {
		   pageNum = pageCount;
	   }
	   if (pageNum < 1) {
	      this.pageNum = 1;
	   }
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	
}
