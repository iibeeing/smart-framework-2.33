package org.smart4j.framework;

import org.smart4j.framework.core.ConfigHelper;

/**
@ClassName: FrameworkConstant
@Description: 框架常量，包括配置文件名称及文件路径
@author BEE 
@date 2016-4-21 上午9:55:43
 */
public interface FrameworkConstant {

    String UTF_8 = "UTF-8";

    String CONFIG_PROPS = "smart.properties";
    String SQL_PROPS = "smart-sql.properties";

    String PLUGIN_PACKAGE = "org.smart4j.plugin";

    String JSP_PATH = ConfigHelper.getString("smart.framework.app.jsp_path", "/WEB-INF/jsp/");
    String WWW_PATH = ConfigHelper.getString("smart.framework.app.www_path", "/www/");
    String HOME_PAGE = ConfigHelper.getString("smart.framework.app.home_page", "/index.html");
    int UPLOAD_LIMIT = ConfigHelper.getInt("smart.framework.app.upload_limit", 10);

    String PK_NAME = "id";
}
