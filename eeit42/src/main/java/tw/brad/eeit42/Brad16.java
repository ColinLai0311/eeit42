package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.utils.BradUtils;


@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("result");
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		String op=request.getParameter("op");
		String view=request.getParameter("view");

		
		if(op==null)op="";
		String op1= op.equals("1")?"selected":"";
		String op2= op.equals("2")?"selected":"";
		String op3= op.equals("3")?"selected":"";
		String op4= op.equals("4")?"selected":"";

		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String html= BradUtils.loadView(view);
		out.print(String.format(html,x,op1,op2,op3,op4,y, r));
		response.flushBuffer();
	
	}

	
}
