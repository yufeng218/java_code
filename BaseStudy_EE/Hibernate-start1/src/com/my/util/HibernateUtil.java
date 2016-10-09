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
        // ��ȡ�����ļ�
        Configuration cfg = new Configuration().configure();;
        
        //��������ע�����
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        //����session����
        SessionFactory sf = cfg.configure().buildSessionFactory(serviceRegistry);
        
        //��ȡsession
        Session session = sf.openSession();
        return session;
    }
}
