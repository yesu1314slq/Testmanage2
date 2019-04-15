package com.ideal.uam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 项目名称：ct10000uam-manage
 * 类名称：Data_report
 * 类描述：数据报表表
 * 创建人：shiliqing 15727396454@163.com
 * 创建时间：2017年9月27日 上午10:18:15
 * 修改人：shiliqing 15727396454@163.com
 * 修改时间：2017年9月27日 上午10:18:15
 * 修改备注：
 * @version
 */
public class Data_report implements Serializable {

    private static final long serialVersionUID = -1775142329640133319L;

    //数据报表主键ID
    private int id;
    //数据报表名称
    private String name;
    //数据报表数量
    private int count;
    //数据报表操作时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date operation_time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getOperation_time() { return operation_time; }

    public void setOperation_time(Date operation_time) { this.operation_time = operation_time; }
}
