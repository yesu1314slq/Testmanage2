package com.ideal.uam.service.uam;

import com.ideal.uam.util.Page;

public interface UamService {
	//查询Uam项目详情及分页service层接口
	void getUamList(Page page);

	//根据ID删除Uam项目详情的一个对象service层接口
	String deleteUamById(String id);
}
