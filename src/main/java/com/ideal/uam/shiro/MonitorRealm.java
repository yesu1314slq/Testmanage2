package com.ideal.uam.shiro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideal.uam.util.CacheManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.entity.Tree;
import com.ideal.uam.service.login.LoginService;
import com.ideal.uam.service.tree.TreeService;
/**
 * 
 * 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MonitorRealm    
 * 类描述：自定义realm    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月13日 上午10:51:41    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月13日 上午10:51:41    
 * 修改备注：       
 * @version
 */
public class MonitorRealm extends AuthorizingRealm{
	@Autowired
	private LoginService loginService;
	@Autowired
	private TreeService treeService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取用的id
		int userId = ((Staff)principals.getPrimaryPrincipal()).getId();
		Map<String,List<String>> map = (HashMap)CacheManager.getInstance().getObj(String.valueOf(userId));
		if(null==map){
			//查询对应用户的角色集合
			List<Role> roleList=loginService.getRoleList(userId);
			List<String> roleAllList = new ArrayList<String>();
			for(Role role:roleList){
				roleAllList.add(role.getName());
			}
			List<String> resourceList = new ArrayList<String>();
			List<Tree> permissionList=loginService.findPermissions(userId);
			for (Tree menu : permissionList) {
				if (StringUtils.isNotBlank(menu.getPermission())) {
					resourceList.add(menu.getPermission());
				}
			}
			//赋角色
			info.addRoles(roleAllList);
			//赋权限
			info.addStringPermissions(resourceList);
			Map<String,List<String>> reouceMap=new HashMap<String,List<String>>();
			reouceMap.put("roleAllList",roleAllList);
			reouceMap.put("resourceList",resourceList);
			CacheManager.getInstance().putObj(String.valueOf(userId),reouceMap);
		}else{
			//赋角色
			info.addRoles(map.get("roleAllList"));
			//赋权限
			info.addStringPermissions(map.get("resourceList"));
		}

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName= (String)token.getPrincipal();
		Staff user=loginService.getUserByUserName(userName);
		if(user==null){
			 throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPwd(),getName());
		return info;
	}

}
