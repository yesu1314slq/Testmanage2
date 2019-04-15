package com.ideal.uam.mapper.log;

import java.util.Date;
import java.util.List;

import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.util.Page;

public interface LogMapper {
	//新增员工操作日志Dao层接口
	void insertLog(Operation_log lg);

	//查询员工操作日志及分页Dao层接口
	List<Operation_log> getlogList(Page page);

	//查询员工操作日志总条数Dao层接口
	Integer getCount(Page page);

	//查询员工操作日志的一个对象Dao层接口
	Operation_log queryLogById(String id);

	//删除员工操作日志的一个对象Dao层接口
    int deleteLogById(String id);

	//修改员工操作日志的一个对象Dao层接口
	void updateLogById(Page page);

	void deleteAll();
}
