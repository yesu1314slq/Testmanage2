package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Operation_log    
 * 类描述：操作日志表    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 下午3:18:15    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 下午3:18:15    
 * 修改备注：       
 * @version
 */
public class Operation_log implements Serializable{

	private static final long serialVersionUID = -1775142329640133319L;
	//员工操作日志主键
	private String id;
	//员工操作日志工号
	private String staff_number;
	//员工操作日志登录ip
	private String ip_address;
	//员工操作日志操作时间
	private Date operation_time;
	//员工操作日志操作记录
	private String operation_desc;
	//员工操作日志状态：0为正常,1位异常
	private int type;
	//员工操作日志操作时间区间：最小的操作时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minOperattime;
	//员工操作日志操作时间区间：最大的操作时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxOperattime;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getOperation_time() {
		return operation_time;
	}
	public void setOperation_time(Date operation_time) {
		this.operation_time = operation_time;
	}
	public String getOperation_desc() {
		return operation_desc;
	}
	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getMinOperattime() { return minOperattime; }
	public void setMinOperattime(Date minOperattime) { this.minOperattime = minOperattime; }
	public Date getMaxOperattime() { return maxOperattime; }
	public void setMaxOperattime(Date maxOperattime) { this.maxOperattime = maxOperattime; }
	public Operation_log() {
		super();
	}


}
