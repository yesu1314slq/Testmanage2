package com.ideal.uam.mapper.gate;

import java.util.List;

import com.ideal.uam.entity.Gate_project_details;
import com.ideal.uam.util.Page;

public interface GateMapper {
	//查询Gate项目详情及分页Dao层接口
	List<Gate_project_details> getGateList(Page page);

	//查询Gate项目详情总条数Dao层接口
	Integer getCount(Page page);

	//删除Gate项目详情的一个对象Dao层接口
	int deleteGateById(String id);

}
