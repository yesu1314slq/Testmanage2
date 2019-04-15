package com.ideal.uam.service.login;
import java.util.List;
import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.entity.Tree;

public interface LoginService {
	//根据用户名查询用户service层接口
	Staff getUserByUserName(String userName);

	//根据用户ID查询角色service层接口
	List<Role> getRoleList(int userId);

	//新增用户service层接口
	void insertUser(Staff staff);

    List<Tree> findPermissions(int userId);
}
