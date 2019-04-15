package com.ideal.uam.web.controller.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.ideal.uam.entity.Tree;
import com.ideal.uam.service.tree.TreeService;
import com.ideal.uam.shiro.MonitorRealm;
import com.ideal.uam.util.CacheManager;
import com.ideal.uam.util.JsonUtil;
import com.ideal.uam.util.SeubjectUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.service.role.RoleService;
import com.ideal.uam.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：RoleController    
 * 类描述：角色管理    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:10:50    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:10:50    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private TreeService treeService;

	private Page page=new Page();
	/**
	 * getRolePage(获取角色管理页面)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月12日 上午9:12:48
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月12日 上午9:12:48
	 * 修改备注：
	 * @return
	 */
	@RequiresPermissions("role:find")
	@RequestMapping("getRolePage")
	public String getRolePage(){
		return "role/role_info_page";
	}
	/**
	 * toRoleEditPage(跳转编辑角色页面)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月21日 下午14:12:48
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月21日 下午14:12:48
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("toRoleEditPage")
	public String toRoleEditPage(HttpServletRequest request){
		String role_id = request.getParameter("role_id");
		Role role = roleService.getRoleById(role_id);
		request.setAttribute("role",role);
		return "role/edit_role_page";
	}
	/**
	 * getRoleList(获取角色列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月15日 上午9:51:21
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月15日 上午9:51:21
	 * 修改备注：
	 */
	@RequestMapping("getRoleListPage")
	@ResponseBody
	public void getRoleListPage(Role role,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(role);
		roleService.getRoleListPage(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		String formatMap=JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd");
		JsonUtil.outJson(formatMap,response);
	}
	/**
	 * toRoleEditPage(修改角色)
	 * 创建人：shililing 15727396454@163.com
	 * 创建时间：2017年9月21日 下午15:41:00
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月21日 下午15:41:00
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("updateRole")
	public String updateRole(Role role){
		roleService.updateRole(role);
		return "role/role_info_page";
	}
	/**
	 * deleteRoleById(删除角色列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月20日 下午3:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月20日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("deleteRoleById")
	@ResponseBody
	@RequiresPermissions("role:delete")
	public String deleteRoleById(int role_id){
		String returnStr =roleService.deleteRoleById( role_id);
		return returnStr;
	}
	/**
	 * roleDetailsByStaffId(根据用户id获取角色详情)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月20日 下午3:51:21
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月20日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("roleDetailsByStaffId")
	@RequiresPermissions("role:roleDetailsByStaffId")
	public void roleDetailsByStaffId(String id,HttpServletResponse response){
		List<Role> roleList=roleService.roleDetailsByStaffId(id);
		String formatlist = JSON.toJSONStringWithDateFormat(roleList, "yyyy-MM-dd");
		JsonUtil.outJson(formatlist,response);
	}
	/**
	 * roleDetailsPage(跳转用户角色详情页面)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月20日 下午3:51:21
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月20日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("roleDetailsPage")
	public String roleDetailsPage(String id,ModelMap map){
		map.put("id",id);
		return "role/roleDetails_page";
	}
	/**
	 * toupdateRoleAuuthPage(跳转角色赋权限页面，并查询指定节角色的权限)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月20日 下午3:51:21
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月20日 下午3:51:21
	 * 修改备注：
	 */
	@RequiresPermissions("role:update")
	@RequestMapping("toupdateRoleAuuthPage")
	public String toupdateRoleAuuthPage(String role_id,ModelMap modelMap){
		//获取所有权限集合
		List<Tree> tree = treeService.getAllTree();
		//根据角色idd获取对应的权限集合
		List<Tree> treeRoleList = treeService.getTreeRoleList(Integer.parseInt(role_id));
		//U对比两个集合并将群贤设置为选中
		List<Map> itemList = new ArrayList<>();
		for(Tree map:tree){
			for (Tree roleMenu : treeRoleList) {
				if (map.getId() == roleMenu.getId()) {
					map.setChecked(true);
					break;
				}
			}
			Map itemMap = new HashMap();
			itemMap.put("id", map.getId());
			itemMap.put("pId", map.getPid());
			itemMap.put("name", map.getName());
			itemMap.put("checked", map.isChecked());
			itemList.add(itemMap);
		}
		Gson gson = new Gson();
		String result = gson.toJson(itemList);
		modelMap.put("menuJson", result);
		modelMap.put("role_id",role_id);
		return "role/update_role_auth_page";
	}
	/**
	 * grantPermission(根据角色id给指定角色赋权限)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月20日 下午3:51:21
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月20日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("grantPermission")
	@ResponseBody
	public String grantPermission(String role_id,String id,HttpServletResponse response,HttpServletRequest request){
			treeService.grantPermission(role_id,id);
			//更改权限时候删除权限缓存
			CacheManager.getInstance().remove(String.valueOf(SeubjectUtil.getStaff().getId()));
		return "success";
	}
	/**
	 * toRoleAddPage(跳转新增角色页面)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月29日 下午1:58:59
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月29日 下午1:58:59
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("toRoleAddPage")
	public String toRoleAddPage(){
		return "role/add_role_page";
	}
	/**
	 * insertSaff(新增角色)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月29日 下午1:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月29日 下午1:51:21
	 * 修改备注：
	 */
	@RequestMapping("insertRole")
	public String insertRole(Role role){
		roleService.insertRole(role);
		return "role/role_info_page";
	}
}
