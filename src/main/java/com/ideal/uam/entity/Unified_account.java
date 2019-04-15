package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Unified_account    
 * 类描述：统一账号管理表
 * 创建人：shiliqing 15727396454@163.com    
 * 创建时间：2017年9月13日 下午3:30:15    
 * 修改人：shiliqing 15727396454@163.com     
 * 修改时间：2017年9月13日 下午3:30:15    
 * 修改备注：       
 * @version
 */
public class Unified_account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//统一账号管理主键id
	private String logic_id;
	//统一账号管理统一账号ID
	private String unified_id;
	//统一账号密码
	private String unified_pwd;
	//统一账号新密码
	private String unified_new_pwd;
	//统一账号密码加密方式
	private String encryption_type;
	//统一账号管理统一账号名称
	private String  customer_name;
	//统一账号管理统一账号省份
	private String province;
	//统一账号管理统一账号客户ID
	private String customer_id;
	//统一账号管理创建时间
	private Date create_time;
	//统一账号管理修改时间
	private Date update_time;
	//统一账号管理状态时间
	private Date state_time;
	//统一账号管理统一账号状态：0为正常,1位异常
	private String unified_state;
	//统一账号密码状态
	private String pwd_type;
	//统一账号密码状态时间
	private String pwd_state_time;
	//是否统一密码，0：是，1：否
	private String is_unified_pwd;
	//统一账号管理修改时间区间：
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minUpdatetime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxUpdatetime;

	public String getLogic_id() {
		return logic_id;
	}

	public void setLogic_id(String logic_id) {
		this.logic_id = logic_id;
	}

	public String getUnified_id() {
		return unified_id;
	}

	public void setUnified_id(String unified_id) {
		this.unified_id = unified_id;
	}

	public String getUnified_pwd() {
		return unified_pwd;
	}

	public String getUnified_new_pwd() { return unified_new_pwd; }

	public void setUnified_new_pwd(String unified_new_pwd) { this.unified_new_pwd = unified_new_pwd; }

	public void setUnified_pwd(String unified_pwd) {
		this.unified_pwd = unified_pwd;
	}

	public String getEncryption_type() {
		return encryption_type;
	}

	public void setEncryption_type(String encryption_type) {
		this.encryption_type = encryption_type;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Date getState_time() {
		return state_time;
	}

	public void setState_time(Date state_time) {
		this.state_time = state_time;
	}

	public String getUnified_state() {
		return unified_state;
	}

	public void setUnified_state(String unified_state) {
		this.unified_state = unified_state;
	}

	public String getPwd_type() {
		return pwd_type;
	}

	public void setPwd_type(String pwd_type) {
		this.pwd_type = pwd_type;
	}

	public String getPwd_state_time() {
		return pwd_state_time;
	}

	public void setPwd_state_time(String pwd_state_time) {
		this.pwd_state_time = pwd_state_time;
	}

	public String getIs_unified_pwd() {
		return is_unified_pwd;
	}

	public void setIs_unified_pwd(String is_unified_pwd) {
		this.is_unified_pwd = is_unified_pwd;
	}

	public Date getMinUpdatetime() {
		return minUpdatetime;
	}

	public void setMinUpdatetime(Date minUpdatetime) {
		this.minUpdatetime = minUpdatetime;
	}

	public Date getMaxUpdatetime() {
		return maxUpdatetime;
	}

	public void setMaxUpdatetime(Date maxUpdatetime) {
		this.maxUpdatetime = maxUpdatetime;
	}
}
