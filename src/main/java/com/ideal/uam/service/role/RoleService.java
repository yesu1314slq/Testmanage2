package com.ideal.uam.service.role;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.util.Page;

import java.util.List;
import java.util.Map;

public interface RoleService {

	//查询角色管理及分页service层接口
	void getRoleListPage(Page page);

	//根据ID查询角色管理的一个对象service层接口
	Role getRoleById(String id);

	//修改角色管理的一个对象service层接口
	void updateRole(Role role);

	//根据ID删除用户管理的一个对象service层接口
	String deleteRoleById(int role_id);

	//查询角色管理service层接口
	List<Role> getRoleList();

	//根据ID删除用户角色service层接口
	void deleteStaffRoleById(int id);

	//新增用户角色service层接口
	void insertStaffRoleById(Map map);

	//根据用户ID查询角色详情service层接口
    List<Role> roleDetailsByStaffId(String id);

	//新增角色service层接口
	void insertRole(Role role);
}
