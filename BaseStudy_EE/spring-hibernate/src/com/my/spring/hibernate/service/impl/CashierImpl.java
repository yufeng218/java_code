package com.my.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.hibernate.service.BookShopService;
import com.my.spring.hibernate.service.Cashier;

@Service
public class CashierImpl implements Cashier
{
	@Autowired
	private BookShopService bookShopService;
	
	/**
	 * Spring hibernate 事务的流程
	 * 1、在方法开始之前
	 * 	① 获取Session
	 *  ② 把Session和当前线程绑定，这样就可以在Dao中使用SessionFactory的
	 *    getCurrentSession()方法来获取session了
	 *  ③ 开启事务
	 *  
	 * 2、若方法正常结束(即没有出现异常)，则
	 * 	① 提交事务
	 *  ② 使和当前线程绑定的session接触绑定
	 *  ③ 关闭session
	 *  
	 * 3、若方法运行异常，则
	 *  ① 回滚事务
	 *  ② 使和当前线程绑定的session接触绑定
	 *  ③ 关闭session
	 */
	@Override
	public void checkout(String username, List<String> isbns)
	{
		for(String isbn : isbns)
		{
			bookShopService.purchase(username, isbn);
		}
	}

}
