package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.entity.items;
import org.util.DBHelper;

public class itemsDao
{
	//获取商品的所有信息
	public ArrayList<items> getAllItems()
	{
		ArrayList<items> list = new ArrayList<items>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			con = DBHelper.getConnection();
			String sql = "select * from items";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				items its = new items();
				its.setId(rs.getInt("id"));
				its.setName(rs.getString("name"));
				its.setCity(rs.getString("city"));
				its.setPrice(rs.getInt("price"));
				its.setNumber(rs.getInt("number"));
				its.setPicture(rs.getString("picture"));
				list.add(its);
			}
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(rs != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
					pstmt = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
//			if(con != null)
//			{
//				try
//				{
//					con.close();
//					con = null;
//				}
//				catch (SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
		}
		
	}

	//根据商品编号获取商品信息
	public items getItemsById(int id)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		items its = new items();
		try
		{
			con = DBHelper.getConnection();
			String sql = "select * from items where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				its.setId(rs.getInt("id"));
				its.setName(rs.getString("name"));
				its.setCity(rs.getString("city"));
				its.setPrice(rs.getInt("price"));
				its.setNumber(rs.getInt("number"));
				its.setPicture(rs.getString("picture"));
				return its;
			}
			else
			{
				return null;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(rs != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
					pstmt = null;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
//			if(con != null)
//			{
//				try
//				{
//					con.close();
//					con = null;
//				}
//				catch (SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
		}
	}
}
