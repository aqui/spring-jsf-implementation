package com.akifbatur.blog.dao;
/**
 * @author Akif Batur
 * 
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.akifbatur.blog.model.Tag;

public class TagMapper implements RowMapper<Tag> 
{
	@Override
	public Tag mapRow(ResultSet resultSet, int rowNumber) throws SQLException 
	{
		return null;
	}
}
