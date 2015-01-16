package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;

@Service
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService{

	
	/**
	 * 覆盖原来的findAll()方法，使查处的数据按照position变量的大小排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum f ORDER BY f.position").list();
	}

	/**
	 * 覆盖原来的add(Entity T)方法，
	 * 添加的时候默认将该条Forum对象的id作为position值存入数据库
	 */
	@Override
	public void add(Forum forum) {
		getSession().save(forum);
		int position = forum.getId().intValue();
		forum.setPosition(position);
	}

	/**
	 * 将当前板块的位置(position)上移一位
	 */
	@Override
	public void moveUp(Long id) {
		Forum forum = getById(id);
		
		//取出当前版块上面的一个版块
		Forum other = (Forum)getSession().createQuery(//
				"FROM Forum f WHERE f.position < ? ORDER BY position DESC")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
				
		//如果是最顶层的数据，则不能移动
		if(other == null) {
			return;
		}
		
		//交换position位置
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
		//保存到数据库中
		update(forum);
		update(other);
	}

	/**
	 * 将当前版块的位置下移一位(position)
	 */
	@Override
	public void moveDown(Long id) {
		Forum forum = getById(id);
		
		//取出当前版块下面的一个版块
		Forum other = (Forum)getSession().createQuery(//
				"FROM Forum f WHERE f.position > ? ORDER BY position ASC")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
				
		//如果是最底层的数据，则不能移动
		if(other == null) {
			return;
		}
		
		//交换position位置
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
		//保存到数据库中
		update(forum);
		update(other);
	}

}
