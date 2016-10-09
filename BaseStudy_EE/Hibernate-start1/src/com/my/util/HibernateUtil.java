package com.my.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil
{
    public Session getSession()
    {   
        // 读取配置文件
        Configuration cfg = new Configuration().configure();;
        
        //创建服务注册对象
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        //创建session工厂
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        
        //获取session
        Session session = sf.openSession();
        return session;
    }
}
