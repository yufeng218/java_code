package com.my.bean;

public class MoveDisk implements USB
{

    @Override
    public void read()
    {
        System.out.println("���ƶ�Ӳ�����ж�����");
    }

    @Override
    public void write()
    {
        System.out.println("���ƶ�Ӳ������д����");
    }

}
