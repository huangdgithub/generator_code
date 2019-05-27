package com.mf.glory.entity;

import java.util.List;

/**
 * @Author: Ethan huang
 * @CreateDate: 2019/3/29 11:18
 *
 *  information_schema.tables存储了数据表的元数据信息
 * 详细简介：https://www.cnblogs.com/ssslinppp/p/6178636.html
 */
public class TableEntity {
	/**
	 * 表的名称
	 */
	private String tableName;
	/**
	 * 表的备注
	 */
	private String comments;
	/**
	 * 主键
	 */
	private ColumnEntity pk;
	/**
	 * 列名(不包含主键)
	 */
	private List<ColumnEntity> columns;
	/**
	 * 类名(第一个字母大写)，如：sys_user => SysUser
	 */
	private String className;
	/**
	 * 类名(第一个字母小写)，如：sys_user => sysUser
	 */
	private String classname;

	public String getInsertSQL() {
		StringBuilder sqlBuilder = new StringBuilder("insert into ");
		sqlBuilder.append(tableName).append("(");

		StringBuilder builder = new StringBuilder();
		for (ColumnEntity field : columns) {
			builder.append(field.getColumnName().toLowerCase()).append(",");
		}
		String temp = builder.toString();
		temp = temp.substring(0, temp.length() - 1);

		sqlBuilder.append(temp).append(") values (");

		builder = new StringBuilder();
		for (ColumnEntity field : columns) {
			if(field.getDataType().equals("Date")){
				builder.append("now(),");
			}else{
				builder.append("#{").append(field.getAttrname()).append("},");
			}
		}
		temp = builder.substring(0, builder.length() - 1);
		sqlBuilder.append(temp).append(")");
		return sqlBuilder.toString();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ColumnEntity getPk() {
		return pk;
	}

	public void setPk(ColumnEntity pk) {
		this.pk = pk;
	}

	public List<ColumnEntity> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnEntity> columns) {
		this.columns = columns;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

}
