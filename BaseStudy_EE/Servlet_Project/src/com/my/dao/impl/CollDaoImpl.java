package com.my.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.bean.CollectionBean;
import com.my.util.DBUtil;

public class CollDaoImpl implements CollDao
{
    private List<CollectionBean> list = new ArrayList<CollectionBean>();
    @Override
    public void save(CollectionBean bean)
    {
        String sql = "insert into CollectionTB (name,url) values (?,?)";
        Connection con = DBUtil.getConn();
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getUrl());
            
            pstmt.executeUpdate();
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.close(con);;
        }
    }

    @Override
    public void update(CollectionBean bean)
    {
        String sql = "update CollectionTB set name=?,url=? where id=?";
        Connection con = DBUtil.getConn();
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getUrl());
            pstmt.setInt(3, bean.getId());
            
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.close(con);;
        }
    }

    @Override
    public void delete(String[] s)
    {
        String sql = "delete from CollectionTB where id=?";
        Connection con = DBUtil.getConn();
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(sql);
            if(s != null && s.length > 0)
            {
                for(String str : s)
                {
                    int num = Integer.parseInt(str);
                    pstmt.setInt(1, num);
                    pstmt.executeUpdate();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.close(con);;
        }
    }

    @Override
    public List<CollectionBean> list()
    {
        String sql = "select id,name,url from CollectionTB";
        Connection con = DBUtil.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try
        {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                CollectionBean bean = new CollectionBean();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setUrl(rs.getString("url"));
                list.add(bean);
            }
            return list;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.close(con);
        }
        return null;
    }

}
