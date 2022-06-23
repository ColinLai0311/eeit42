package tw.brad.eeit42;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Colin02 {
	private Connection conn;
	public Colin02() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			conn=DriverManager.getConnection("jdbc:mysql://loaclhost/iii",prop);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
