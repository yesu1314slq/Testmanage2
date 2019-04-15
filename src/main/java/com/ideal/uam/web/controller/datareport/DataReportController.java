package com.ideal.uam.web.controller.datareport;

import com.alibaba.fastjson.JSON;
import com.ideal.uam.service.report.DataReportService;
import com.ideal.uam.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：DataReportController    
 * 类描述：数据报表    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月7日 下午12:44:30    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月7日 下午12:44:30    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("datareport")
public class DataReportController {

	@Autowired
	 private DataReportService dataReportService;
	/**
	 * getDataReport(跳转数据报表页面方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月7日 下午12:45:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月7日 下午12:45:17    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getDataReport")
	public String getDataReport(){
		return "datareport/data_report";
	}
	/**
	 * getDataReport(获取数据报表)
	 * 创建人：shiliiqng 15727396454@163.com
	 * 创建时间：2017年9月27日 下午2:13:17
	 * 修改人：shiliqing 15727396454@163.com
	 * 修改时间：2017年9月27日 下午2:13:17
	 * 修改备注：
	 * @return
	 */
	@RequestMapping("getDataReportList")
	public void getDataReportList(HttpServletResponse response){
		List<Map> mapList=dataReportService.getDataReportList();
		List<String> list=new ArrayList<String>();
		List<Map> listInfo=new ArrayList<Map>();
		for(Map  item: mapList){
			list.add((String)item.get("name"));
			Map map=new HashMap();
			map.put("name",item.get("name"));
			map.put("value",item.get("count"));
			listInfo.add(map);
		}
		Map map=new HashMap();
		map.put("legend",list);
		map.put("series",listInfo);
		JsonUtil.outJson(map,response);
	}

}
