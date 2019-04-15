package com.ideal.uam.mapper.tree;

import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.Tree;

public interface TreeMapper {
	//查询树Dao层接口
	List<Tree> getTree(int id);

	//根据角色ID查询角色权限Dao层接口
	List<Tree> getTreeRoleList(int role_id);

	//新增权限Dao层接口
    void insertPermission(Map map);

	//根据角色ID删除权限Dao层接口
	void deletePermission(String role_id);

	//查询所有权限集合
    List<Tree> getAllTree();
}
