package com.my.demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ")
                .append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String[] hobbys = request.getParameterValues("hobby");
        
        String position = request.getParameter("position");
        
        String memo = request.getParameter("memo");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Information</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("username:"+username+"<br/>");
        out.println("password:"+password+"<br/>");
        for(int i = 0; i<hobbys.length; i++)
        {
            out.println("hobby:"+hobbys[i]+"<br/>");
        }
        out.println("position:"+position+"<br/>");
        out.println("memo"+memo+"<br/>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.flush();
        out.close();
    }

}
