package com.ideal.uam.mapper.account;

import java.util.List;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Unified_account;
import com.ideal.uam.util.Page;

public interface AccountMapper {
	//查询统一账号管理及分页Dao层接口
	List<Unified_account> getAccountList(Page page);

	//查询统一账号管理的总条数Dao层接口
	Integer getCount(Page page);

	//删除统一账号管理的一个对象Dao层接口
	int deleteAccountById(String id);

	//根据统一账号管理ID查询统一账号管理的一个对象的Dao层接口
	 Unified_account getAccountById(String id);

	 //修改统一账号管理的一个对象Dao层接口
	void updateAccount(Unified_account account);

}
