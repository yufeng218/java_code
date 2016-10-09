package com.my.bean;

public class Computer
{
    private USB usb;

    public USB getUsb()
    {
        return usb;
    }

    public void setUsb(USB usb)
    {
        this.usb = usb;
    }
    
    public void test()
    {
        usb.read();
        usb.write();
    }
}
