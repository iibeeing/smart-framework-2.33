package org.smart4j.sample.service.impl;

import java.util.List;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.sample.entity.Log;
import org.smart4j.sample.service.ILogService;

@Service
public class LogServiceImpl implements ILogService {

	@Override
	public List<Log> findlist() {
		return DataSet.selectListWithSort(Log.class,"operateTime desc");
	}
}
