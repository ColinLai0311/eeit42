package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//RequestDispatcher dispatcher= request.getRequestDispatcher("brad11.html");//分流
		String x= request.getParameter("x");
		String y= request.getParameter("y");

		RequestDispatcher dispatcher= request.getRequestDispatcher("Brad11?z=100&y=200");//這裡也可以帶參數 y同時存在

		
		
		
		response.setContentType("text/html ;charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.print("<h1> big company</h1>");
		out.print(x+":"+y);
		out.print("<hr>");
		dispatcher.include(request, response);
		
		out.print("<hr>");
		out.print("copyleft");
		
		
		
		response.flushBuffer();
	}

	
	

}
