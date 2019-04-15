package com.ideal.uam.service.acc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.All_interface;
import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.mapper.acc.AllInterfaceMapper;
import com.ideal.uam.mapper.log.LogMapper;
import com.ideal.uam.util.Page;
@Service
public class AllInterfaceServiceImpl implements AllInterfaceService{

	@Autowired
	private AllInterfaceMapper allInterfaceMapper;

	//查询ACC项目详情中各个接口详情及分页service层实现
	@Override
	public void getAllInterface(Page page) {
		//获取集合
		List<All_interface> list=allInterfaceMapper.getAllInterface(page);
		//获取总条数
		Integer count=allInterfaceMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID删除ACC项目详情中各个接口协议的一个对象service层实现
	@Override
	public String deleteALLById(String id) {
		int a=allInterfaceMapper.deleteALLById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}

	}
}
