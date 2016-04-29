package org.smart4j.sample.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.framework.util.MapUtil;
import org.smart4j.framework.util.Page;
import org.smart4j.framework.util.StringUtil;
import org.smart4j.sample.entity.User;
import org.smart4j.sample.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findUserList() {
		return DataSet.selectList(User.class);
	}

	@Override
	public User findUser(long id) {
		return DataSet.select(User.class, "id = ?", id);
	}

	@Override
	@Transaction
	public boolean saveUser(Map<String, Object> fieldMap) {
		return DataSet.insert(User.class, fieldMap);
	}

	@Override
	@Transaction
	public boolean updateUser(long id, Map<String, Object> fieldMap) {
		return DataSet.update(User.class, fieldMap, "id = ?", id);
	}

	@Override
	@Transaction
	public boolean deleteUser(long id) {
		return DataSet.delete(User.class, "id = ?", id);
	}

	@Override
	public Pager<User> searchPager(int pageNumber, int pageSize,
			Map<String, String> queryMap) {
        String where = "";
        if (MapUtil.isNotEmpty(queryMap)) {
            String userName = queryMap.get("userName");
            if (StringUtil.isNotEmpty(userName)) {
                where += "username like '%" + userName + "%'";
            }
        }

        String sort = "id asc";

        long totalRecord = DataSet.selectCount(User.class, where);
        List<User> userList = DataSet.selectListForPager(pageNumber, pageSize, User.class, where, sort);

        return new Pager<User>(pageNumber, pageSize, totalRecord, userList);
	}

	@Override
	public List<User> firstPager(Page page) {
		Pager<User> pager = this.searchPager(1, 10, null);
		if(pager != null){
			page.setRecordCount(pager.getTotalRecord());
			page.setPageCount(pager.getTotalPage());
			return pager.getRecordList();
		}else{
			return null;
		}
	}
}
