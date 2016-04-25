package org.smart4j.framework.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.dao.DataAccessor;
import org.smart4j.framework.dao.DatabaseHelper;
import org.smart4j.framework.orm.EntityHelper;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.MapUtil;


/**
 * 默认数据访问器
 * <br/>
 * 基于 Apache Commons DbUtils 实现
 *
 * @author huangyong
 * @since 2.3
 */
public class DefaultDataAccessor implements DataAccessor {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDataAccessor.class);

    private final QueryRunner queryRunner;

    public DefaultDataAccessor() {
        DataSource dataSource = DatabaseHelper.getDataSource();
        queryRunner = new QueryRunner(dataSource);
    }

    @Override
    public <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T result;
        try {
            Map<String, String> columnMap = EntityHelper.getColumnMap(entityClass);
            if (MapUtil.isNotEmpty(columnMap)) {
                result = queryRunner.query(sql, new BeanHandler<T>(entityClass, new BasicRowProcessor(new BeanProcessor(columnMap))), params);
            } else {
                result = queryRunner.query(sql, new BeanHandler<T>(entityClass), params);
            }
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        //String log = LogHelper.generateSelectSQL(entityClass, "id = ?", "", params);
        printSQL(sql,params);
        return result;
    }

    @Override
    public <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> result;
        try {
            Map<String, String> columnMap = EntityHelper.getColumnMap(entityClass);
            if (MapUtil.isNotEmpty(columnMap)) {
                result = queryRunner.query(sql, new BeanListHandler<T>(entityClass, new BasicRowProcessor(new BeanProcessor(columnMap))), params);
            } else {
                result = queryRunner.query(sql, new BeanListHandler<T>(entityClass), params);
            }
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return result;
    }

    @Override
    public <K, V> Map<K, V> queryEntityMap(Class<V> entityClass, String sql, Object... params) {
        Map<K, V> entityMap;
        try {
            entityMap = queryRunner.query(sql, new BeanMapHandler<K, V>(entityClass), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return entityMap;
    }

    @Override
    public Object[] queryArray(String sql, Object... params) {
        Object[] array;
        try {
            array = queryRunner.query(sql, new ArrayHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return array;
    }

    @Override
    public List<Object[]> queryArrayList(String sql, Object... params) {
        List<Object[]> arrayList;
        try {
            arrayList = queryRunner.query(sql, new ArrayListHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return arrayList;
    }

    @Override
    public Map<String, Object> queryMap(String sql, Object... params) {
        Map<String, Object> map;
        try {
            map = queryRunner.query(sql, new MapHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return map;
    }

    @Override
    public List<Map<String, Object>> queryMapList(String sql, Object... params) {
        List<Map<String, Object>> fieldMapList;
        try {
            fieldMapList = queryRunner.query(sql, new MapListHandler(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return fieldMapList;
    }

    @Override
    public <T> T queryColumn(String sql, Object... params) {
        T obj;
        try {
            obj = queryRunner.query(sql, new ScalarHandler<T>(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return obj;
    }

    @Override
    public <T> List<T> queryColumnList(String sql, Object... params) {
        List<T> list;
        try {
            list = queryRunner.query(sql, new ColumnListHandler<T>(), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return list;
    }

    @Override
    public <T> Map<T, Map<String, Object>> queryColumnMap(String column, String sql, Object... params) {
        Map<T, Map<String, Object>> map;
        try {
            map = queryRunner.query(sql, new KeyedHandler<T>(column), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return map;
    }

    @Override
    public long queryCount(String sql, Object... params) {
        long result;
        try {
            result = queryRunner.query(sql, new ScalarHandler<Long>("count(*)"), params);
        } catch (SQLException e) {
            logger.error("查询出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return result;
    }

    @Override
    public int update(String sql, Object... params) {
        int result;
        try {
            Connection conn = DatabaseHelper.getConnection();
            result = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            logger.error("更新出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return result;
    }

    @Override
    public Serializable insertReturnPK(String sql, Object... params) {
        Serializable key = null;
        try {
            Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if (ArrayUtil.isNotEmpty(params)) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            int rows = pstmt.executeUpdate();
            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    key = (Serializable) rs.getObject(1);
                }
            }
        } catch (SQLException e) {
            logger.error("插入出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql,params);
        return key;
    }

/*    private static void printSQL(String sql) {
        logger.info("[Smart] SQL - {}", sql);
    }*/
    
    private static void printSQL(String sql,Object[] params) {
    	String result = getPreparedSQL(sql,params);
    	insertLog(result);
        logger.info("[Smart] SQL - {}", result);
    }
    
	/**
	 * 获得PreparedStatement向数据库提交的SQL语句
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	private static String getPreparedSQL(String sql, Object[] params) {
		// 1 如果没有参数，说明是不是动态SQL语句
		int paramNum = 0;
		if (null != params){
			paramNum = params.length;
		}
		if (1 > paramNum)
			return sql;
		// 2 如果有参数，则是动态SQL语句
		StringBuffer returnSQL = new StringBuffer();
		String[] subSQL = sql.split("\\?");
		for (int i = 0; i < paramNum; i++) {
			returnSQL.append(subSQL[i]).append(" '").append(params[i]).append("' ");
/*			if (params[i] instanceof Date) {
				returnSQL.append(subSQL[i]).append(" '").append(MyDateUtil.dateUtil2SQL((java.util.Date) params[i])).append("' ");
			} else {
				returnSQL.append(subSQL[i]).append(" '").append(params[i]).append("' ");
			}*/
		}

		if (subSQL.length > params.length) {
			returnSQL.append(subSQL[subSQL.length - 1]);
		}
		return returnSQL.toString();
	}

    public static void insertLog(String sql) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String logql = "insert into log (statement,operatetime,type,userid) value(?,?,?,?)";
            List<Object> list = new ArrayList<Object>();
    		list.add(sql);
    		list.add((new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss")).format(new Date()));
    		list.add(1);
    		//从Session中获取当前用户ID
    		String operatorId = "me";
    		list.add(operatorId);
            PreparedStatement pstmt = conn.prepareStatement(logql, PreparedStatement.SUCCESS_NO_INFO);
            for(int i=0;i<list.size();i++){
                pstmt.setObject(i+1,list.get(i));
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("插入日志出错！", e);
            throw new RuntimeException(e);
        }
    }
}
