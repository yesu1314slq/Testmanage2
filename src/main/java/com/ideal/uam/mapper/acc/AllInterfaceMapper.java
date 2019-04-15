package com.ideal.uam.mapper.acc;

import java.util.List;

import com.ideal.uam.entity.All_interface;
import com.ideal.uam.util.Page;

public interface AllInterfaceMapper {
	//查询各个接口详情及分页Dao层接口
	List<All_interface> getAllInterface(Page page);

	//查询各个接口详情的总条数Dao层接口
	Integer getCount(Page page);

	//删除各个接口详情中的一个对象Dao层接口
	int deleteALLById(String id);
}
