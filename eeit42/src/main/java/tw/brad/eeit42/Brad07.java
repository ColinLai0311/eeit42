package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自己呼叫自己
@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x, y, rs;
		try {
			String sX = request.getParameter("x");
			String sY = request.getParameter("y");
			if (sX != null && sY != null) {
				x = Integer.parseInt(sX);
				y = Integer.parseInt(sY);
				rs = x + y;
			} else {
				x = y = rs = 0;
			}

		} catch (Exception e) {
			x = y = rs = 0;
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<meta charset=\'UTF-8\' />");
		out.print("<form action=\'Brad07\'>");
		out.print("<input name='x' value='"+x+"'> ");
		out.print("+");
		out.print("<input name='y' value='"+y+"'> ");
		out.print(" <input type=\'submit\' value=\'=\'>");
		out.printf("\t<span>%d</span>",rs);
		out.print("</form>");

		response.flushBuffer();
	}

}
