package com.ideal.uam.service.gate;

import com.ideal.uam.util.Page;

public interface GateService {
	//查询Gate项目详情及分页service层接口
	void getGateList(Page page);

	//根据ID删除Gate项目详情的一个对象service层接口
	String deleteGateById(String id);

}
