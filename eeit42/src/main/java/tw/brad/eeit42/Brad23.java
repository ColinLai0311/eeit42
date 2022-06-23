package tw.brad.eeit42;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/Brad23")

public class Brad23 extends HttpServlet {
	private Connection conn;
	
	
    public Brad23() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account=request.getParameter("account");
		String passwd=request.getParameter("passwd");
		String realname=request.getParameter("realname");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		try {
		if(!isAccountR(account)) {
			//新增帳號
			int row=addMember(account,passwd,realname);
			if(row>0) {
				//新增成功
				out.print("新增成功");
			}else {
				//新增失敗
				out.print("新增失敗");
			}
		
		}else {
			//帳號重複
			out.print("//帳號重複");
		}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		response.flushBuffer();
		
		
	
	}
	
	private boolean isAccountR(String account) throws Exception{
		String sql="Select count(*) as count from member where account=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, account);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int count=rs.getInt("count");
		
		
		return count>0;
	}
	private int addMember(String account,String passwd,String realname) throws Exception {
		String sql="insert into member(account,passwd,realname) values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, realname);
		

		
		return pstmt.executeUpdate();
	}


}
