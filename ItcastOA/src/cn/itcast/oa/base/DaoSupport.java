package cn.itcast.oa.base;

import java.util.List;

public interface DaoSupport<T> {

	/**
	 * 增加实体
	 * @param entity
	 */
	void add(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 根据ID查询对应的实体
	 * @param id
	 * @return 
	 */
	T getById(Long id);
	
	/**
	 * 根据ID查询多个实体
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有实体
	 * @return
	 */
	List<T> findAll();
}
