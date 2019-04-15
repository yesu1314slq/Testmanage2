package com.ideal.uam.entity;

import java.io.Serializable;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：Organization    
 * 类描述：组织机构    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年9月11日 上午10:54:08    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年9月11日 上午10:54:08    
 * 修改备注：       
 * @version
 */
public class Organization implements Serializable{

	private static final long serialVersionUID = 6612915487946942268L;
	//组织机构主键
	private int org_id;
	//组织机构名称
	private String name;
	//组织机构组织类型编码
	private int org_type_cd;
	//组织机构上级组织id
	private int parent_org_id;
	//组织机构码
	private String code;
	//组织机构组织简拼
	private String spell;
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrg_type_cd() {
		return org_type_cd;
	}
	public void setOrg_type_cd(int org_type_cd) {
		this.org_type_cd = org_type_cd;
	}
	public int getParent_org_id() {
		return parent_org_id;
	}
	public void setParent_org_id(int parent_org_id) {
		this.parent_org_id = parent_org_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public Organization(int org_id, String name, int org_type_cd, int parent_org_id, String code, String spell) {
		super();
		this.org_id = org_id;
		this.name = name;
		this.org_type_cd = org_type_cd;
		this.parent_org_id = parent_org_id;
		this.code = code;
		this.spell = spell;
	}
	
	
}
