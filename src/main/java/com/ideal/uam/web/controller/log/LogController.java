package com.ideal.uam.web.controller.log;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ideal.uam.entity.Operation_log_vo;
import com.ideal.uam.util.ExcelUtil;
import com.ideal.uam.util.JsonUtil;
import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.service.log.LogService;
import com.ideal.uam.util.Page;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：LogController    
 * 类描述：操作日志管理    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:15:53    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:15:53    
 * 修改备注：       
 * @version
 */
@Controller
@RequestMapping("log")
public class LogController {
	@Autowired
	private LogService logService;
	
	private Page page=new Page();
	/**
	 * getLogPage(获取日志查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年9月12日 上午9:17:40    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年9月12日 上午9:17:40    
	 * 修改备注： 
	 * @return
	 */
	@RequiresPermissions("log:find")
	@RequestMapping("getLogPage")
	public String getLogPage(){
		return "log/log_info_page";
	}
	
	/**
	 * getlogList(获取用户列表)   
	 * 创建人：shiliqing 15727396454@163.com    
	 * 创建时间：2017年9月12日 下午3:51:21    
	 * 修改人： 15727396454@163.com      
	 * 修改时间：2017年9月12日 下午3:51:21    
	 * 修改备注：
	 */
	@RequestMapping("getlogList")
	@ResponseBody
	public void getlogList(Operation_log lg,Integer offset,Integer limit,HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(lg);
		logService.getlogList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		JsonUtil.outJson(map,response);
	}

	/**
	 * queryLogById(编辑用户列表)
	 * 创建人：zhangzheng
	 * @param id
	 * @return
	 * 修改备注：
	 */
	@RequestMapping("queryLogById")
	public String queryLogById(String id,HttpServletRequest request){
		Operation_log ol=logService.queryLogById(id);
		request.setAttribute("ol",ol);
		return "log/log_info_update";
	}

	/**
	 * deleteLogById(删除用户列表)
	 * 创建人：zhangzheng
	 * @param id
	 * @return
	 * 修改备注：
	 */
	@RequestMapping("deleteLogById")
	@ResponseBody
	public String deleteLogById(String id){

	String returnStr =logService.deleteLogById(id);
	return returnStr;
	}
	/**
	 * exportExcel(导出员工操作日志到EXCEL)
	 * 创建人：wanglu
	 * 创建时间：2017年9月19日 下午14:55:21
	 * 修改备注：
	 */
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletResponse response){
		List<Operation_log> logList = page.getList();
		List<Object> objList = new ArrayList<>();
		for(Operation_log obj:logList){
			Operation_log_vo olvo = new Operation_log_vo();
			olvo.setStaff_number(obj.getStaff_number());
			olvo.setIp_address(obj.getIp_address());
			olvo.setOperation_desc(obj.getOperation_desc());
			objList.add(olvo);
		}
		//Title为EXCEL的列名
		String[] Title = { "工号","登陆ip","操作记录"};
		//定义文件名拼接的导出时间
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		//定义EXCEL每列的宽度，当前为3列，前两列宽度为25，后一列为65
		int[] widthNum = {25,25,65};
		ExcelUtil.ExportExcel("员工操作日志"+dateFormater.format(new Date())+".xls", Title, objList,widthNum,objList.size(),response);
	}



}
