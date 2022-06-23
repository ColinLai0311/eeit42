package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Colin01")
public class Colin01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x, y, rs=0 ;
		int rs1=0 ;
		String area = null;
		try {
			String sX = request.getParameter("x");
			String sY = request.getParameter("y");
			 area = request.getParameter("area");
			System.out.println(area);
			if (sX != null && sY != null) {
				x = Integer.parseInt(sX);
				y = Integer.parseInt(sY);

				switch (area) {
				case "+":
					rs = x + y;
					break;
				case "-":
					rs = x - y;
					break;
				case "*":
					rs = x * y;
					break;
				case "/":
					rs = x / y;
					rs1 = x % y;
					break;

				}
			} else {
				x = y = rs = 0;
			}
			
		}catch(Exception e) {
			x = y = rs = 0;
		}
		

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<meta charset=\'UTF-8\' />");
		out.print("<form action=\'Colin01\'>");
		out.print("<input name='x' value='" + x + "'> ");
		out.print("<select name=\"area\">");
		out.print("<option value=\'+\'>+</option>");
		out.print("<option value=\'-\'>-</option>");
		out.print("<option value=\'*\'>x</option>");
		out.print("<option value=\'/\'>/</option>");
		out.print("</select>");

		out.print("<input name='y' value='" + y + "'> ");
		out.print(" <input type=\'submit\' value=\'=\'>");
		if (area == "/") {
			out.printf("\t<span>%d......%d</span>", rs, rs1);
		} else {
		
			out.printf("\t<span>%d</span>", rs);
		}

		out.print("</form>");

		response.flushBuffer();

	}

}
