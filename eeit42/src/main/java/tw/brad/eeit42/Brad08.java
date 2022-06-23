package tw.brad.eeit42;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad08")
public class Brad08 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account= request.getParameter("account");
		String passwd= request.getParameter("passwd");
		String gender= request.getParameter("gender");
		String[] hobby=request.getParameterValues("hobby");
		

		System.out.println(account);
		System.out.println(passwd);
		System.out.println(gender.equals("f")?"female":"male");
		try {
			for(String h :hobby) {
				System.out.println("hobby"+h);
			}

		}catch(Exception e) {
			
		}
		
	}



}
