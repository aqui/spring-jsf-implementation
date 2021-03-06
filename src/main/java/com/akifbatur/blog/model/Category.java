package com.akifbatur.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Akif Batur
 *
 */
@Entity
@Table(name="CATEGORY", catalog="BLOG")
public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(Category.class);
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//Provided by the user
	@NotNull
	@Size(min=1,max=255)
	@Column(name="CATEGORY_TITLE", unique = true, nullable = false)
	private String categoryTitle;
	
	@Column(name="CATEGORY_DATE", nullable = false)
	private Date categoryDate;
	
	@Column(name="CATEGORY_EDIT_DATE", nullable = false)
	private Date categoryEditDate;
	
	//Each category has an author
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID", nullable = false)
	private Author author;
	
	//Each category has many posts
	@OneToMany(mappedBy="category")
	private Set<Post> post = new HashSet<Post>(0);
	
	public Category()
	{
		
	}
	
	public Category(int id, String categoryTitle, Date categoryDate,
			Date categoryEditDate, Author author, Set<Post> post) {
		super();
		this.id = id;
		this.categoryTitle = categoryTitle;
		this.categoryDate = categoryDate;
		this.categoryEditDate = categoryEditDate;
		this.author = author;
		this.post = post;
	}
	
	public int getId() {
		return id;
	}

	public Author getAuthor() {
		return author;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public Date getCategoryDate() {
		return categoryDate;
	}

	public Date getCategoryEditDate() {
		return categoryEditDate;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public void setCategoryDate(Date categoryDate) {
		this.categoryDate = categoryDate;
	}

	public void setCategoryEditDate(Date categoryEditDate) {
		this.categoryEditDate = categoryEditDate;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryTitle=" + categoryTitle + "]";
	}
}
