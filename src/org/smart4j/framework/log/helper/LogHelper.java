package org.smart4j.framework.log.helper;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.smart4j.framework.orm.annotation.Table;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.MapUtil;
import org.smart4j.framework.util.StringUtil;

/**
 * @ClassName: LogHelper
 * @Description: 数据库操作日志助手
 * @author BEE
 * @date 2016-4-18 下午5:09:31
 */
public class LogHelper {
	public static String generateSelectSQL(Class<?> cls, String condition,
			String sort, Object[] params) {
		StringBuilder sql = new StringBuilder("select * from ")
				.append(getTable(cls));
		sql.append(generateWhere(condition, params));
		sql.append(generateOrder(sort));
		return sql.toString();
	}

	public static String generateInsertSQL(Class<?> cls,
			Map<String, Object> fieldMap) {
		StringBuilder sql = new StringBuilder("insert into ")
				.append(getTable(cls));
		if (MapUtil.isNotEmpty(fieldMap)) {
			int i = 0;
			StringBuilder columns = new StringBuilder(" ");
			StringBuilder values = new StringBuilder(" values ");
			for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
				String columnName = StringUtil
						.camelhumpToUnderline((String) fieldEntry.getKey());
				Object columnValue = fieldEntry.getValue();
				if (i == 0) {
					columns.append("(").append(columnName);
					values.append("('").append(columnValue).append("'");
				} else {
					columns.append(", ").append(columnName);
					values.append(", '").append(columnValue).append("'");
				}
				if (i == fieldMap.size() - 1) {
					columns.append(")");
					values.append(")");
				}
				i++;
			}
			sql.append(columns).append(values);
		}
		return sql.toString();
	}

	public static String generateDeleteSQL(Class<?> cls, String condition,
			Object[] params) {
		StringBuilder sql = new StringBuilder("delete from ")
				.append(getTable(cls));
		sql.append(generateWhere(condition, params));
		return sql.toString();
	}

	public static String generateUpdateSQL(Class<?> cls,
			Map<String, Object> fieldMap, String condition, Object[] params) {
		StringBuilder sql = new StringBuilder("update ").append(getTable(cls));
		if (MapUtil.isNotEmpty(fieldMap)) {
			sql.append(" set ");
			int i = 0;
			for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
				String columnName = StringUtil
						.camelhumpToUnderline((String) fieldEntry.getKey());
				Object columnValue = fieldEntry.getValue();
				if (i == 0)
					sql.append(columnName).append(" = '").append(columnValue)
							.append("'");
				else {
					sql.append(", ").append(columnName).append(" = '")
							.append(columnValue).append("'");
				}
				i++;
			}
		}
		sql.append(generateWhere(condition, params));
		return sql.toString();
	}

	private static String generateWhere(String condition, Object[] params) {
		StringBuilder builder = new StringBuilder();
		if (StringUtil.isNotEmpty(condition)) {
			StringBuffer buffer = new StringBuffer();
			if (ArrayUtil.isNotEmpty(params)) {
				Matcher matcher = Pattern.compile("\\?").matcher(condition);
				for (int i = 0; matcher.find(); i++) {
					String param = params[i].toString();
					if (StringUtil.isNumber(param))
						matcher.appendReplacement(buffer, param);
					else {
						matcher.appendReplacement(buffer, "'" + param + "'");
					}
				}
				matcher.appendTail(buffer);
				builder.append(" where ").append(buffer);
			} else {
				builder.append(" where ").append(condition);
			}
		}
		return builder.toString();
	}

	private static String getTable(Class<?> cls) {
		String tableName;
		if (cls.isAnnotationPresent(Table.class))
			tableName = ((Table) cls.getAnnotation(Table.class)).value();
		else {
			tableName = StringUtil.camelhumpToUnderline(cls.getSimpleName());
		}
		return tableName;
	}

	private static String generateOrder(String sort) {
		StringBuilder builder = new StringBuilder();
		if (StringUtil.isNotEmpty(sort)) {
			builder.append(" order by ").append(sort);
		}
		return builder.toString();
	}

	public static String generateSql(String sql , Object...objects){
		String result = sql;
		
		return result;
	}
}
