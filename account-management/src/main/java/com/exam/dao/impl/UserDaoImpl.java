package com.exam.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.base.BaseDao;
import com.exam.base.Pagination;
import com.exam.dao.IUserDao;
import com.exam.model.QueryParam;
import com.exam.model.User;

@Repository()
public class UserDaoImpl implements IUserDao{

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Pagination<User> query(String tableName, QueryParam queryParam, int begin, int size) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM " + tableName + " WHERE 1=1 ");
		
		List<Object> param = new ArrayList<Object>();
		if(queryParam!=null){
			if(queryParam.getUserCode()!=null){
				sql.append("AND user_code LIKE ? ");
				param.add("%"+queryParam.getUserCode()+"%");
			}
			if(queryParam.getUserName()!=null){
				sql.append("AND user_name LIKE ? ");
				param.add("%"+queryParam.getUserName()+"%");
			}
			if(queryParam.getUserType()!=null){
				sql.append("AND user_type = ? ");
				param.add(queryParam.getUserType());
			}
			if(queryParam.getCreateBeginAt()!=null){
				sql.append("AND create_at >= ? ");
				param.add(queryParam.getCreateBeginAt());
			}
			if(queryParam.getCreateEndAt()!=null){
				sql.append("AND create_at <= ? ");
				param.add(queryParam.getCreateEndAt());
			}
			sql.append(" ORDER BY user_id DESC ");
		}
		Pagination<User> pageUsers = baseDao.queryPagination(sql.toString(), param.toArray(), begin, size, User.class);
		return pageUsers;
	}

	@Override
	public List<User> queryUserNoVersion(User user,String tableName) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		sql.append("SELECT * FROM ").append(tableName).append(" WHERE user_code=? ");
		param.add(user.getUserCode());
		
		return baseDao.find(sql.toString(), param.toArray(), User.class);
	}

	@Override
	public void saveUser(User user,String tableName) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append("INSERT INTO ")
			.append(tableName)
			.append("(user_code,user_name,password,remark,state,create_at,last_login_at,user_type,version) ")
			.append(" VALUES(?,?,?,?,?,?,?,?,?)");
		param.add(user.getUserCode());
		param.add(user.getUserName());
		param.add(user.getPassword());
		param.add(user.getRemark());
		param.add(user.getState());
		param.add(user.getCreateAt());
		param.add(user.getLastLoginAt());
		param.add(user.getUserType());
		param.add(user.getVersion());
		baseDao.addOrUpdateOrDelete(sql.toString(), param.toArray(), User.class);
	}

	@Override
	public List<User> queryUserWithVersion(User user,String tableName) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		sql.append("SELECT * FROM ").append(tableName).append(" WHERE user_id=? AND version=?");
		param.add(user.getUserId());
		param.add(user.getVersion());
		return baseDao.find(sql.toString(), param.toArray(), User.class);
	}

	@Override
	public int deleteUser(User user,String tableName) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		sql.append("DELETE FROM ").append(tableName).append(" WHERE user_id=? AND version=?");
		param.add(user.getUserId());
		param.add(user.getVersion());
		return baseDao.addOrUpdateOrDelete(sql.toString(), param.toArray(), User.class);
	}

	@Override
	public List<User> queryUserByIdWithVersion(User user, String tableName) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		sql.append("SELECT * FROM ").append(tableName).append(" WHERE user_id=? AND version=?");
		param.add(user.getUserId());
		param.add(user.getVersion());
		return baseDao.find(sql.toString(), param.toArray(), User.class);
	}

	@Override
	public List<User> validUserRepeat(User user, String tableName) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		sql.append("SELECT * FROM ").append(tableName).append(" WHERE user_code=? AND user_id<>?");
		param.add(user.getUserCode());
		param.add(user.getUserId());
		return baseDao.find(sql.toString(), param.toArray(), User.class);
	}

	@Override
	public int updateUser(User user, String tableName) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append("UPDATE ")
			.append(tableName)
			.append(" SET user_code=?,user_name=?,password=?,remark=?,state=?,user_type=?,version=? ")
			.append(" WHERE user_id=?");
		param.add(user.getUserCode());
		param.add(user.getUserName());
		param.add(user.getPassword());
		param.add(user.getRemark());
		param.add(user.getState());
		param.add(user.getUserType());
		param.add(user.getVersion()+1);
		param.add(user.getUserId());
		
		return baseDao.addOrUpdateOrDelete(sql.toString(), param.toArray(), User.class);
	}
	
}
