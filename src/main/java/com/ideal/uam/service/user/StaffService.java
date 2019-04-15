package com.ideal.uam.service.user;

import com.ideal.uam.entity.*;
import com.ideal.uam.util.Page;

import java.util.List;
import java.util.Map;

public interface StaffService {

	//查询用户管理及分页servic层接口
	void getstaffList(Page page);

	//根据ID查询用户管理的一个对象service层接口
	Staff getStaffById(String id);

	//修改用户管理的service层接口
	void updateStaff(Staff staff);

	//根据ID删除用户管理service层接口
	String deleteStaffById(int id);

	//根据ID查询用户角色service层接口
	List<Role> getRoleStaffList(String id);

}
