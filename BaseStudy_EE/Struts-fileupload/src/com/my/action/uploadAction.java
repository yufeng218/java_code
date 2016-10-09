package com.my.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class uploadAction extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {   
        String path = this.getSavePath();   //保存的路径
        for(int i = 0; i < upload.length; i++)
        {        
            String fileName = this.getUploadFileName()[i]; //上传的文件名
            System.out.println("upload:"+this.getUpload());
            System.out.println("uploadContentType:"+uploadContentType);
            System.out.println("path:"+path);
            System.out.println("fileName:"+fileName);
            FileInputStream in = new FileInputStream(this.getUpload()[i]);
            FileOutputStream out = new FileOutputStream(path+"\\"+fileName);
            byte[] b = new byte[in.available()];
            
            in.read(b);
            out.write(b);
            
            in.close();
            out.close();
        }
        return SUCCESS;
    }
    
    private File[] upload;  //上传的文件域中的路径
    private String[] uploadContentType; //上传文件的内容
    private String[] uploadFileName;    //上传的文件名称
    
    private String savePath;   //文件保存的路径

    public String getSavePath()
    {
        savePath = ServletActionContext.getServletContext().getRealPath("//upload");
        return savePath;
    }

    public void setSavePath(String savePath)
    {
        this.savePath = savePath;
    }

    public File[] getUpload()
    {
        return upload;
    }

    public void setUpload(File[] upload)
    {
        this.upload = upload;
    }

    public String[] getUploadContentType()
    {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType)
    {
        this.uploadContentType = uploadContentType;
    }

    public String[] getUploadFileName()
    {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName)
    {
        this.uploadFileName = uploadFileName;
    }

    
}
