package com.ideal.uam.service.tree;

import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.Tree;

public interface TreeService {

	//查询树service层接口
	List<Map> getTree(int id);

	//根据角色ID查询角色权限service层接口
	List<Tree> getTreeRoleList(int role_id);

	//查询树service层接口
	List<Tree> getAllTree();

	//根据树ID,角色的ROLE_ID发放权限service层接口
	void grantPermission(String role_id, String id);
}
