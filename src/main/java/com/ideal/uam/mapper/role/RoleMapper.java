package com.ideal.uam.mapper.role;

import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.util.Page;

public interface RoleMapper {
	//根据用户ID查询角色管理Dao层接口
	List<Role> getRoleList(int userId);

	//查询用户管理及分页的Dao层接口
	List<Role> getRoleListPage(Page page);

	//查询用户管理总条数Dao层接口
	Integer getCount(Page page);

	//根据角色ID查询角色管理Dao层接口
	Role getRoleById(String role_id);

	//修改角色管理的一个对象Dao层接口
	void updateRole(Role role);

	//删除角色管理的一个对象Dao层接口
	int deleteRoleById(int role_id);

	//查询角色管理Dao层接口
	List<Role> getRoleAllList();

	//删除用户权限的一个对象Dao层接口
    void deleteStaffRoleById(int id);

	//新增用户权限的一个对象Dao层接口
	void insertStaffRoleById(Map map);

	//根据用户ID查询角色详情Dao层接口
    List<Role> roleDetailsByStaffId(String id);

	//新增角色Dao层接口
	void insertRole(Role role);
}
