package com.my.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionUtil
{
    public static Session getSession()
    {
        Configuration cfg = new Configuration().configure();   // ∂¡»°≈‰÷√Œƒº˛
        
        ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        return session;
    }
    
    public static void close(Session session)
    {
        if(session != null)
        {
            session.close();
        }
    }
}
