package org.smart4j.framework.entity;

import java.util.Date;

/**
@ClassName: Log
@Description: 日志类
@author BEE 
@date 2016-4-19 下午2:56:35
 */
public class Log {

	private String id;
	private String statement;
	private Date operateTime;
	private int type;
	private String userid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}	
	
}
