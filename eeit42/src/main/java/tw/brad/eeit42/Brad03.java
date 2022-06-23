package tw.brad.eeit42;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> maps = request.getParameterMap();
//		System.out.println(maps.size());
		Set<String> keys = maps.keySet();
		for (String key : keys) {
			System.out.print(key + ":");
			String[] vs = request.getParameterValues(key);
			for (String value : vs) {
				System.out.println(value + " ");
			}
			System.out.println();
		}
	}

}
