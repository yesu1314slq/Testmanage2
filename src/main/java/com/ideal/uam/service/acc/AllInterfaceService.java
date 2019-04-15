package com.ideal.uam.service.acc;

import com.ideal.uam.util.Page;

public interface AllInterfaceService {
	//查询ACC项目详情中各个接口详情及分页service层接口
	void getAllInterface(Page page);

	//根据ID删除ACC项目详情中各个接口协议的一个对象service层接口
	String deleteALLById(String id);

}
