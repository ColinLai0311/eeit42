package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad04")
public class Brad04 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x= request.getParameter("x");
		String y= request.getParameter("y");
		
//		System.out.println(x);
//		System.out.println(y);
		int ix=Integer.parseInt(x);
		int iy=Integer.parseInt(y);
		int rs=ix+iy;
		//------------------------------
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.printf("%s+%s=%d",x,y,rs);
		response.flushBuffer();
		

		
	}



}
