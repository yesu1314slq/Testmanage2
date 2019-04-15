package com.ideal.uam.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：WebContext    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:54:16    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:54:16    
 * 修改备注：       
 * @version
 */
public class WebContext {
	//将request放入到ThreadLocal中
	private static ThreadLocal<HttpServletRequest> local=new ThreadLocal<>();
	//将respone放入到ThreadLocal中
	private  static ThreadLocal<HttpServletResponse> responselocal=new ThreadLocal<>();
	//给每个线程设置request
	public static void setRequest(HttpServletRequest request){
		local.set(request);
	}
	//获取唯一的request
	public static HttpServletRequest getRequest(){
		return local.get();
	}
	//给每个线程设置response
	public static void setresponse(HttpServletResponse response){
		responselocal.set(response);
	}
	//获取唯一的response
	public static HttpServletResponse getRsponse(){
		return responselocal.get();
	}
	//清空
	public static void destory(){
		local.remove();
		responselocal.remove();
	}
}
