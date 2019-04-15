package com.ideal.uam.service.acc;

import com.ideal.uam.util.Page;

public interface ProvincialInterfaceAgreementsService {
	//查询ACC项目详情中各省调用协议及分页service层接口
	void getProvincialInterfaceAgreements(Page page);

	//根据ID删除ACC项目详情中各省调用协议的一个对象service层接口
	String deleteAgreementsById(String id);

}
