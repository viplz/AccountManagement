package com.exam.service.impl;

import com.exam.base.Pagination;
import com.exam.model.QueryParam;
import com.exam.model.ResponseMessage;
import com.exam.model.User;

public interface IUserService {

	String queryAll(QueryParam queryParam, Pagination<User> page);

	ResponseMessage saveForAdd(User user);

	ResponseMessage deleteUser(User user);

	ResponseMessage saveForUpdate(User user);
	
	User queryForUser(User user);

	ResponseMessage updateState(User user);

}
