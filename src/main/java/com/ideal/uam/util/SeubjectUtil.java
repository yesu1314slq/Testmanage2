package com.ideal.uam.util;/**
 * 项目名称:${project_name}
 * 类名称:SeubjectUtil
 * 创建人：吕金刚 lvjghappy@163.com
 * 创建时间：${date} ${time}
 * 修改人：吕金刚 lvjghappy@163.com
 * 修改时间：${date} ${time}
 * 修改备注：
 *
 * @return
 **/

import com.ideal.uam.entity.Staff;
import org.apache.shiro.SecurityUtils;

/**
 * 类名称:SeubjectUtil
 * 创建人：吕金刚 lvjghappy@163.com    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改备注：
 * @return
 **/
public class SeubjectUtil {
    /**
     * 获取当前用户的公共方法
     * @return
     */
    public static Staff getStaff(){
        Staff staff = (Staff)SecurityUtils.getSubject().getSession().getAttribute("staff");
        return staff;
    }
}
