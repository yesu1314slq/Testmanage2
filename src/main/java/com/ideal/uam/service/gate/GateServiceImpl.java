package com.ideal.uam.service.gate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Gate_project_details;
import com.ideal.uam.entity.Uam_project_details;
import com.ideal.uam.mapper.gate.GateMapper;
import com.ideal.uam.mapper.uam.UamMapper;
import com.ideal.uam.util.Page;
@Service
public class GateServiceImpl implements GateService{
	@Autowired
	private GateMapper gateMapper;
	//查询Gate项目详情及分页service层实现
	@Override
	public void getGateList(Page page) {
		//获取集合
		List<Gate_project_details> list=gateMapper.getGateList(page);
		//获取总条数
		Integer count=gateMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}
	//根据ID删除Gate项目详情的一个对象service层实现
	@Override
	public String deleteGateById(String id) {
		int a=gateMapper.deleteGateById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}
	}

}
