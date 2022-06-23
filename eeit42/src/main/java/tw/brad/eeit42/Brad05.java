package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String x= request.getParameter("x");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.printf("%s 歡迎光臨",x);
		response.flushBuffer();
	}



}
