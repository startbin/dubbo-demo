package com.dongao.data.demo.web.realm;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dongao.data.demo.bean.vo.UserVO;

/**
 * PassportCasRealm 通过CAS服务器端返回的用户身份信息<br>
 * 支持 cas-client-core:3.2.3-SNAPSHOT
 */
public class PassportCasRealm extends CasRealm {
	private static Logger log = LoggerFactory.getLogger(PassportCasRealm.class);
	/** TODO 用户服务 ，后期使用DUBBO 服务完成*/
//	@Autowired
//	private DomeUserService userService;
//	@Autowired
//	private com.dongao.framework.auc.client.AucClient aucClient;

	/**
	 * 获取用户授权认可信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Session session = SecurityUtils.getSubject().getSession(false);
		authorizationInfo.setRoles((Set<String>) session.getAttribute("roles"));
		authorizationInfo.setStringPermissions((Set<String>) session.getAttribute("permissions"));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (token == null) {
			return null;
		}
		String ticket = (String) casToken.getCredentials();
		if (!StringUtils.hasText(ticket)) {
			return null;
		}

		TicketValidator ticketValidator = ensureTicketValidator();

		try {
			String portalid = null;
			// contact CAS server to validate service ticket
			Assertion casAssertion = ticketValidator.validate(ticket, getCasService(), portalid);// 支持 cas-client-core:3.2.3-SNAPSHOT
			// get principal, user id and attributes
			AttributePrincipal casPrincipal = casAssertion.getPrincipal();
			String username = casPrincipal.getName();
			log.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}", new Object[] { ticket, getCasServerUrlPrefix(), username });

			Map<String, Object> attributes = casPrincipal.getAttributes();
			// refresh authentication token (user id + remember me)
			casToken.setUserId(username);
			String rememberMeAttributeName = getRememberMeAttributeName();
			String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
			boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
			if (isRemembered) {
				casToken.setRememberMe(true);
			}
			// create simple authentication info
			List<Object> principals = CollectionUtils.asList(username, attributes);
//			User user = userService.findByUsername(username);// 获取当前用户信息
			UserVO user = new UserVO();
			user.setId(Long.valueOf(attributes.get("user_id").toString()));
			user.setUsername(username);
			Session session = SecurityUtils.getSubject().getSession(false);
			session.setAttribute(username, user);// 将当前用户信息缓存到session ，key为用户名
//			// 通过接口 获取站点
//			List<Map<String, Object>> sites = aucClient.findSites(username);
//			session.setAttribute("sites", sites);// 将sites数据缓存到session
//			// 通过接口 获取站点角色
//			Set<String> roles = aucClient.findRoles(username);
//			session.setAttribute("roles", roles);// 将roles数据缓存到session
//			// 通过接口 获取站点菜单
//			if (sites!=null && sites.size()!=0 && sites.get(0).get("id") != null) {
//				String siteId = sites.get(0).get("id").toString();
//				List<Map<String, Object>> menus = aucClient.findMenus(username,siteId);
//				session.setAttribute("menus", menus);// 将menus数据缓存到session
//			}
//			// 通过接口 获取站点权限
//			Set<String> permissions = aucClient.findPermissions(username);
//			session.setAttribute("permissions", permissions);// 将permissions数据缓存到session

			PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());
			return new SimpleAuthenticationInfo(principalCollection, ticket);
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
		}
	}

}
