package com.ideal.uam.service.uam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Uam_project_details;
import com.ideal.uam.mapper.uam.UamMapper;
import com.ideal.uam.util.Page;
@Service
public class UamServiceImpl implements UamService{
	@Autowired
	private UamMapper uamMapper;

	//查询Uam项目详情及分页service层实现
	@Override
	public void getUamList(Page page) {
		//获取集合
		List<Uam_project_details> list=uamMapper.getUamList(page);
		//获取总条数
		Integer count=uamMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID删除Uam项目详情的一个对象service层实现
	@Override
	public String deleteUamById(String id) {
		int a=uamMapper.deleteUamById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}
	}
}
