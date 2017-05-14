package com.dongao.data.demo.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.dongao.data.demo.bean.vo.UserVO;

public class BaseController {

	/**
	 * 获取当前用户
	 */
	protected UserVO getCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Session session = subject.getSession(false);
		Object user = session.getAttribute(username);
		return (UserVO) user;
	}

	/**
	 * 获取当前用户菜单
	 * @return List<Resource>类型
	 * @createTime 2016-1-29
	 * @author Sunqinbo
	 */
	protected List<Map<String, Object>> getCurrentUserMenus() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) session.getAttribute("menus");
		return list;
	}

	/**
	 * 获取当前用户 permissions
	 * @return Set<String>类型
	 * @createTime 2016-1-29
	 * @author Sunqinbo
	 */
	protected Set<String> getCurrentUserPermissions() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		@SuppressWarnings("unchecked")
		Set<String> list = (Set<String>) session.getAttribute("permissions");
		return list;
	}

	/**
	 * 获取当前用户 roles
	 * @return Set<Resource>类型
	 * @createTime 2016-1-29
	 * @author Sunqinbo
	 */
	protected Set<String> getCurrentUserRoles() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		@SuppressWarnings("unchecked")
		Set<String> list = (Set<String>) session.getAttribute("roles");
		return list;
	}

	/**
	 * 获取当前用户站点
	 * @return List<Map<String, String>>类型
	 * @createTime 2016-1-29
	 * @author Sunqinbo
	 */
	protected List<Map<String, Object>> getCurrentUserSties() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) session.getAttribute("sites");
		return list;
	}
}