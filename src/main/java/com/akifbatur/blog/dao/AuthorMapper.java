package com.akifbatur.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.akifbatur.blog.model.Author;

/**
 * @author Akif Batur
 * 
 */
public class AuthorMapper implements RowMapper<Author> 
{
	@Override
	public Author mapRow(ResultSet resultSet, int rowNumber) throws SQLException 
	{
		return null;
	}
}