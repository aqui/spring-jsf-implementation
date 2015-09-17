package com.akifbatur.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akifbatur.blog.model.Post;

/**
 * 
 * @author Akif Batur
 *
 */
@Repository("postDAO")
public class PostDAOImpl implements PostDAO 
{
	private static final Logger logger = LoggerFactory.getLogger(PostDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePost(Post post) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(post);
		logger.info("Posted");
	}
}
