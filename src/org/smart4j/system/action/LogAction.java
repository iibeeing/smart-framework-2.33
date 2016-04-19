package org.smart4j.system.action;

import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.system.service.ILogService;
import java.util.List;
import org.smart4j.framework.entity.Log;
@Action
public class LogAction {

    @Inject
    private ILogService logService;

    @Request.Get("/logs")
    public View index() {
        List<Log> list = logService.findlist();
        DataContext.Request.put("list", list);
        return new View("system/log/logs.jsp");
    }

}