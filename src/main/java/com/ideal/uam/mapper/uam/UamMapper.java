package com.ideal.uam.mapper.uam;

import java.util.List;

import com.ideal.uam.entity.Uam_project_details;
import com.ideal.uam.util.Page;

public interface UamMapper {
	//查询Uam项目详情及分页Dao层接口
	List<Uam_project_details> getUamList(Page page);

	//查询Uam项目详情总条数Dao层接口
	Integer getCount(Page page);

	//删除Uam项目详情的一个对象Dao层接口
	int deleteUamById(String id);

}
