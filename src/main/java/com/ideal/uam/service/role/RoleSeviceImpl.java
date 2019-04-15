package com.ideal.uam.service.role;

import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.Staff;
import com.ideal.uam.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Role;
import com.ideal.uam.mapper.role.RoleMapper;
import com.ideal.uam.util.Page;
@Service
public class RoleSeviceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	//查询角色管理及分页service层实现
	@Override
	public void getRoleListPage(Page page) {
		//获取集合
		List<Role> list=roleMapper.getRoleListPage(page);
		//获取总条数
		Integer count=roleMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID查询角色管理的一个对象service层实现
	@Override
	public Role getRoleById(String role_id) {
		return roleMapper.getRoleById(role_id);
	}

	//修改角色管理的一个对象service层实现
	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	//根据ID删除用户管理的一个对象service层实现
	@Override
	public String deleteRoleById(int role_id) {
		int a=roleMapper.deleteRoleById(role_id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}
	}

	//查询角色管理service层实现
	@Override
	public List<Role> getRoleList() {
		return roleMapper.getRoleAllList();
	}

	//根据ID删除用户角色service层实现
	@Override
	public void deleteStaffRoleById(int id) {
		roleMapper.deleteStaffRoleById(id);
	}

	//新增用户角色service层实现
	@Override
	public void insertStaffRoleById(Map map) {
		roleMapper.insertStaffRoleById(map);
	}

	//根据用户ID查询角色详情service层实现
	@Override
	public List<Role> roleDetailsByStaffId(String id) {
		return roleMapper.roleDetailsByStaffId(id);
	}

	//新增角色service层实现
	@Override
	public void insertRole(Role role) { roleMapper.insertRole(role); }
}
