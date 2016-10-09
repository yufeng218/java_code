package com.my.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

public class DynamicLogProxy implements InvocationHandler
{
    Object delegate;
    Logger logger = Logger.getLogger(this.getClass().getName());
    
    /**
     * 绑定代理对象和被代理对象
     * @param delegate
     * @return
     */
    public Object bind(Object delegate)
    {
        this.delegate = delegate;
        
        Class cls = delegate.getClass();
        Object obj = Proxy.newProxyInstance(
                cls.getClassLoader(), cls.getInterfaces(), this);
        System.out.println(obj);
        return obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] arg2)
            throws Throwable
    {
        logger.log(Level.INFO, "before delete");
        
        proxy = method.invoke(delegate, arg2);
        System.out.println(proxy);
        logger.log(Level.INFO, "after delete");
        
        return proxy;
    }

}
