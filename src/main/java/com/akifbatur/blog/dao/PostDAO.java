package com.akifbatur.blog.dao;

import java.util.List;

import com.akifbatur.blog.model.Post;

/**
 * 
 * @author Akif Batur
 *
 */
public interface PostDAO 
{
	public void savePost(Post post);
	
	public List<Post> fetchAllPost();

	public List<Post> getPostByTitle(String postTitle);

	public List<Post> getPostByUserName(String userName);
}
