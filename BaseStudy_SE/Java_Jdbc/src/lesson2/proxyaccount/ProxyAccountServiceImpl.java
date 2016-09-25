package lesson2.proxyaccount;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import lesson2.JdbcUtil;

public class ProxyAccountServiceImpl implements InvocationHandler{

	private Object target;
	
	public ProxyAccountServiceImpl(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		Support support = method.getAnnotation(Support.class);
		if(support != null && support.value().equals("none")){
			System.out.println("没有事务");
			try {
				proxy = method.invoke(target, args);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.closeConnection();
			}
			return proxy;
		}
		return proxyMethod(proxy, method, args);
	}

	private Object proxyMethod(Object proxy, Method method, Object[] args) {
		Connection con = JdbcUtil.getConn();
		try {
			con.setAutoCommit(false);		//开启事务
			proxy = method.invoke(target, args);	//业务调用
			con.commit();	//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();	//事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.closeConnection();
		}
		return proxy;
	}
	
	//产生代理对象
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
