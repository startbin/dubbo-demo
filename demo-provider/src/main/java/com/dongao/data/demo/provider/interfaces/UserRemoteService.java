package com.dongao.data.demo.provider.interfaces;

import java.util.List;
import java.util.Map;

import com.dongao.data.demo.bean.po.SysUser;

/**
 * @Description
 *              <ul>
 *              <li>该工程interfaces包用于定义dubbo 接口</li>
 *              <li>该工程interfaces包定义dubbo 接口 前缀 为： Remote,例如：RemoteUserServcie</li>
 *              </ul>
 * @author Sunqinbo
 */
public interface UserRemoteService {

	/**
	 * 通过用户获取用户信息
	 * @param userName 用户名
	 */
	public SysUser getUserByUserName(String userName);

	/**
	 * 获取分页数据
	 * @param params 参数集合
	 */
	public List<SysUser> getPagelist(SysUser sysUser, Integer pageNum, Integer pageSize);

	public SysUser save(SysUser sysUser);
}
