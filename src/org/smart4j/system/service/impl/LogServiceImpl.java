package org.smart4j.system.service.impl;

import java.util.List;

import org.smart4j.framework.entity.Log;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.system.service.ILogService;

@Service
public class LogServiceImpl implements ILogService {

	@Override
	public List<Log> findlist() {
		return DataSet.selectList(Log.class);
	}
}
