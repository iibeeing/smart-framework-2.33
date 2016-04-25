package org.smart4j.sample.service;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.sample.entity.ProductBean;
import org.smart4j.sample.entity.User;

public interface UserService {
	List<User> findUserList();

    User findUser(long id);

    boolean saveUser(Map<String, Object> fieldMap);

    boolean updateUser(long id, Map<String, Object> fieldMap);

    boolean deleteUser(long id);

    Pager<User> searchPager(int pageNumber, int pageSize, Map<String, String> formFieldMap);
}
