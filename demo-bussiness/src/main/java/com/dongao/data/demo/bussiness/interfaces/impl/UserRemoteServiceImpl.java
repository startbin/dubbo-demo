package com.dongao.data.demo.bussiness.interfaces.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.dongao.data.demo.bean.po.SysUser;
import com.dongao.data.demo.bussiness.mapper.SysUserMapper;
import com.dongao.data.demo.provider.interfaces.UserRemoteService;
import com.github.pagehelper.PageHelper;

@Service
public class UserRemoteServiceImpl implements UserRemoteService {
	Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	@Autowired
	SysUserMapper sysUserMapper;

	@Override
	public SysUser getUserByUserName(String userName) {
		SysUser record = new SysUser();
		record.setUsername(userName);
		SysUser sysUser = null;
		try {
			sysUser = sysUserMapper.selectOne(record);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("e : {}", e.getMessage());
			throw e;
		}
		return sysUser;
	}

	@Override
	public List<SysUser> getPagelist(SysUser user, Integer pageNum, Integer pageSize) {
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		criteria.andCondition("username LIKE", user.getUsername() + "%");
		// criteria.andLike("username", user.getUsername());

		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> list = null;
		try {
			list = sysUserMapper.selectByExample(example);
			System.out.println(user.getUsername() + " list : " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("e : {}", e.getMessage());
			throw e;
		}
		return list;
	}

	@Override
	public SysUser save(SysUser sysUser) {
		try {
			int i = sysUserMapper.insert(sysUser);
			System.out.println("插入行数:" + i);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("e : {}", e.getMessage());
			throw e;
		}
		return sysUser;
	}

	// @Autowired
	// private UserService userService;
	//
	// @Override
	// public SysUser getUserByUserName(String userName) {
	// // try {
	// SysUser resutl = userService.getUserByUserName(userName);
	// return resutl;
	// // SysUserDto dto = new SysUserDto();
	// // if (resutl != null) {
	// // BeanUtils.copyProperties(dto, resutl);
	// // }
	// // return dto;
	// // } catch (IllegalAccessException e) {
	// // e.printStackTrace();
	// // } catch (InvocationTargetException e) {
	// // e.printStackTrace();
	// // }
	// // return null;
	// }
	//
	// @Override
	// public List<SysUser> getPagelist(Map<String, Object> params) {
	// // Page page = PageHelper.startPage(0, 0);
	// // com.dongao.framework.core.page.Page<SysUserDto> page2 = new com.dongao.framework.core.page.Page<SysUserDto>();
	// // page2.setPageNum(page.getPageNum());
	// return null;
	// }
	//
	// @Override
	// public SysUser save(SysUser save) {
	// SysUser saveUser = userService.saveUser(save);
	// return saveUser;
	//
	// }

}