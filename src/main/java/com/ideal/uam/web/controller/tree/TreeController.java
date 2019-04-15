package com.ideal.uam.web.controller.tree;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideal.uam.entity.Staff;
import com.ideal.uam.util.SeubjectUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideal.uam.service.tree.TreeService;
import com.ideal.uam.util.JsonUtil;

@Controller
@RequestMapping("tree")
public class TreeController {
	@Autowired
	private TreeService treeService;
	/**
	 * getTree(获得树)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月6日 下午10:33:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月6日 下午10:33:59    
	 * 修改备注：
	 * @param  
	 */
	@RequestMapping("getTree")
	public void getTree(HttpServletResponse response ){
		List<Map> menuList=treeService.getTree(SeubjectUtil.getStaff().getId());
		JsonUtil.outJson(menuList, response);
	}
}
