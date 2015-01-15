package cn.itcast.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

	@Override
	public void add(User user) {
		// 默认密码是1234
		String md5 = DigestUtils.md5Hex("1234"); // 密码要使用MD5摘要
		user.setPassword(md5);

		// 保存到数据库
		getSession().save(user);
	}

	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		String md5 = DigestUtils.md5Hex(password);
		User user = findByLoginName(loginName);
		if(user.getPassword().equals(md5)){
			return user;
		}else{
			return null;
		}
	}
	
	private User findByLoginName(String loginName){
		return (User) getSession().createQuery("FROM User where loginName=?").setParameter(0, loginName).uniqueResult();
	}
}
