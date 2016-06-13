package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String content;
	private String username;

	public Entry() {
		super();
	}

	public Entry(String content, String username) {
		super();
		this.setContent(content);
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
