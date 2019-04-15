package com.ideal.uam.service.log;

import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.util.Page;

import java.util.Date;

public interface LogService {
	//新增员工操作日志service层接口
	void insertLog(Operation_log lg);

	//查询员工操作日志及分页service层接口
	void getlogList(Page page);

	//根据ID查询员工操作日志的一个对象service层接口
	Operation_log queryLogById(String id);

	//根据ID删除员工操作日志的一个对象service层接口
    String deleteLogById(String id);


    void deleteAll();
}
