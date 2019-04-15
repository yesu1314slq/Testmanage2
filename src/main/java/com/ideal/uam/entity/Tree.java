package com.ideal.uam.entity;

import java.io.Serializable;

public class Tree implements Serializable{
	private static final long serialVersionUID = 778964958381524306L;
	//树的主键id
	private Integer id;
	//树的名称
	private String name;
	//树的子节点
	private Integer pid;
	//树的路径
	private String url;
	//树的权限
	private String permission;
	//菜单类别：1为菜单 0为按钮
	private int type;

	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Tree(Integer id, String name, Integer pid, String url, String permission, int type) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.url = url;
		this.permission = permission;
		this.type = type;
	}

	public Tree() {
		super();
	}
	
	
}
