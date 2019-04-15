package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Staff_2_role    
 * 类描述：用户角色关联表    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 上午9:56:43    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 上午9:56:43    
 * 修改备注：       
 * @version
 */
public class Staff_2_role implements Serializable{

	private static final long serialVersionUID = -9206509794742880329L;
    //用户角色主键id
	private int staff_role_id;
	//角色id
	private int role_id;
	//员工id
	private int staff_id;
	//用户角色生效日期
	private Date start_dt;
	//用户角色失效日期
	private Date end_dt;
	//用户角色版本
	private Date version;


	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public Date getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}

	public Date getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}

	public int getStaff_role_id() {
		return staff_role_id;
	}

	public void setStaff_role_id(int staff_role_id) {
		this.staff_role_id = staff_role_id;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Staff_2_role(int staff_role_id, int role_id, int staff_id, Date start_dt, Date end_dt, Date version) {
		super();
		this.staff_role_id = staff_role_id;
		this.role_id = role_id;
		this.staff_id = staff_id;
		this.start_dt = start_dt;
		this.end_dt = end_dt;
		this.version = version;
	}

	
	
}
