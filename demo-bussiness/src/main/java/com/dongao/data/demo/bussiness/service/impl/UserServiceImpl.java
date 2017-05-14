//package com.dongao.data.demo.bussiness.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dongao.data.demo.bean.po.SysUser;
//import com.dongao.data.demo.bussiness.mapper.SysUserMapper;
//import com.dongao.data.demo.bussiness.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private SysUserMapper sysUserMapper;
//
//	/**
//	 * 通过用户获取用户信息
//	 * @param userName 用户名
//	 * @return SysUser类型
//	 * @createTime 2016-3-8
//	 * @author Sunqinbo
//	 */
//	public SysUser getUserByUserName(String userName) {
//		SysUser record = new SysUser();
//		record.setUsername(userName);
//		SysUser sysUser = sysUserMapper.selectOne(record);
//		return sysUser;
//	}
//
//	/**
//	 * 获取分页数据
//	 * @param params 参数集合
//	 *            <b>
//	 *            params 说明
//	 *            </b>
//	 *            <ul>
//	 *            <li></li>
//	 *            </ul>
//	 * @return List<SysUser>类型
//	 * @createTime 2016-3-8
//	 * @author Sunqinbo
//	 */
//	public List<SysUser> getPagelist(Map<String, Object> params) {
//		return null;
//	}
//
//	@Override
//	public SysUser saveUser(SysUser sysUser) {
//		int i = sysUserMapper.insert(sysUser);
//		System.out.println("插入行数:" + i);
//		return sysUser;
//	}
//}
