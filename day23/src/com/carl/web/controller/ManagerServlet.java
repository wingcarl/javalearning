package com.carl.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.carl.model.Book;
import com.carl.model.Category;
import com.carl.service.CategoryService;
import com.carl.service.impl.CategoryServiceImpl;
import com.carl.util.WebUtil;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private CategoryService cs = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if("addCategory".equals(operation))
			addCategory(request,response);
		if("showAllCategory".equals(operation))
			showAllCategory(request,response);
		if("showAllBookUI".equals(operation))
			showAllBookUI(request,response);
		if("addBook".equals(operation))
			addBook(request,response);
	}

	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resultPath = "";
		String storePath = getServletContext().getRealPath("files");
		try {
			Book book = new Book();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		for(FileItem item:items){
			if(item.isFormField()){
				String fieldName = item.getFieldName();
				String fieldValue = item.getString(request.getCharacterEncoding());
				BeanUtils.setProperty(book, fieldName, fieldValue);
			}else{
				InputStream in = item.getInputStream();
				String fileName = item.getName();
				fileName = UUID.randomUUID()+ fileName.substring(fileName.lastIndexOf("\\")+1);
				//设置存取的图片文件名
				book.setImage(fileName);
				OutputStream out = new FileOutputStream(storePath+"\\"+fileName);
				byte b[] = new byte[1024];
				int len = -1;
				while((len=in.read(b))!=-1){
					out.write(b, 0, len);
				}
				out.close();
				in.close();
				item.delete();//删除临时文件
			}
		}
		cs.addBook(book);
		//查询分类
		List<Category> ls = cs.findAllCategory();
		request.setAttribute("cs", ls);
		resultPath = "/manager/addBook.jsp";
		request.setAttribute("message", "<script type='text/javascript'>alert('添加成功')</script>");
		}catch(Exception e){
			e.printStackTrace();
			resultPath = "/message.jsp";
		}
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

	private void showAllBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> lc = cs.findAllCategory();
		request.setAttribute("cs", lc);
		request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
		
	}

	private void showAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			List<Category> lc = cs.findAllCategory();
			request.setAttribute("cs", lc);
			request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);

		
	}

	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Category c = WebUtil.fillBean(request, Category.class);
		cs.addCategory(c);
		request.getRequestDispatcher("/manager/addCategory.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
