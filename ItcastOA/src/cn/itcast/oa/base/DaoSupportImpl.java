package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;
	/**
	 * 获取session
	 * @return
	 */
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

	@SuppressWarnings("unchecked")
	public DaoSupportImpl(){
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	@Override
	public void add(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		if (id != null) {
			Object entity = getById(id);
			if (entity != null) {
				getSession().delete(entity);
			}
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length==0) {
			return Collections.EMPTY_LIST;
		}else{
		return getSession().createQuery("From "+clazz.getSimpleName()+" where id in (:ids)")//
				.setParameterList("ids", ids).list();
		}
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery("From "+clazz.getSimpleName()).list();
	}

}
