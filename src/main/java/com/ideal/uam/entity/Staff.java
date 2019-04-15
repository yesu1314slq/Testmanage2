package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * 项目名称：ct10000uam-manage    
 * 类名称：Staff    
 * 类描述：员工表实体    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 上午9:27:18    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 上午9:27:18    
 * 修改备注：       
 * @version
 */
public class Staff implements Serializable{

	private static final long serialVersionUID = 4581077921819128373L;

	//员工主键id
	private int id;
	//员工姓名
	private String name;
	//员工组织id
	private int org_id;
	//员工简拼
	private String spell;
	//员工工号
	private String staff_number;
	//员工密码
	private String pwd;
	//员工状态
	private String state;
	//员工创建时间
	private Date create_Time;
	//员工生效时间
	private Date eff_Time;
	//员工失效时间
	private Date exp_Time;
	//员工联系电话
	private String link_tel;
	//员工联系地址
	private String link_addr;
	//员工创建人
	private int create_staff_id;
	//员工备注
	private String remark;
	//员工所绑定的角色
	private String role_id;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public String getStaff_number() {
		return staff_number;
	}
	public void setStaff_number(String staff_number) {
		this.staff_number = staff_number;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(Date create_Time) {
		this.create_Time = create_Time;
	}
	public Date getEff_Time() { return eff_Time; }
	public void setEff_Time(Date eff_Time) { this.eff_Time = eff_Time; }
	public Date getExp_Time() {
		return exp_Time;
	}
	public void setExp_Time(Date exp_Time) {
		this.exp_Time = exp_Time;
	}
	public String getLink_tel() {
		return link_tel;
	}
	public void setLink_tel(String link_tel) {
		this.link_tel = link_tel;
	}
	public String getLink_addr() {
		return link_addr;
	}
	public void setLink_addr(String link_addr) {
		this.link_addr = link_addr;
	}
	public int getCreate_staff_id() {
		return create_staff_id;
	}
	public void setCreate_staff_id(int create_staff_id) {
		this.create_staff_id = create_staff_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Staff(int id, String name, int org_id, String spell, String staff_number, String pwd, String state,
			Date create_Time, Date edd_Time, Date exp_Time, String link_tel, String link_addr, int create_staff_id,
			String remark) {
		super();
		this.id = id;
		this.name = name;
		this.org_id = org_id;
		this.spell = spell;
		this.staff_number = staff_number;
		this.pwd = pwd;
		this.state = state;
		this.create_Time = create_Time;
		this.eff_Time = eff_Time;
		this.exp_Time = exp_Time;
		this.link_tel = link_tel;
		this.link_addr = link_addr;
		this.create_staff_id = create_staff_id;
		this.remark = remark;
	}
	public Staff() {
		super();
	}



}
