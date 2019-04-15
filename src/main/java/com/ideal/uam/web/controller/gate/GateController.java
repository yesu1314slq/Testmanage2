package com.ideal.uam.web.controller.gate;

import java.util.HashMap;
import java.util.Map;

import com.ideal.uam.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ideal.uam.entity.Gate_project_details;
import com.ideal.uam.entity.Uam_project_details;
import com.ideal.uam.service.gate.GateService;
import com.ideal.uam.util.Page;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：GateController    
 * 类描述：gate管理    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:40:21    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:40:21    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("gate")
public class GateController {
	
	@Autowired
	private GateService gateService;
	
	private Page page=new Page();
	/**
	 * getGatePage(获取gate详情页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 上午9:41:24    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 上午9:41:24    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getGatePage")
	public String getGatePage(){
		return "gate/gate_info_page";
	}
	/**
	 * getGateProjectDetailsList(获取uam项目列表)   
	 * 创建人：shiliqing 15727396454@163.com    
	 * 创建时间：2017年9月14日 下午14:37:18    
	 * 修改人：shiliqing 15727396454@163.com     
	 * 修改时间：2017年9月14日 下午14:37:18    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getGateProjectDetailsList")
	@ResponseBody
	public void getGateProjectDetailsList(Gate_project_details uam,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(uam);
		gateService.getGateList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}
	/**
	 * deleteGateById(删除Gate列表)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月21日 下午1:51:21
	 * 修改人：shiliiqng 15727396454@163.com
	 * 修改时间：2017年9月21日 下午1:51:21
	 * 修改备注：
	 */
	@RequestMapping("deleteGateById")
	@ResponseBody
	public String deleteGateById(String id){
		String returnStr =gateService.deleteGateById( id);
		return returnStr;
	}

}
