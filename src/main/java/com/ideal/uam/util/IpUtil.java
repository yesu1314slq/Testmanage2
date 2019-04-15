package com.ideal.uam.util;/**
 * 项目名称:${project_name}
 * 类名称:IpUtil
 * 创建人：吕金刚 lvjghappy@163.com
 * 创建时间：${date} ${time}
 * 修改人：吕金刚 lvjghappy@163.com
 * 修改时间：${date} ${time}
 * 修改备注：
 *
 * @return
 **/

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 类名称:IpUtil
 * 创建人：吕金刚 lvjghappy@163.com    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改备注：
 * @return
 **/
public class IpUtil {
    //获取客户的真实iP
    public static   String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}
