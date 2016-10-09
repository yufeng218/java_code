package com.my.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.bean.CollectionBean;
import com.my.dao.impl.CollDao;
import com.my.dao.impl.CollDaoImpl;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionServlet()
    {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setCharacterEncoding("UTF-8");
	    String action = request.getParameter("action");
	    if(action != null && action.equals("save"))
	    {
	        saveData(request, response);
	    }
	    else if(action != null && action.equals("list"))
	    {
	        listData(request, response);
	    }
	    else
	    {
	        
	    }
	    
	}
	
	public void saveData(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        
        CollDao<CollectionBean> dao = new CollDaoImpl();
        CollectionBean bean = new CollectionBean();
        bean.setName(name);
        bean.setUrl(url);
        
        dao.save(bean); //添加数据到数据库
        listData(request, response);
    }

	public void listData(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
        
        CollDao<CollectionBean> dao = new CollDaoImpl();
        List<CollectionBean> list = dao.list();//查询数据库的数据
        request.setAttribute("DataInfo", list);
        
        //数据插入数据库后跳转到当前页面
        request.getRequestDispatcher("/collection.jsp").forward(request, response);
    }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
