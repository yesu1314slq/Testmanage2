package com.ideal.uam.web.controller.user;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Role_2_auth;
import com.ideal.uam.entity.Staff_2_role;
import com.ideal.uam.service.login.LoginService;
import com.ideal.uam.service.role.RoleService;
import com.ideal.uam.util.ExcelUtil;
import com.ideal.uam.util.JsonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.service.user.StaffService;
import com.ideal.uam.util.Page;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：StaffController    
 * 类描述：   员工管理 
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 下午5:54:49    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 下午5:54:49    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("staff")
public class StaffController{
	@Autowired
	private StaffService staffService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private RoleService roleService;
	private Page page=new Page();
	/**
	 * getStaffInfoPage(跳转到用户管理页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月11日 下午5:59:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月11日 下午5:59:28    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getStaffInfoPage")
	@RequiresPermissions("staff:find")
	public String getStaffInfoPage(){
		return "staff/staff_list_page";
	}
	/**
	 * toStaffAddPage(跳转新增用户页面)   
	 * 创建人：shiliqing 15727396454@163.com    
	 * 创建时间：2017年9月15日 下午4:58:59    
	 * 修改人：shiliqing 15727396454@163.com     
	 * 修改时间：2017年9月15日 下午4:58:59    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toStaffAddPage")
	public String toStaffAddPage(){
		return "staff/add_user_page";
	}

	/**
	 * toStaffEditPage(跳转编辑用户页面)
	 * 创建人：wanglu
	 * 创建时间：2017年9月19日 下午15:31:59
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("toStaffEditPage")
	@RequiresPermissions("staff:update")
	public String toStaffEditPage(HttpServletRequest request,ModelMap map){
		String id = request.getParameter("id");
		Staff staff = staffService.getStaffById(id);
		List<Role> list=staffService.getRoleStaffList(id);
		map.put("staffmap",staff);
		map.put("roleList",list);
		return "staff/edit_staff_page";
	}

	/**
	 * toStaffEditPage(保存用户)
	 * 创建人：wanglu
	 * 创建时间：2017年9月19日 下午16:59:00
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("updateStaff")
	public String updateStaff(Staff staff){
		staffService.updateStaff(staff);
		return "staff/staff_list_page";
	}
	/**
	 * getstaffList(获取用户列表)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 下午3:51:21    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 下午3:51:21    
	 * 修改备注：
	 */
	@RequestMapping("getstaffList")
	public void getstaffList(Staff staff,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(staff);
		staffService.getstaffList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}
	/**
	 * insertSaff(新增用户列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月18日 下午3:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月18日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("insertSaff")
	public String insertSaff(Staff staff){
		loginService.insertUser(staff);
		return "staff/staff_list_page";
	}
	/**
	 * deleteStaffById(删除用户列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月20日 下午3:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月20日 下午3:51:21
	 * 修改备注：
	 */
	@RequestMapping("deleteStaffById")
	@ResponseBody
	@RequiresPermissions("staff:delete")
	public String deleteStaffById(int id){
		String returnStr =staffService.deleteStaffById( id);
		return returnStr;
	}

	/**
	 * exportExcel(导出用户管理到EXCEL)
	 * 创建人：zhangzheng
	 * 创建时间：2017年9月19日 下午15:55:21
	 * 修改备注：
	 */
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletResponse response){
		List<Staff> logList = page.getList();
		List<Object> objList = new ArrayList<>();
		for(Staff staff1:logList){
			Staff staff = new Staff();
			staff.setName(staff1.getName());
			staff.setOrg_id(staff1.getOrg_id());
			staff.setSpell(staff1.getSpell());
			staff.setStaff_number(staff1.getStaff_number());
			staff.setLink_tel(staff1.getLink_tel());
			staff.setRemark(staff1.getRemark());
			objList.add(staff);
		}
		String[] Title = { "员工名称","组织ID","简拼","工号","联系电话","备注"};
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		int[] widthNum = {25,25,65,25,25,25};
		ExcelUtil.ExportExcel("用户管理"+dateFormater.format(new Date())+".xls", Title, objList,widthNum,objList.size(),response);
	}
}
