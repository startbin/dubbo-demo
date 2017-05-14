package com.dongao.data.demo.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dongao.data.demo.bean.po.SysUser;
import com.dongao.data.demo.provider.interfaces.UserRemoteService;

@Controller
public class UserController extends BaseController {

	// @Autowired
	// private UserService userService;
	@Autowired
	private UserRemoteService userRemoteService;

	@RequestMapping(value = "/get", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject getUser(String username) {

		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(username)) {
			SysUser userVO = userRemoteService.getUserByUserName(username);
			json.put("data", userVO);
			json.put("status", true);
		} else {
			json.put("msg", "userName param is null ");
			json.put("status", false);
		}
		return json;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public JSONObject getUserList(SysUser sysUser, Integer pageNum, Integer pageSize) {

		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(sysUser.getUsername())) {

			List<SysUser> pagelist = userRemoteService.getPagelist(sysUser, pageNum, pageSize);
			json.put("data", pagelist);
			json.put("status", true);
		} else {
			json.put("msg", "userName param is null ");
			json.put("status", false);
		}
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject save(String username, int size) {

		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(username)) {
			for (int i = 0; i < size; i++) {
				SysUser sysUser = new SysUser();
				sysUser.setUsername(username + "_" + size + "_" + i);
				sysUser.setLocked(false);
				sysUser.setSalt(System.currentTimeMillis() + "");
				sysUser.setPassword(Thread.currentThread().getName());
				sysUser = userRemoteService.save(sysUser);
				// list.add(sysUser);

			}
			// new Thread("dd").run();
			json.put("data", size);
			json.put("status", true);
		} else {
			json.put("msg", "userName param is null ");
			json.put("status", false);
		}
		return json;
	}

}
