package com.ideal.uam.service.account;

import java.util.List;

import com.ideal.uam.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.uam.entity.Staff;
import com.ideal.uam.entity.Unified_account;
import com.ideal.uam.mapper.account.AccountMapper;
import com.ideal.uam.util.Page;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountMapper accountMapper;

	//查询统一账号管理及分页service层实现
	@Override
	public void getAccountList(Page page) {
		//获取集合
		List<Unified_account> list=accountMapper.getAccountList(page);
		//获取总条数
		Integer count=accountMapper.getCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	//根据ID删除统一账号管理的一个对象service层实现
	@Override
	public String deleteAccountById(String id) {
		int a=accountMapper.deleteAccountById(id);
		if(a>0){
			return "ok";
		}else{
			return "else";
		}
	}

	//根据ID查询统一账号管理的一个对象service层实现
	@Override
	public Unified_account getAccountById(String id) {
		return accountMapper.getAccountById(id);
	}

	//修改统一账号管理的一个对象service层实现
	@Override
	public void updateAccount(Unified_account account) {
		accountMapper.updateAccount(account);
	}
}
