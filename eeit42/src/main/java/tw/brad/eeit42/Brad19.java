package tw.brad.eeit42;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad19")
public class Brad19 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("image/jpeg");
		
		double rate=0;
		try {
			rate=Double.parseDouble(request.getParameter("rate"));

		}catch(Exception e) {
			
		}
		
		
		BufferedImage bimg=new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d= bimg.createGraphics();
		g2d.setColor(Color.yellow);
		g2d.fillRect(0, 0, 400, 20);
		g2d.setColor(Color.red);
		g2d.fillRect(0, 0, (int)(rate/100*400), 20);
		
		
		
		
		OutputStream out= response.getOutputStream();
		ImageIO.write(bimg, "jpeg", out);
		
		response.flushBuffer();
	
	
	}


	

}
