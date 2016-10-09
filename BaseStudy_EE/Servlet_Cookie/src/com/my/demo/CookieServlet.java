package com.my.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Cookie c = new Cookie("username", "zhaoliu");//创建Cookie
	    c.setMaxAge(10*24*60*60);       //设置Cookie的有效时间
	    response.addCookie(c); //添加Cookie到客户端
	    
	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
    	    out.println("<head>");
    	        out.println("<title>Set Cookie</title>");
            out.println("</head>");
    	    out.println("<body>");
    	        out.println("<h3>set Cookie OK!</h3>");
    	        out.println("<form action=\"/Servlet_Cookie/servlet/getCookie\" method=\"post\">");
    	        out.println("<input type=\"submit\" value=\"显示Cookie\" />");
    	        out.println("</form>");
    	    out.println("</body>");
	    out.println("</html>");
	    out.flush();
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
