package com.my.bean;

public class MoveDisk implements USB
{

    @Override
    public void read()
    {
        System.out.println("从移动硬盘盘中读数据");
    }

    @Override
    public void write()
    {
        System.out.println("向移动硬盘盘中写数据");
    }

}
