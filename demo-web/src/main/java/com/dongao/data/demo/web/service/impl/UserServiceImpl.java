//package com.dongao.data.demo.web.service.impl;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dongao.data.demo.bean.dto.SysUserDto;
//import com.dongao.data.demo.bean.vo.UserVO;
//import com.dongao.data.demo.provider.interfaces.UserRemoteService;
//
///**
// * @Description
// *              <ul>
// *              <li>提供给该工程的 controller 调用的 service服务</li>
// *              <li>该service 通过调用dubbo 接口，获取数据，并转换参数与返回值 提供给controller 需要的数据</li>
// *              <li>该接口注入的RemoteUserServcie需要通过/src/main/resources/META-INF/spring/dubbo.xml配置添加dubbo:reference标签</li>
// *              <li>该接口需要注入 RemoteUserServcie 在dubbo的概念中为 服务消费方</li>
// *              </ul>
// * @author Sunqinbo
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRemoteService userRemoteService;
//
//	public SysUser getUserByUserName(String userName) {
//		try {
//			SysUser userVO = userRemoteService.getUserByUserName(userName);
////			UserVO userVO = new UserVO();
////			BeanUtils.copyProperties(userVO, sysUserDto);// 将dubbo 接口返回值转换成 vo
//			return userVO;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}
//
//}
