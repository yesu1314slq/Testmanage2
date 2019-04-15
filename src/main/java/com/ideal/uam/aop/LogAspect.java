package com.ideal.uam.aop;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.ideal.uam.util.IpUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map.Entry;

import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.service.log.LogService;
import com.ideal.uam.util.WebContext;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：LogAspect    
 * 类描述：日志切面类    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月12日 上午9:57:28    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月12日 上午9:57:28    
 * 修改备注：       
 * @version
 */
public class LogAspect {
	
	private static final Logger LOG=Logger.getLogger(LogAspect.class);
	@Autowired
	private LogService logService;
	//aop对日志进行统一处理
	public Object doLog(ProceedingJoinPoint pjp){
		Object reslut=null;
		//获取类的全称
		String canonicalName = pjp.getTarget().getClass().getCanonicalName();
		//获取方法名
		String name = pjp.getSignature().getName();
		//获取当前访问的url
		HttpServletRequest request = WebContext.getRequest();
		//获取请求的参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		StringBuffer parame=new StringBuffer();
		for (Entry<String, String[]> entry : entrySet) {
			parame.append(entry.getKey()+":"+Arrays.toString(entry.getValue())+";");
		}
		LOG.info("开始执行---"+canonicalName+"."+name+"()"+request.getRequestURI());
		 try {
			 //执行业务核心代码
			reslut = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			LOG.error(canonicalName+"."+name+"()"+e);
			Operation_log lg=new Operation_log();
			lg.setType(1);
			lg.setId(UUID.randomUUID().toString());
			lg.setIp_address(request.getLocalAddr());
			lg.setOperation_desc(canonicalName+"."+name+"()"+e);
			lg.setOperation_time(new Date());
			Staff user = (Staff)request.getAttribute("staff");
			//lg.setStaff_number(user.getStaff_number());
			logService.insertLog(lg);
			 if (e instanceof UnauthorizedException) {
				 throw new UnauthorizedException(e.getMessage());
			 }
			 return reslut;
		}
		 Operation_log lg=new Operation_log();
			lg.setType(0);
			lg.setId(UUID.randomUUID().toString());
			lg.setIp_address(IpUtil.getIpAddress(request));
			lg.setOperation_desc(canonicalName+"."+name+"()");
			lg.setOperation_time(new Date());
			Staff user = (Staff)request.getAttribute("staff");
			//lg.setStaff_number(user.getStall_namber());
			logService.insertLog(lg);
		return reslut;
	}

}
