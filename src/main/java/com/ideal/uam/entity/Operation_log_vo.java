package com.ideal.uam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Operation_log    
 * 类描述：导出Excel类
 * 创建人：王璐
 * 创建时间：2017年9月19日 下午3:18:15
 * 修改备注：
 * @version
 */
public class Operation_log_vo{

	//员工操作日志工号
	private String staff_number;
	//员工操作日志登录ip
	private String ip_address;
	//员工操作日志操作记录
	private String operation_desc;

	public String getStaff_number() {
		return staff_number;
	}
	public void setStaff_number(String staff_number) {
		this.staff_number = staff_number;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getOperation_desc() {
		return operation_desc;
	}
	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
	public Operation_log_vo() {
		super();
	}
	
}
