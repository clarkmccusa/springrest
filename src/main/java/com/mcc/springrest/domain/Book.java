package com.mcc.springrest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

	public Book(){}
	public Book( Long id, String title, String authorName ){
		this.id = id;
		this.title = title;
		this.authorName = authorName;
	}
	
	protected Long id;
	protected String title;
	@JsonProperty("author_name")
	protected String authorName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
