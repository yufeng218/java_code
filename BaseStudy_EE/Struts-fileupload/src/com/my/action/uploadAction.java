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
        String path = this.getSavePath();   //�����·��
        for(int i = 0; i < upload.length; i++)
        {        
            String fileName = this.getUploadFileName()[i]; //�ϴ����ļ���
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
    
    private File[] upload;  //�ϴ����ļ����е�·��
    private String[] uploadContentType; //�ϴ��ļ�������
    private String[] uploadFileName;    //�ϴ����ļ�����
    
    private String savePath;   //�ļ������·��

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
