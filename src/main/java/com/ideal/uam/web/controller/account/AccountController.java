package com.ideal.uam.web.controller.account;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：AccountController    
 * 类描述：统一账号管理    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 下午5:18:41    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 下午5:18:41    
 * 修改备注：       
 * @version
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.util.JsonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.entity.Unified_account;
import com.ideal.uam.service.account.AccountService;
import com.ideal.uam.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	private Page page=new Page();
	/**
	 * getAccountListPage(获取统一账号查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月11日 下午5:38:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月11日 下午5:38:17    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAccountListPage")
	public String getAccountListPage(){
		return "account/account_list_page";
	}
	
	/**
	 * getAccountListPage(获取统一账号查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月11日 下午5:38:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月11日 下午5:38:17    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAccountList")
	@ResponseBody
	public void getAccountList(Unified_account un,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(un);
		accountService.getAccountList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}
	/**
	 * deleteAccountById(删除统一账号管理列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月21日 下午3:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月21日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("deleteAccountById")
	@ResponseBody
	public String deleteAccountById(String id){
		String returnStr =accountService.deleteAccountById( id);
		return returnStr;
	}
	/**
	 * toAccountEditPage(跳转到统一账号管理更改密码页面)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年10月2日 下午1:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年10月2日 下午1:51:21
	 * 修改备注：
	 */
	@RequestMapping("toAccountEditPage")
	public String toAccountEditPage(HttpServletRequest request){
		String id = request.getParameter("id");
		Unified_account account = accountService.getAccountById(id);
		request.setAttribute("account",account);
		return "account/edit_account_page";
	}
	/**
	 * toAccountEditPage(修改统一账号管理)
	 * 创建人：shililing 15727396454@163.com
	 * 创建时间：2017年10月2日 下午2:00:00
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年10月2日 下午2:00:00
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("updateAccount")
	public String updateAccount(Unified_account account){
		accountService.updateAccount(account);
		return "account/account_list_page";
	}
}
