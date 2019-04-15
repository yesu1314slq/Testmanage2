package com.ideal.uam.mapper.login;

import com.ideal.uam.entity.Staff;

public interface LoginMapper {
	//通过登录名称进行查询用户Dao层接口
	Staff getUserByUserName(String userName);
	//新增用户Dao层接口
	void insertUser(Staff staff);
}
