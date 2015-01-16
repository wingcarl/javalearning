package cn.itcast.oa.service;

import org.springframework.stereotype.Service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;


public interface ForumService extends DaoSupport<Forum> {

	void moveUp(Long id);

	void moveDown(Long id);

}
