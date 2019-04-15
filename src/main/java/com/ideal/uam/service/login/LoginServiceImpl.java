package com.ideal.uam.service.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ideal.uam.entity.Tree;
import com.ideal.uam.mapper.user.StaffMapper;
import com.ideal.uam.service.user.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.mapper.login.LoginMapper;
import com.ideal.uam.mapper.role.RoleMapper;
import com.ideal.uam.util.Md5Util;

@Service
public   class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private StaffMapper staffMapper;

	//根据用户名查询用户service层实现
	@Override
	public Staff getUserByUserName(String userName) {
		return loginMapper.getUserByUserName(userName);
	}

	//根据用户ID查询角色service层实现
	@Override
	public List<Role> getRoleList(int userId) {
		return roleMapper.getRoleList(userId);
	}

	//新增用户service层实现
	@Override
	public void insertUser(Staff staff) {
		staff.setPwd(Md5Util.jiami(staff.getPwd()));
		loginMapper.insertUser(staff);
	}

	@Override
	public List<Tree> findPermissions(int userId) {
		return staffMapper.findPermissions(userId);
	}

}