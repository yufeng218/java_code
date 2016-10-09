package com.my.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrepareLogin
 */
@WebServlet("/PrepareLogin")
public class PrepareLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Cookie[] cookies = request.getCookies();
	    if(cookies != null && cookies.length > 0)
	    {
	        for(Cookie c : cookies)
	        {
	            if(c.getName().equals("username"))
	            {
	                String value = c.getValue();
	                request.setAttribute("un", value);
	            }
	            if(c.getName().equals("password"))
                {
                    String value = c.getValue();
                    request.setAttribute("pw", value);
                }
	        }
	    }
	    //ÇëÇó×ª·¢
	    request.getRequestDispatcher("/login.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
