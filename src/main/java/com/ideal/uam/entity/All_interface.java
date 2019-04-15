package com.ideal.uam.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * 项目名称：ct10000uam-manage    
 * 类名称：All_interface    
 * 类描述：各个接口详情表    
 * 创建人：shiliqing 15727396454@163.com    
 * 创建时间：2017年9月14日 上午10:18:15    
 * 修改人：shiliqing 15727396454@163.com     
 * 修改时间：2017年9月14日 上午10:18:15    
 * 修改备注：       
 * @version
 */
public class All_interface implements Serializable{

	private static final long serialVersionUID = -1775142329640133319L;
	//各个接口详情主键
	private String id;
	//各个接口详情接口名称
	private String interface_name;
	//各个接口详情接口效率
	private String interface_efficiency;
	//各个接口详情调用省份
	private String call_province;
	//各个接口详情调用日期
	private Date call_date;
	//各个接口详情操作时间
	private Date operation_time;
	//各个接口详情是否成功:0为正常,1位异常
	private int type;
	//各个接口详情调用时间区间：最小的调用时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minCalltime;
	//各个接口详情调用时间区间：最大的调用时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxCalltime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInterface_name() {
		return interface_name;
	}

	public void setInterface_name(String interface_name) {
		this.interface_name = interface_name;
	}

	public String getInterface_efficiency() {
		return interface_efficiency;
	}

	public void setInterface_efficiency(String interface_efficiency) {
		this.interface_efficiency = interface_efficiency;
	}

	public String getCall_province() {
		return call_province;
	}

	public void setCall_province(String call_province) {
		this.call_province = call_province;
	}

	public Date getCall_date() {
		return call_date;
	}

	public void setCall_date(Date call_date) {
		this.call_date = call_date;
	}
	
	public Date getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(Date operation_time) {
		this.operation_time = operation_time;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getMinCalltime() {
		return minCalltime;
	}

	public void setMinCalltime(Date minCalltime) {
		this.minCalltime = minCalltime;
	}

	public Date getMaxCalltime() {
		return maxCalltime;
	}

	public void setMaxCalltime(Date maxCalltime) {
		this.maxCalltime = maxCalltime;
	}

	public All_interface() {
		super();
	}

}
