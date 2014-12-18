package com.carl.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllFilesServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String,String> map = new HashMap<String,String>();
		String storePath = getServletContext().getRealPath("WEB-INF/files");
		File file = new File(storePath);
		treeWalk(file,map);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/listFiles.jsp").forward(req, resp);
	}
	private void treeWalk(File file, Map<String, String> map) {
		if(file.isFile()){
			String uuidName = file.getName();
			String oldName = uuidName.substring(uuidName.indexOf("_")+1);
			map.put(uuidName,oldName);
		}else{
			File[] fs = file.listFiles();
			for(File f:fs){
				treeWalk(f,map);
			}
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
}
