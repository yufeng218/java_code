package com.my.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintExcel
 */
@WebServlet("/PrintExcel")
public class PrintExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintExcel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    //设置输出为excel电子表格 application/vnd.ms-excel
		response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		out.println("Q1\tQ2\tQ3\tQ4\tTotal");
		out.println("Apple\t70\t1\t1\t=SUM(B2:D2)");
		out.println("Orange\t60\t1\t1\t=SUM(B3:D3)");
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
