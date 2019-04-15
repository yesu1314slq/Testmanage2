package com.ideal.uam.service.log;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.mapper.log.LogMapper;
import com.ideal.uam.util.Page;
@Service
public class LogServiceImpl implements LogService{
	@Autowired
	private LogMapper logMapper;

	//新增员工操作日志service层实现
	@Override
	public void insertLog(Operation_log lg) {
		logMapper.insertLog(lg);
	}

	//查询员工操作日志及分页service层实现
	@Override
	public void getlogList(Page page) {
		//获取集合
		List<Operation_log> list=logMapper.getlogList(page);
		//获取总条数
		Integer count=logMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID查询员工操作日志的一个对象service层实现
	@Override
	public Operation_log queryLogById(String id) {
		return  logMapper.queryLogById(id);

	}

	//根据ID删除员工操作日志的一个对象service层实现
	@Override
	public String deleteLogById(String id) {
		int a=logMapper.deleteLogById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}

	}

	@Override
	public void deleteAll() {
		logMapper.deleteAll();
	}


}
