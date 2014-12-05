package com.carl.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通知浏览器不要缓存
				response.setHeader("Expires", "-1");
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				
				int width = 120;
				int height = 25;
				//创建一副内存图像：BufferedImage
				BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
				//得到属于该图片的画笔：Graphics
				Graphics g = image.getGraphics();
					//画边框
				g.setColor(Color.BLUE);
				g.drawRect(0, 0, width, height);
					//填充背景色
				g.setColor(Color.YELLOW);
				g.fillRect(1, 1, width-2, height-2);
					//画干扰线
				g.setColor(Color.GRAY);
				
				Random r = new Random();
				for(int i=0;i<10;i++)
					g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
				
					//随机数字
				g.setColor(Color.RED);
				g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 20));
				int x = 23;
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<4;i++){
					int num = r.nextInt(10);
					sb.append(num);
					g.drawString(num+"", x, 20);
					x+=20;
				}
				String code = sb.toString();
				request.getSession().setAttribute("code", code);
				//输出到浏览器的页面上:ImageIO
				ImageIO.write(image, "jpg", response.getOutputStream());	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
