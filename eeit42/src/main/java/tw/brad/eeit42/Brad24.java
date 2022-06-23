package tw.brad.eeit42;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.utils.BCrypt;

@WebServlet("/Brad24")
public class Brad24 extends HttpServlet {
	private Connection conn;
	public Brad24() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
		    conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
    	
    	
    	}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "get out here");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		try {
			if (login(account, passwd)) {
				response.sendRedirect("brad25.html");

			} else {
				response.sendRedirect("brad24.html");
			}
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}

	}

	private boolean login(String account, String passwd) throws Exception {
		boolean isRight=false;
		String sql="select*from member where account=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, account);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
			String hashPasswd= rs.getString("passwd");
			if(BCrypt.checkpw(passwd, hashPasswd)) {
				isRight=true;
			}
		}
		return isRight;
	}

}
