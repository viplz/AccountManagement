package com.exam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.base.Pagination;
import com.exam.dao.IUserDao;
import com.exam.model.QueryParam;
import com.exam.model.ResponseMessage;
import com.exam.model.User;
import com.exam.service.impl.IUserService;
import com.exam.util.DateUtil;

import net.sf.json.JSONObject;
	
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	public IUserDao userDao;
	
	@Override
	public String queryAll(QueryParam queryParam, Pagination<User> page) {
		
		Pagination<User> pageUsers = query(queryParam,page);
		return JSONObject.fromObject(pageUsers).toString();
	}

	private Pagination<User> query(QueryParam queryParam, Pagination<User> page) {
		if(queryParam!=null){
			if ("".equals(queryParam.getUserCode())) {
				queryParam.setUserCode(null);
			}
			if ("".equals(queryParam.getUserName())) {
				queryParam.setUserName(null);
			}
			if ("".equals(queryParam.getCreateAt())) {
				queryParam.setCreateBeginAt(null);
			}else{
				queryParam.setCreateBeginAt(queryParam.getCreateAt().substring(0, 19));
				queryParam.setCreateEndAt(queryParam.getCreateAt().substring(22, 41));
			}
			if ("".equals(queryParam.getUserType())) {
				queryParam.setUserType(null);
			}
		}
		// 封装分页
		Pagination<User> pageUsers = userDao.query("tb_user", queryParam, page.getStart(),page.getPageSize());
		return pageUsers;
	}

	private boolean valid(User user) {
		
		List<User> uList = queryForValid(user);//验证账户编码
		if(uList.size()>0){
			return false;
		}
		return true;
	}

	private List<User> queryForValid(User user) {
		
		return userDao.queryUserNoVersion(user,"tb_user");
	}

	@Override
	public ResponseMessage saveForAdd(User user) {
		//验证账户是否存在
		boolean isValid = valid(user);
		if(isValid){
			saveUser(user);
			return ResponseMessage.returnHtmlMessage(200, null, "注册成功");
		}else{
			return ResponseMessage.returnHtmlMessage(200, null, "当前编码内容已被使用，请重新输入");
		}
	}

	private void saveUser(User user) {
		user.setCreateAt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		user.setLastLoginAt(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		user.setVersion(0l);
		userDao.saveUser(user,"tb_user");
	}

	@Override
	public ResponseMessage deleteUser(User user) {
		boolean canDelete = validDel(user);
		if(canDelete){
			int rows = userDao.deleteUser(user,"tb_user");
			if(rows > 0){
				return ResponseMessage.returnHtmlMessage(200, null, "成功删除"+rows+"行记录");
			}else{
				return ResponseMessage.returnHtmlMessage(500, null, "删除失败");
			}
		}else{
			return ResponseMessage.returnHtmlMessage(500, null, "当前记录已失效，删除失败，请刷新后重试");
		}
	}

	private boolean validDel(User user) {
		List<User> uList = userDao.queryUserWithVersion(user,"tb_user");
		if(uList.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public User queryForUser(User user) {
		
		List<User> userList = userDao.queryUserWithVersion(user,"tb_user");
		
		if(userList.size()==1){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public ResponseMessage saveForUpdate(User user) {
		
		boolean isValid = false;
		List<User> uList = userDao.queryUserByIdWithVersion(user,"tb_user");//查询是否当前账号信息已被修改，即版本信息是否同步
		if(uList.size()==1){
			if(user.getUserCode().equals(uList.get(0).getUserCode())){//未修改编码
				isValid = true;
			}else{//编码被编辑后，校验编码是否已被他人使用
				List<User> validUserList = userDao.validUserRepeat(user,"tb_user");
				if(validUserList.size()==0){
					isValid = true;
				}
			}
		}else{//版本不同步
			return ResponseMessage.returnHtmlMessage(500, null, "当前更改的账号信息已失效，请刷新后重试");
		}
		if(isValid){
			int row = userDao.updateUser(user, "tb_user");
			if(row==0){
				return ResponseMessage.returnHtmlMessage(500, null, "服务器错误，账号信息更改失败");
			}
			return ResponseMessage.returnHtmlMessage(200, null, "账号信息更改成功");
		}else{
			return ResponseMessage.returnHtmlMessage(500, null, "账号信息更改失败，编码已被使用，请重新输入");
		}
	}

	@Override
	public ResponseMessage updateState(User user) {
		List<User> uList = userDao.queryUserByIdWithVersion(user,"tb_user");//查询是否当前账号信息已被修改，即版本信息是否同步
		String stateMsg = "";
		if(uList.size()==1){
			if(user.getState()==1){
				user.setState(0);
				stateMsg="封存";
			}else{
				user.setState(1);
				stateMsg="启封";
			}
			int rows = userDao.updateUser(user, "tb_user");
			if(rows==0){
				return ResponseMessage.returnHtmlMessage(500, null, "服务器错误");
			}
			return ResponseMessage.returnHtmlMessage(200, null, "账号"+stateMsg+"成功");
		}else{
			if(user.getState()==1){
				stateMsg="封存";
			}else{
				stateMsg="启封";
			}
			return ResponseMessage.returnHtmlMessage(500, null, "当前记录已失效，账号"+stateMsg+"失败，请刷新后重试");
		}
	}

}
