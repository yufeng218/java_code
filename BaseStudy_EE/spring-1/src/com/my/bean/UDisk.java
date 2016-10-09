package com.my.bean;

public class UDisk implements USB
{

    @Override
    public void read()
    {
        System.out.println("从U盘中读数据");
    }

    @Override
    public void write()
    {
        System.out.println("向U盘中写数据");
    }

}
