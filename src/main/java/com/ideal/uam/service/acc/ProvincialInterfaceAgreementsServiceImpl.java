package com.ideal.uam.service.acc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.All_interface;
import com.ideal.uam.entity.Operation_log;
import com.ideal.uam.entity.Provincial_interface_agreements;
import com.ideal.uam.entity.Staff;
import com.ideal.uam.mapper.acc.AllInterfaceMapper;
import com.ideal.uam.mapper.acc.ProvincialInterfaceAgreementsMapper;
import com.ideal.uam.mapper.log.LogMapper;
import com.ideal.uam.util.Page;
@Service
public class ProvincialInterfaceAgreementsServiceImpl implements ProvincialInterfaceAgreementsService{
	@Autowired
	private ProvincialInterfaceAgreementsMapper provincialInterfaceAgreementsMapper;

	//查询ACC项目详情中各省调用协议及分页service层实现
	@Override
	public void getProvincialInterfaceAgreements(Page page) {
		//获取集合
		List<Provincial_interface_agreements> list=provincialInterfaceAgreementsMapper.getProvincialInterfaceAgreements(page);
		//获取总条数
		Integer count=provincialInterfaceAgreementsMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID删除ACC项目详情中各省调用协议的一个对象service层实现
	@Override
	public String deleteAgreementsById(String id) {
		int a=provincialInterfaceAgreementsMapper.deleteAgreementsById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}

	}
}
