package com.ccc.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A model class (object), which is an Entity class
 * Annotated this model class with javax.xml.bind.annotation.XmlRootElement so that JAX-RS within Jersey
 * will use JAXB (Java Architecture for XML Binding) to convert the Message object to XML and vice versa.
 * JAXB comes bundle with Java Standard Edition
 * 
 * Jersey honors the annotation @XmlRootElement to convert the Message object to JSON and vice versa.
 * 
 * @author gecasti
 *
 */
@XmlRootElement
public class Comment {
	private long id;
	private String comment;
	private Date created;
	private String author;
	
	/**
	 * Needed by JAXB to convert the Comment object to XML or JSON and vice versa.
	 * We need to de-serialize and serialize the ErrorMessage.
	 */
	public Comment() {
		
	}
	
	/**
	 * The three arguments in this constructor allow us create this instances on the fly.
	 * 
	 * @param id
	 * @param comment
	 * @param author
	 */
	public Comment(long id, String comment, String author) {
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}