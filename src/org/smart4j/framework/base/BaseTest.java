package org.smart4j.framework.base;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
//@RunWith(OrderedRunner.class)
public abstract class BaseTest
{
/* private static final Logger logger = Logger.getLogger(BaseTest.class);

  static {
    Smart.init();
  }

  protected static void initSQL(String sqlPath) {
    try {
      File sqlFile = new File(ClassUtil.getClassPath() + sqlPath);
      List sqlList = FileUtils.readLines(sqlFile);
      for (String sql : sqlList)
        DBHelper.update(sql, new Object[0]);
    }
    catch (Exception e) {
      logger.error("执行数据初始化脚本出错！", e);
      throw new RuntimeException(e);
    }
  }*/
}