package com.my.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.SynchronousQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.collection.MyList;
import com.my.collection.MyMap;
import com.my.collection.MyProperties;

public class TestMyList
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
      
        //=============  Map  =============
//        MyList my = (MyList) ctx.getBean("listBean");
//        List list = my.getList(); 
//        Iterator itor = list.iterator();
//        while(itor.hasNext())
//        {
//            System.out.println(itor.next());
//        }
        
        //=============  Map  =============
        MyMap my1 = (MyMap) ctx.getBean("map1");
        Map map = my1.getSomMap();
        Iterator itor1 = map.keySet().iterator();
        while(itor1.hasNext())
        {
            String key = (String) itor1.next();
            System.out.println( key+ ":" + map.get(key));
        }
        
        //=============  Properties  =============
        MyProperties p1 = (MyProperties) ctx.getBean("prop1");
        Properties prop = p1.getProp();
        System.out.println(prop.getProperty("admin"));
        System.out.println(prop.getProperty("lisi"));
        
    }
}
