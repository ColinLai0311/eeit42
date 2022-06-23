package tw.brad.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BradUtils {
	public static String loadView(String view) {
		String loadfile = String.format("C:\\Users\\Master\\eclipse-workspace\\eeit42\\src\\main\\views\\view1.html",
				view);
		File source = new File(loadfile);
		StringBuffer sb = new StringBuffer();
		try (FileInputStream fin = new FileInputStream(source);
				InputStreamReader ir = new InputStreamReader(fin, "UTF-8");
				BufferedReader reader = new BufferedReader(ir)) {

			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

		} catch (Exception e) {

		}
		return sb.toString();
	}

	public static int createLottery() {
		return (int) (Math.random() * 49 + 1);
	}
	public static final String Math_Add="1";
	public static final String Math_Sub="2";
	public static final String Math_Mul="3";
	public static final String Math_Div="4";


	public static String cal(String x, String y,String op) {
		try {
			int intx = Integer.parseInt(x);
			int inty = Integer.parseInt(y);
			switch(op) {
			case Math_Add:return "" + (intx + inty);
			case Math_Sub:return "" + (intx - inty);
			case Math_Mul:return "" + (intx * inty);
			case Math_Div:return "" + (intx / inty)+"..."+(intx % inty);
			default:return "";
			}
			
		} catch (Exception e) {
			return "";
		}

	}
	
	public static int createScore() {
		return (int)(Math.random()*101);
	}
	public static String encPasswd(String plain) {
	return	BCrypt.hashpw(plain, BCrypt.gensalt());
	}
//	public static boolean iskeyword(String name,String name1) {
//		
//	}
}
