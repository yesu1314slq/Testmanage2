package com.ideal.uam.job;/**
 * 项目名称:${project_name}
 * 类名称:LogJob
 * 创建人：吕金刚 lvjghappy@163.com
 * 创建时间：${date} ${time}
 * 修改人：吕金刚 lvjghappy@163.com
 * 修改时间：${date} ${time}
 * 修改备注：
 *
 * @return
 **/

import com.ideal.uam.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 类名称:LogJob
 * 创建人：吕金刚 lvjghappy@163.com    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改备注：
 * @return
 **/
@Component
public class LogJob {
    @Autowired
    private LogService logService;

   private static long logTimeout=90*24*60*60;

    /**
     * 定时清理员工操作日志文件
     */
    @Scheduled(cron = "0 0 0 1 * ?")
    public   void deleteLog(){
        //保留最近二个月的操作日志
        System.out.println("-------------------------清楚操作日志----------------------------");
        logService.deleteAll();
    }
}
