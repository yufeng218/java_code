package com.my.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogProxy implements UserDao
{
    private UserDao dao;
    
    Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Override
    public void delete(String name)
    {
        logger.log(Level.INFO, "before delete");
        dao.delete(name);
        logger.log(Level.INFO, "after delete");
    }

    public LogProxy(UserDao dao)
    {
        super();
        this.dao = dao;
    }
    
}
