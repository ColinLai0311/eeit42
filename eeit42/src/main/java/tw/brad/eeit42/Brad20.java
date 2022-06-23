package tw.brad.eeit42;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad20")
public class Brad20 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String source = "C:\\Users\\Master\\eclipse-workspace\\eeit42\\src\\main\\webapp\\upload\\ramen.jpg";
		File file = new File(source);
		BufferedImage bimg = ImageIO.read(file);

		Font font=new Font(null,Font.BOLD,64);
		AffineTransform tran=new AffineTransform();
		tran.rotate(Math.toRadians(-30));//角度變形
		Font font2= font.deriveFont(tran);
		
		Graphics2D g2d = bimg.createGraphics();
		g2d.setColor(Color.cyan);
//		g2d.setFont(new Font(null, Font.BOLD, 50));
		g2d.setFont(font2);

		g2d.drawString("狸醬拉麵", 100, 100);//畫字
		g2d.drawString("狸醬拉麵", 100, 200);//畫字

		//輸出瀏覽器
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", out);
//		response.flushBuffer();
		
		
		//另存新檔
		String target="C:\\Users\\Master\\eclipse-workspace\\eeit42\\src\\main\\webapp\\upload\\ramen2.jpg";;
		FileOutputStream fout=new FileOutputStream(target);
		ImageIO.write(bimg, "jpeg", fout);
		out.flush();
		out.close();
		response.flushBuffer();

	}

}
