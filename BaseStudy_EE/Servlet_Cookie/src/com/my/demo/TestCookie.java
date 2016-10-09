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
 * Servlet implementation class TestCookie
 */
@WebServlet("/TestCookie")
public class TestCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCookie() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Cookie[] cookies = request.getCookies();
	    
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
            out.println("<head>");
                out.println("<title>Get Cookie</title>");
            out.println("</head>");
            out.println("<body>");
	    if(cookies != null && cookies.length > 0)
	    {
	        for(Cookie c : cookies)
	        {
	            out.println(c.getName()+":"+c.getValue());
	        }
	    }
	        out.println("</body>");
	    out.println("</html>");
	    out.flush();
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
