package com.carl.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet3
 */
public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out1 = response.getWriter();
		String storePath = getServletContext().getRealPath("/WEB-INF/files");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(getServletContext().getRealPath("/WEB-INF/temp")));
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if(!isMulti){
			return;
		}
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(4*1024*1024);
		upload.setSizeMax(6*1024*1024);
		upload.setProgressListener(new ProgressListener(){

			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {
				// TODO Auto-generated method stub
				
			}
			
		});
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(item.isFormField()){
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");
					System.out.println(fieldName+"="+fieldValue);
				}else{
					String mimeType = item.getContentType();
					System.out.println(mimeType);
					//if (mimeType.startsWith("image")) {
						InputStream in = item.getInputStream();
						String fileName = item.getName();
						fileName = fileName.substring(fileName
								.lastIndexOf("\\") + 1);
						fileName = UUID.randomUUID() + "_" + fileName;

						String newStorePath = makeStorePath(storePath, fileName);
						String storeFile = newStorePath + "\\" + fileName;
						OutputStream out = new FileOutputStream(storeFile);

						byte b[] = new byte[1024];
						int len = -1;
						while ((len = in.read(b)) != -1) {
							out.write(b, 0, len);
						}
						out.close();
						in.close();
						item.delete();
					}
				//}
			}
		}catch(org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e){
			out1.write("总文件大小不能超过6M");
		}catch(org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e){
			out1.write("单个文件大小不能超过4M");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String makeStorePath(String storePath, String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode&0xf;
		int dir2 = (hashCode&0xf0)>>4;
		String newPath = storePath+"\\"+dir1+"\\"+dir2;
		File file = new File(newPath);
		if(!file.exists()){
			file.mkdirs();
		}
		return newPath;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
