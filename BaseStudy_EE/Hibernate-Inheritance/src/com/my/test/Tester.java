package com.my.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.bean.Customer;
import com.my.bean.Order;
import com.my.util.HibernateUtil;

public class Tester
{
    public static void main(String[] args)
    {
//        Customer c = new Customer();
//        c.setName("wangwu");
//        c.setEmail("wangwu@163.com");
        
        //保存客户的订单
//        Order o = new Order();
//        o.setName("clothes");
//        o.setOrderNumber("c-001");
//        Customer cus = (Customer)get(Customer.class, 1);
//        o.setCustomer(cus);
//        
//        save(o);
        
        //对象之间的导航
//        Order ord = (Order)get(Order.class, 1);
//        Customer cus = ord.getCustomer();
//        System.out.println("name:"+cus.getName());
        
        //
        Customer c = (Customer) get(Customer.class, 1);
        Set<Order> set = c.getOrders();
        
        Iterator itor = set.iterator();
        while(itor.hasNext())
        {
            Order o = (Order) itor.next();
            System.out.println(o.getOrderNumber());
        }
        
    }
    
    public static void save(Object c)
    {
        Session session = HibernateUtil.getSession();
        Transaction trans = session.beginTransaction();//开启事务
        try
        {
            session.save(c);
            trans.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            trans.rollback();
        }
        finally
        {
            session.close();
        }
    }
    
    public static Object get(Class cls,Integer id)
    {
        Session session = HibernateUtil.getSession();
        try
        {
            return session.get(cls, id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return null;
    }
    
}
