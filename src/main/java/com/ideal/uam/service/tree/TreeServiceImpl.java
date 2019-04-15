package com.ideal.uam.service.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Tree;
import com.ideal.uam.mapper.tree.TreeMapper;

@Service
public class TreeServiceImpl implements TreeService{

	@Autowired
	private TreeMapper treeMapper;


	//查询树service层实现
	@Override
	public List<Map> getTree(int id) {
		List<Tree> list = treeMapper.getTree(id);
		List<Map> TreeList=getTreeListByPid(list,0);
		//递归查询树形结构
		for (Map map : TreeList) {
			List<Map> children =getTreeChildren(map,list);
			map.put("nodes", children);
		}
		return TreeList;
	}

	//通过第一个节点查询出下面的所有子节点
	private List<Map> getTreeChildren(Map map, List<Tree> list) {
		List<Map> children = new ArrayList<Map>();
		for (Tree mapTree : list) {
			if((int)map.get("id")==mapTree.getPid()){
				Map itemMap = new HashMap();
				itemMap.put("id",mapTree.getId());
				itemMap.put("pid",mapTree.getPid());
				itemMap.put("text",mapTree.getName());
				itemMap.put("url", mapTree.getUrl());
				List<Map> treeChildren = getTreeChildren(itemMap,list);
				if(treeChildren.size()>0){
					itemMap.put("nodes",treeChildren);
				}
				children.add(itemMap);
			}
		}
		return children;
	}

	//通过父节点查询下面的子节点
	private List<Map> getTreeListByPid(List<Tree> list, int i) {
		List<Map> mapList =new ArrayList<Map>();
		for (Tree map : list) {
			if(map.getPid()==i){
				Map item = new HashMap();
				item.put("id", map.getId());
				item.put("pid", map.getPid());
				item.put("text", map.getName());
				item.put("url", map.getUrl());
				mapList.add(item);
			}
		}
		return mapList;
	}

	//根据角色ID查询角色权限service层实现
	@Override
	public List<Tree> getTreeRoleList(int role_id) {
		return treeMapper.getTreeRoleList(role_id);
	}

	//查询树service层实现
	@Override
	public List<Tree> getAllTree() {
		return  treeMapper.getAllTree();
	}

	//根据树ID,角色的ROLE_ID发放权限service层实现
	@Override
	public void grantPermission(String role_id, String id) {
		//根据角色id删除原来的所有权限
		treeMapper.deletePermission(role_id);
		//重新给指定角色赋权限
		if (StringUtils.isNotEmpty(id)) {
			String[] split = id.split(",");
			for(int i=0;i<split.length;i++){
				Map map=new HashMap();
				map.put("role_id",role_id);
				map.put("id",split[i]);
				treeMapper.insertPermission(map);
			}
		}

	}


}
