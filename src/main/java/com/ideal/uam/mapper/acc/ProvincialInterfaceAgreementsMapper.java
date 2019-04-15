package com.ideal.uam.mapper.acc;

import java.util.List;

import com.ideal.uam.entity.Provincial_interface_agreements;
import com.ideal.uam.util.Page;

public interface ProvincialInterfaceAgreementsMapper {
	//查询各省调用协议及分页Dao层接口
	List<Provincial_interface_agreements> getProvincialInterfaceAgreements(Page page);

	//查询各省调用协议的总条数Dao层接口
	Integer getCount(Page page);

	//删除各省调用协议的一个对象Dao层接口
	int deleteAgreementsById(String id);
}
