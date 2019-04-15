package com.ideal.uam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Role    
 * 类描述：角色表    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 上午10:04:23    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 上午10:04:23    
 * 修改备注：       
 * @version
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 8801247452153685571L;
	//角色主键id
	private int role_id;
	//角色名称
	private String name;
	//角色描述
	private String description;
	//角色创建日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_dt;
	//角色生效日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_dt;
	//角色结束日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_dt;
	//角色版本
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date version;
	//用户是否拥有角色的标识
	private boolean ben=false;


	public boolean isBen() { return ben; }

	public void setBen(boolean ben) { this.ben = ben; }

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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


	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}
    public Role() {
    	super();
    }

	public Role(int role_id, String name, String description, Date create_dt, Date start_dt, Date end_dt,
			Date version) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.description = description;
		this.create_dt = create_dt;
		this.start_dt = start_dt;
		this.end_dt = end_dt;
		this.version = version;
	}
	
	
}
