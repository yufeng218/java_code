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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String name = request.getParameter("username");
	    String pass = request.getParameter("password");
	    
	    String auto = request.getParameter("auto"); 
	    // 复选框的值为1 ,则表示自动登录
	    if(auto != null && auto.equals("1"))
	    {
	        //创建Cookie
	        Cookie c1 = new Cookie("username", name);
	        Cookie c2 = new Cookie("password", pass);
	        
	        //设置Cookie的时间为7天
	        c1.setMaxAge(24*60*60*1);
	        c2.setMaxAge(24*60*60*1);
	        
	        //写入Cookie
	        response.addCookie(c1);
	        response.addCookie(c2);
	    }
	    
	    response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
            out.println("<head>");
                out.println("<title>Get Cookie</title>");
            out.println("</head>");
            out.println("<body>");
                out.println("<h3>welcome, "+name+"</h3>");
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
