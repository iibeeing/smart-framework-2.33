package org.smart4j.sample.action;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.base.BaseAction;
import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.Page;
import org.smart4j.framework.util.WebUtil;
import org.smart4j.sample.entity.User;
import org.smart4j.sample.service.UserService;

@Action
public class UserAction extends BaseAction{

	// 分页对象
	protected Page page;
	
    @Inject
    private UserService userService;

    @Request.Get("/users")
    public View index() {
        //List<User> userList = userService.firstPager(page);
    	List<User> userList = userService.findUserList();
        DataContext.Request.put("userList", userList);
        //DataContext.Request.put("page", page);
        return new View("system/user/list.jsp");
    }
    
    @Request.Get("/searchusers")
    public View index(Params params) {
    	Map<String,Object> fieldMap = params.getFieldMap();
    	int pageNum = CastUtil.castInt(fieldMap.get("pageNum"));
//    	page.setPageNum(Integer.valueOf(pageNum));
    	
        List<User> userList = userService.findUserList();
        DataContext.Request.put("userList", userList);
        return new View("system/user/list.jsp");
    }
    
    
/*    @Request.Get("/users")
    public Result index() {
        Pager<User> usersPager = userService.searchPager(1, 10, null);
        return new Result(true).data(usersPager);
    }*/
    
/*    @Request.Post("/user/search")
  public Result search(Params params) {
  	Map<String,Object> fieldMap = params.getFieldMap();
      int pageNumber = CastUtil.castInt(fieldMap.get(PAGE_NUMBER));
      int pageSize = CastUtil.castInt(fieldMap.get(PAGE_SIZE));
      String queryString = CastUtil.castString(fieldMap.get(QUERY_STRING));
      Map<String, String> queryMap = WebUtil.createQueryMap(queryString);
      Pager<User> productBeanPager = userService.searchPager(pageNumber, pageSize, queryMap);
      return new Result(true).data(productBeanPager);
  }*/

    @Request.Get("/user/create")
    public View create() {
    	return new View("system/user/create.jsp");
    }

    @Request.Post("/user/create")
    public Result save(Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.saveUser(fieldMap);
        return new Result(result);
    }

    @Request.Get("/user/{id}")
    public View edit(long id) {
        User user = userService.findUser(id);
        DataContext.Request.put("user", user);
        return new View("system/user/edit.jsp");
    }

    @Request.Put("/user/{id}")
    public Result update(long id, Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.updateUser(id, fieldMap);
        return new Result(result);
    }

    @Request.Delete("/user/{id}")
    public Result delete(long id) {
        boolean result = userService.deleteUser(id);
        return new Result(result);
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
}