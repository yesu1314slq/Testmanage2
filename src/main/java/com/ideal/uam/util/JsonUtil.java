/** 
 * 项目名称:ct10000uam-manage 
 * 文件名称:JsonUtil.java 
 * 包名:org.lv.shop.util 
 * 创建日期:2017年5月21日上午10:51:14 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package com.ideal.uam.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** 
 * 项目名称：ct10000uam-manage    
 * 类名称：JsonUtil    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月21日 上午10:51:14    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月21日 上午10:51:14    
 * 修改备注：       
 * @version   
 */
public class JsonUtil {
	/**
	 * outJson(把对象输出给前台)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:56:42    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:56:42    
	 * 修改备注： 
	 * @param obj
	 * @param response
	 */
	public static void outJson(Object obj,HttpServletResponse response){
		Gson gson=new Gson();
		String json = gson.toJson(obj);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=null;
		try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * outJson(把json字符串输出给前台)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:56:11    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:56:11    
	 * 修改备注： 
	 * @param json
	 * @param response
	 */
	public static void outJson(String json,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=null;
		try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
			}
