package com.ideal.uam.web.controller.acc;

import java.util.HashMap;
import java.util.Map;

import com.ideal.uam.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ideal.uam.entity.All_interface;
import com.ideal.uam.entity.Provincial_interface_agreements;
import com.ideal.uam.service.acc.AllInterfaceService;
import com.ideal.uam.service.acc.ProvincialInterfaceAgreementsService;
import com.ideal.uam.util.Page;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("acc")
public class AccController {
	@Autowired
	private AllInterfaceService allInterfaceService;
	@Autowired
	private ProvincialInterfaceAgreementsService provincialInterfaceAgreementsService;
	
	private Page page=new Page();
	/**
	 * getAllInterface(各个接口调用详情)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月7日 上午11:19:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月7日 上午11:19:22    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAllInterface")
	public String getAllInterface(){
		return "acc/all_Interface";
	}
	/**
	 * getAllSheng(各个省调用详情)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月7日 上午11:32:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月7日 上午11:32:22    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getProvincesCall")
	public String getProvincesCall(){
		return "acc/provinces_call";
	}
	
	/**
	 * getProvincialInterfaceAgreements(各省接口协议查询)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月7日 上午11:37:18    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月7日 上午11:37:18    
	 * 修改备注： 
	 * @return
	 */
	
	@RequestMapping("getProvincialInterfaceAgreements")
	public String getProvincialInterfaceAgreements(){
		return "acc/provincial_interface_agreements";
	}
	
	
	/**
	 * getAllInterfaceList(各个接口调用详情)   
	 * 创建人：shiliqing 15727396454@163.com    
	 * 创建时间：2017年9月14日 下午3:19:22    
	 * 修改人：shiliqing 15727396454@163.com     
	 * 修改时间：2017年9月14日 下午3:19:22    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAllInterfaceList")
	@ResponseBody
	public void getAllInterface(All_interface all,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(all);
		allInterfaceService.getAllInterface(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}
	
	
	/**
	 * getProvincialInterfaceAgreementsList(各省接口协议查询)   
	 * 创建人：shiliqing 15727396454@163.com    
	 * 创建时间：2017年9月14日 下午14:37:18    
	 * 修改人：shiliqing 15727396454@163.com     
	 * 修改时间：2017年9月14日 下午14:37:18    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getProvincialInterfaceAgreementsList")
	@ResponseBody
	public void getProvincialInterfaceAgreements(Provincial_interface_agreements call,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(call);
		provincialInterfaceAgreementsService.getProvincialInterfaceAgreements(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}
	/**
	 * deleteALLById(各个接口调用删除)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月14日 下午3:19:22
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月14日 下午3:19:22
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("deleteALLById")
	@ResponseBody
	public String deleteALLById(String id){
		String returnStr =allInterfaceService.deleteALLById(id);
		return returnStr;
	}

	/**
	 * deleteAgreementsById(各省调用协议的删除)
	 * 创建人：shiliqing 15727396454@163.com
	 * 创建时间：2017年9月21日 上午9:19:22
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月21日 上午9:19:22
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("deleteAgreementsById")
	@ResponseBody
	public String deleteAgreementsById(String id){
		String returnStr =provincialInterfaceAgreementsService.deleteAgreementsById(id);
		return returnStr;
	}
}
