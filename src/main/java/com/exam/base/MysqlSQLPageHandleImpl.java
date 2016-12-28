package com.exam.base;

import org.apache.log4j.Logger;

public class MysqlSQLPageHandleImpl implements SQLPageHandle {

	private Logger logger=Logger.getLogger(MysqlSQLPageHandleImpl.class);
	
	@Override
	public String handlerPagingSQL(String oldSql, int begin, int pageSize) {
		StringBuffer sql = new StringBuffer(oldSql);
		if (pageSize > 0) {
			int firstResult = begin;
			if (firstResult <= 0) {
				sql.append(" limit ").append(pageSize);
			} else {
				sql.append(" limit ").append(firstResult).append(",").append(pageSize);
			}
		}
		return sql.toString();
	}

}
