package com.my.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderServlet
 */
@WebServlet("/RequestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHeaderServlet()
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
//        response.getWriter().append("Served at: ")
//                .append(request.getContextPath());
        
        String browser = request.getHeader("user-agent");
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        if(browser != null && browser.indexOf("MSIR") != -1)
        {
            out.println("您使用的是IE浏览器");
        }
        else
        {
            out.println("您使用的不是IE浏览器");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        Enumeration<String> enu = request.getHeaderNames();
        
        response.setCharacterEncoding("UTF-8");
        //防止编码的问题
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Information</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<table border='1' style='border-collapse: collapse;'>");
            out.println("<tr>");

                out.println("<th>");
                    out.println("HeaderNames");
                out.println("</th>");
                
                out.println("<th>");
                    out.println("HeaderValues");
                out.println("</th>");
            out.println("</tr>");
            while(enu.hasMoreElements())
            {
                String name = enu.nextElement();
                String value = request.getHeader(name);
                out.println("<tr>");
                    out.println("<td>");
                        out.println(name);
                    out.println("</td>");
                    out.println("<td>");
                        out.println(value);
                    out.println("</td>");
                out.println("</tr>");
            }
        out.println("</table>");
        
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
//        doGet(request, response);
    }

}
