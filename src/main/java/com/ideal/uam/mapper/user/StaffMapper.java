package com.ideal.uam.mapper.user;

import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.*;
import com.ideal.uam.util.Page;

public interface StaffMapper {

	//查询用户管理及分页Dao层接口
	List<Staff> getstaffList(Page page);

	//查询用户管理的总条数Dao层接口
	Integer getCount(Page page);

	//根据用户ID查询用户管理的一个对象Dao层接口
	Staff getStaffById(String id);

	//修改用户管理的一个对象Dao层接口
	void updateStaff(Staff staff);

	//根据用户ID删除用户管理的一个对象Dao层接口
	int deleteStaffById(int id);

	//根据用户ID查询用户角色Dao层接口
	List<Map> getRoleStaffList(String id);

    List<Tree> findPermissions(int userId);
}
