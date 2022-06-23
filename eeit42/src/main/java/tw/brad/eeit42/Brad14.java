package tw.brad.eeit42;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.utils.Brad15;


@WebServlet("/Brad14")
public class Brad14 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		// controller
		//1.接收參數，整理
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		String op=request.getParameter("op");
		if(x==null)x="";
		if(y==null)y="";
		if(op==null)op="";
		
	
		//2.model=>演算法
		Brad15 model =new Brad15(x,y) ;
		double result=model.operator(op);
		System.out.println(result);
					
		//3.呈現=>view
		
		request.getRequestDispatcher(String.format("Brad16?result=%f&view=%s", result,"view2"))
		.forward(request, response);
	
	
	
	}

	

}
