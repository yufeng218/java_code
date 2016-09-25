package com.my.spring.jdbc;

import java.awt.List;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class JDBCTest
{
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 不是：queryForObject(sql, Employee.class, 3)方法;
	 * 
	 * 1、其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper；
	 * 2、使用SQL中列的别名完成列名和类的属性名的映射，例如 last_name lastName；
	 * 3、不支持级联属性，JdbcTemplate是一个小工具，不是ORM框架；
	 */
	@Test
	public void testQueryForObj()
	{
		String sql = "select id, last_name lastName, email, dept_id as 'department.id'  from employees where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 3);
		
		System.out.println(employee);
	}
	
	
	/**
	 * 执行insert update delete
	 */
	@Test
	public void testUpdate()
	{
		String sql = "insert into employees (last_name, email, dept_id) values (?,?,?)";
		
		jdbcTemplate.update(sql, "lisi", "li@qq.com", 1);
	}
	
	@Test
	public void test() throws SQLException
	{
		DataSource dataSource = ctx.getBean(DataSource.class);
//		System.out.println(dataSource.getConnection());
	}
}
