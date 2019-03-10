package com.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/text")//不是用name
public class text extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	   System.out.println("OK");
	   request.getRequestDispatcher("success.jsp").forward(request, response);
   }
}
