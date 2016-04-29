package org.smart4j.framework.base;

import org.smart4j.framework.util.Page;

public abstract class BaseAction {
	
	  /*protected static final String PAGE_NUMBER = "pageNumber";
	  protected static final String PAGE_SIZE = "pageSize";
	  protected static final String QUERY_STRING = "queryString";
	  protected static final int ERROR_PARAM = 10;
	  protected static final int ERROR_DATA = 20;*/
	
	
	protected Page page = new Page();// 分页对象

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
