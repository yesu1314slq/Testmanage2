package com.ideal.uam.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Role_2_auth;
import com.ideal.uam.entity.Staff_2_role;
import com.ideal.uam.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Staff;
import com.ideal.uam.mapper.user.StaffMapper;
import com.ideal.uam.util.Page;


@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private RoleService roleService;

	@Autowired
	private StaffMapper staffMapper;

	//查询用户管理及分页servic层实现
	@Override
	public void getstaffList(Page page) {
		//获取集合
		List<Staff> list=staffMapper.getstaffList(page);
		//获取总条数
		Integer count=staffMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID查询用户管理的一个对象service层实现
	@Override
	public Staff getStaffById(String id) {
		return staffMapper.getStaffById(id);
	}

	//修改用户管理的service层实现
	@Override
	public void updateStaff(Staff staff) {
		staffMapper.updateStaff(staff);
		//删除原有的角色
		roleService.deleteStaffRoleById(staff.getId());
		String[] split = staff.getRole_id().split(",");
		for (int i=0;i<split.length;i++){
			Map map=new HashMap();
			map.put("id",staff.getId());
			map.put("role_id",split[i]);
			roleService.insertStaffRoleById(map);
		}
	}
	//根据ID删除用户管理service层实现
	@Override
	public String deleteStaffById(int id) {
		int a=staffMapper.deleteStaffById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}
	}
	//根据ID查询用户角色service层实现
	@Override
	public List<Role> getRoleStaffList(String id) {
		List<Role> roleList = roleService.getRoleList();
		List<Map> roleStaffList = staffMapper.getRoleStaffList(id);
		for (Role role:roleList){
			for(Map sr:roleStaffList){
				if((int)sr.get("role_id")==role.getRole_id()){
					role.setBen(true);
				}
			}
		}
		return roleList;
	}


}
