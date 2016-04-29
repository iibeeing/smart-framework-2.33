package org.smart4j.framework.util;

public class Page {
	private int pageNumber = 15;// 每页显示数量
	private int recordCount = 0;// 总记录显示
	private int pageCount = 1;// 总页数
	private int pageIndex = 1;// 当前页数编号
	

	/**
	 * 获取每页显示数量
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * 设置每页显示数量
	 * 
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber) {
		try {
			this.pageNumber = pageNumber;
		} catch (Exception e) {
			this.pageNumber = 1;
		}
		if (pageNumber < 1) {
			this.pageNumber = 1;
		}
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		if (recordCount < 0) {
			this.recordCount = 0;
		}
		this.pageCount = (this.recordCount + this.pageNumber -1)/this.pageNumber;
	}

	public int getPageCount() {
//		this.pageCount = this.recordCount / this.pageNumber;
//		if (this.recordCount % this.pageNumber != 0) {
//			this.pageCount++;
//		}
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
		
	}

	public int getPageIndex() {
	   if (pageIndex > pageCount) {
	      pageIndex = pageCount;
	   }
	   if (pageIndex < 1) {
	      this.pageIndex = 1;
	   }
		
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
