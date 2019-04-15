package com.ideal.uam.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：AuthorityController    
 * 类描述：权限管理    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:07:13    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:07:13    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("auth")
public class AuthorityController {
	/**
	 * getAuthPage(获取权限管理页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 上午9:08:20    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 上午9:08:20    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAuthPage")
	public String getAuthPage(){
		return "auth/auth_info_page";
	}
}
