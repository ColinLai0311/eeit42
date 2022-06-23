package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher= 
				request.getRequestDispatcher("Brad13");

	//---------------------------------
		response.setContentType("text/html ;charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.print("<h1> big company12</h1>");
		
		dispatcher.forward(request, response);
		response.flushBuffer();
	
	
	}

	

}
