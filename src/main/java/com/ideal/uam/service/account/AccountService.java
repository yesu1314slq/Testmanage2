package com.ideal.uam.service.account;

import com.ideal.uam.entity.Role;
import com.ideal.uam.entity.Unified_account;
import com.ideal.uam.util.Page;

public interface AccountService {
	//查询统一账号管理及分页service层接口
	void getAccountList(Page page);

	//根据ID删除统一账号管理的一个对象service层接口
	String deleteAccountById(String id);

	//根据ID查询统一账号管理的一个对象service层接口
	Unified_account getAccountById(String id);

	//修改统一账号管理的一个对象service层接口
	void updateAccount(Unified_account account);

}
