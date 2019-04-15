package com.ideal.uam.web.controller.uam;

import java.util.HashMap;
import java.util.Map;

import com.ideal.uam.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ideal.uam.entity.Provincial_interface_agreements;
import com.ideal.uam.entity.Uam_project_details;
import com.ideal.uam.service.uam.UamService;
import com.ideal.uam.util.Page;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：UamController    
 * 类描述：uam管理    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:43:40    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:43:40    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("uam")
public class UamController {
	@Autowired
	private UamService uamService;
	
	private Page page=new Page();
	
	/**
	 * getUamPage(获取uam详情页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 上午9:44:35    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 上午9:44:35    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getUamPage")
	public String getUamPage(){
		return "uam/uam_info_page";
	}
	
	/**
	 * getUamProjectDetailsList(获取uam项目列表)   
	 * 创建人：shiliqing 15727396454@163.com    
	 * 创建时间：2017年9月14日 下午14:37:18    
	 * 修改人：shiliqing 15727396454@163.com     
	 * 修改时间：2017年9月14日 下午14:37:18    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getUamProjectDetailsList")
	@ResponseBody
	public void getUamProjectDetailsList(Uam_project_details uam,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(uam);
		uamService.getUamList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}
	/**
	 * deleteUamById(删除Uam列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月21日 上午10:01:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月21日 上午10:01:21
	 * 修改备注：
	 */
	@RequestMapping("deleteUamById")
	@ResponseBody
	public String deleteUamById(String id){
		String returnStr =uamService.deleteUamById(id);
		return returnStr;
	}

}
