package com.exam.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.base.Pagination;
import com.exam.model.QueryParam;
import com.exam.model.ResponseMessage;
import com.exam.model.User;
import com.exam.service.impl.IUserService;

@Controller
public class AccountManageController {
	
	private static Logger log = Logger.getLogger(AccountManageController.class);
	
	@Autowired
	private IUserService userService;
	
	
	/**跳转列表页面
	 * @return
	 */
	@RequestMapping(value = "/home",method=RequestMethod.GET)  
    public ModelAndView home() {  
        return new ModelAndView("home");
        //ModelAndView mav = new ModelAndView("redirect:/index.do");index.do里面再返回视图可以重定向解决表单重复提交  
    } 
	
	/**列表页面
	 * @param queryParam
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryList",method=RequestMethod.POST)  
	@ResponseBody
    public String queryList(QueryParam queryParam,Pagination<User> page) {  
        //UserList userList = userService.queryAll(queryParam,page);
		String data = userService.queryAll(queryParam,page);
        
        return data;
    }
	
	/**跳转新增页面
	 * @return
	 */
	@RequestMapping(value = "/add",method=RequestMethod.GET)  
    public ModelAndView add() {
        return new ModelAndView("add");
    }
	
	/**新增
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/saveForAdd",method=RequestMethod.POST)  
	@ResponseBody
    public ResponseMessage saveForAdd(User user) {
		try {
			return userService.saveForAdd(user);
		} catch (Exception e) {
			log.info(e.getMessage());
			return ResponseMessage.returnHtmlMessage(500, null, "验证失败");
		}
    }
	
	/**删除
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/deleteUser",method=RequestMethod.POST)  
	@ResponseBody
    public ResponseMessage deleteUser(User user) {
		try {
			return userService.deleteUser(user);
		} catch (Exception e) {
			log.info(e.getMessage());
			return ResponseMessage.returnHtmlMessage(500, null, "删除失败");
		}
    }
	
	/**跳转编辑页面
	 * @return
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.GET)
	@ResponseBody
    public ModelAndView edit(User user) {
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("user", userService.queryForUser(user));
        return mv;
    }
	
	/**更新
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/saveForUpdate",method=RequestMethod.POST)  
	@ResponseBody
    public ResponseMessage saveForUpdate(User user) {
		try {
			return userService.saveForUpdate(user);
		} catch (Exception e) {
			log.info(e.getMessage());
			return ResponseMessage.returnHtmlMessage(500, null, "操作失败");
		}
    }
	
	/**更新
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateState",method=RequestMethod.POST)  
	@ResponseBody
    public ResponseMessage updateState(User user) {
		try {
			return userService.updateState(user);
		} catch (Exception e) {
			log.info(e.getMessage());
			return ResponseMessage.returnHtmlMessage(500, null, "操作失败");
		}
    }
}
