package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：User_onlineu    
 * 类描述：用户在线情况    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 上午11:13:57    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 上午11:13:57    
 * 修改备注：       
 * @version
 */
public class User_onlineu implements Serializable{

	private static final long serialVersionUID = -200195259422911990L;
	//用户在线主键id
	private int logon_id;
	//用户在线id
	private String staff_id;
	//用户在线ip
	private String ip;
	//用户在线主机名称
	private String machine_name;
	//用户在线时间
	private Date logon_date;
	//用户退出时间
	private Date logout_date;
	//用户在线的状态
	private String online_state;
	//用户在线的串行
	private String online_serial;
	//用户在线的其他信息
	private String other_info;

	public int getLogon_id() {
		return logon_id;
	}

	public void setLogon_id(int logon_id) {
		this.logon_id = logon_id;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMachine_name() {
		return machine_name;
	}

	public void setMachine_name(String machine_name) {
		this.machine_name = machine_name;
	}

	public Date getLogon_date() {
		return logon_date;
	}

	public void setLogon_date(Date logon_date) {
		this.logon_date = logon_date;
	}

	public Date getLogout_date() {
		return logout_date;
	}

	public void setLogout_date(Date logout_date) {
		this.logout_date = logout_date;
	}

	public String getOnline_state() {
		return online_state;
	}

	public void setOnline_state(String online_state) {
		this.online_state = online_state;
	}

	public String getOnline_serial() {
		return online_serial;
	}

	public void setOnline_serial(String online_serial) {
		this.online_serial = online_serial;
	}

	public String getOther_info() {
		return other_info;
	}

	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}

	public User_onlineu(int logon_id, String staff_id, String ip, String machine_name, Date logon_date,
			Date logout_date, String online_state, String online_serial, String other_info) {
		super();
		this.logon_id = logon_id;
		this.staff_id = staff_id;
		this.ip = ip;
		this.machine_name = machine_name;
		this.logon_date = logon_date;
		this.logout_date = logout_date;
		this.online_state = online_state;
		this.online_serial = online_serial;
		this.other_info = other_info;
	}
	
	
}
