package com.exam.dao;

import java.util.List;

import com.exam.base.Pagination;
import com.exam.model.QueryParam;
import com.exam.model.User;

public interface IUserDao {

	Pagination<User> query(String tableName, QueryParam queryParam, int begin, int size);

	List<User> queryUserNoVersion(User user, String tableName);

	List<User> queryUserWithVersion(User user,String tableName);
	
	void saveUser(User user,String tableName);

	int deleteUser(User user,String tableName);

	List<User> queryUserByIdWithVersion(User user, String tableName);

	List<User> validUserRepeat(User user, String string);

	int updateUser(User user, String string);

}
