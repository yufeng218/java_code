package com.my.bean;

public class UDisk implements USB
{

    @Override
    public void read()
    {
        System.out.println("��U���ж�����");
    }

    @Override
    public void write()
    {
        System.out.println("��U����д����");
    }

}
