package com.carl.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes("ISO-8859-1"),"UTF-8");
		String oldFileName = filename.split("_")[1];
		String storePath = getServletContext().getRealPath("/WEB-INF/files");
		String filePath = makeStorePath(storePath,filename)+"\\"+filename;
	
		File file = new File(filePath);
		if(!file.exists()){
			out.write("您下载的文件已经不存在".getBytes("UTF-8"));
			return;
		}
		InputStream in = new FileInputStream(file);
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(oldFileName,"UTF-8"));
		byte[] b = new byte[1024];
		int len=-1;
		while((len=in.read(b))!=-1){
			out.write(b,0,len);
		}
		in.close();
		out.write("下载成功".getBytes("UTF-8"));
	}

	private String makeStorePath(String storePath, String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode & 0xf;// 0000~1111：整数0~15共16个
		int dir2 = (hashCode & 0xf0) >> 4;// 0000~1111：整数0~15共16个

		String path = storePath + "\\" + dir1 + "\\" + dir2; // WEB-INF/files/1/12
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();

		return path;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
