package com.ideal.uam.web.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.LifecycleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideal.uam.entity.Staff;
import com.ideal.uam.service.login.LoginService;
import com.ideal.uam.util.JsonUtil;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 项目名称：ct10000uam-manage
 * 类名称：LoginController
 * 类描述：    登录
 * 创建人：吕金刚 lvjghappy@163.com
 * 创建时间：2017年9月6日 下午6:09:40
 * 修改人：吕金刚 lvjghappy@163.com
 * 修改时间：2017年9月6日 下午6:09:40
 * 修改备注：
 * @version
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	/**
	 * getlogin(登录方法)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月12日 下午2:43:08
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月12日 下午2:43:08
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("userLogin")
	public void getlogin(HttpServletRequest request,Staff staff,String imgCode,HttpServletResponse response){
		String code = (String)request.getSession().getAttribute("code");
		if(!code.equals(imgCode)){
			JsonUtil.outJson("验证码错误", response);
		}else{
			UsernamePasswordToken token=new UsernamePasswordToken(staff.getName(),staff.getPwd());
			Subject subject=SecurityUtils.getSubject();
			try{
				token.setRememberMe(true);
				subject.login(token);
				if(subject.isAuthenticated()){
					Staff u = (Staff)subject.getPrincipal();
					subject.getSession().setAttribute("staff",u);
					JsonUtil.outJson(1, response);
				}else{
					JsonUtil.outJson(0, response);
				}
			}catch(AuthenticationException e){
			}
		}
	}
	/**
	 * loginOut(注销方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 下午2:43:08    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 下午2:43:08    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
	/**
	 * getIndexPage(跳转到登录页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 下午2:42:54    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 下午2:42:54    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getIndexPage")
	public String getIndexPage(){
		return "../../index";
	}
	/**
	 * toUserAddPage(跳转注册页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 下午2:58:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 下午2:58:59    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toUserAddPage")
	public String toUserAddPage(){
		return "staff/add_staff_page";
	}
	/**
	 * insertUser(用户增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 下午3:04:42    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 下午3:04:42    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("insertUser")
	public String insertUser(Staff staff){
		loginService.insertUser(staff);
		return "../../login";
	}
	/**
	 * insertUser(用户管理的增加方法)
	 * 创建人：吕金刚 lvjghappy@163.com
	 * 创建时间：2017年9月12日 下午3:04:42
	 * 修改人：吕金刚 lvjghappy@163.com
	 * 修改时间：2017年9月12日 下午3:04:42
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("insertSaff")
	@ResponseBody
	public String insertSaff(Staff staff){
		try {
			loginService.insertUser(staff);
			return "ok";
		} catch (Exception e) {
			return "error";
		}
	}
}
