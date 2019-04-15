package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Role_2_auth    
 * 类描述： 角色权限关联表   
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 上午10:11:01    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 上午10:11:01    
 * 修改备注：       
 * @version
 */
public class Role_2_auth implements Serializable{

	private static final long serialVersionUID = -2295625251365913200L;
	//角色权限关联主键id
	private int role_auth_id;
	//角色主键id
	private int role_id;
	//权限主键id
	private int auth_id;
	//角色权限创建时间
	private Date create_dt;
	//角色权限开始时间
	private Date start_dt;
	//角色权限结束时间
	private Date end_dt;

	public int getRole_auth_id() {
		return role_auth_id;
	}

	public void setRole_auth_id(int role_auth_id) {
		this.role_auth_id = role_auth_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}

	public Date getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
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

	public Role_2_auth(int role_auth_id, int role_id, int auth_id, Date create_dt, Date start_dt, Date end_dt) {
		super();
		this.role_auth_id = role_auth_id;
		this.role_id = role_id;
		this.auth_id = auth_id;
		this.create_dt = create_dt;
		this.start_dt = start_dt;
		this.end_dt = end_dt;
	}
	
	

}
