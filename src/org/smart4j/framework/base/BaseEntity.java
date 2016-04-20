package org.smart4j.framework.base;

@SuppressWarnings("serial")
public abstract class BaseEntity extends BaseBean {
	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
