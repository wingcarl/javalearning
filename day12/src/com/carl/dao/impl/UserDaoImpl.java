package com.carl.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;

import com.carl.dao.UserDao;
import com.carl.exception.DaoException;
import com.carl.model.User;
import com.carl.util.Dom4JUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) {
		try {
			Document document = Dom4JUtils.getDocument();
			Element root = document.getRootElement();
			root.addElement("user")
				.addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", user.getBirthday().toLocaleString())
				.addAttribute("nickname", user.getNickname());
			Dom4JUtils.write2Xml(document);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	@Override
	public User findUserByUsername(String username) {
		Document document;
		try {
			document = Dom4JUtils.getDocument(); 
			String xpath = "//user[@username='"+username+"']";
			Node node = document.selectSingleNode(xpath);
			if(node == null)
				return null;
			else{
				User user = new User();
				user.setUsername(node.valueOf("@username"));
				user.setPassword(node.valueOf("@password"));
				user.setEmail(node.valueOf("@email"));
				String sDate = node.valueOf("@birthday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(sDate));
				user.setNickname(node.valueOf("@nickname"));
				return user;
			}
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public User findUser(String username, String password) {
		Document document;
		try {
			document = Dom4JUtils.getDocument(); 
			String xpath = "//user[@username='"+username+"' and @password='"+password+"']";
			Node node = document.selectSingleNode(xpath);
			if(node == null)
				return null;
			else{
				User user = new User();
				user.setUsername(node.valueOf("@username"));
				user.setPassword(node.valueOf("@password"));
				user.setEmail(node.valueOf("@email"));
				String sDate = node.valueOf("@birthday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(sDate));
				user.setNickname(node.valueOf("@nickname"));
				return user;
			}
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
