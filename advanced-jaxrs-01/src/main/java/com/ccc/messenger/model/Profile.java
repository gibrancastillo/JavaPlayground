package com.ccc.messenger.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

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
public class Profile {
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	/**
	 * Needed by JAXB to convert the Profile object to XML or JSON and vice versa.
	 * We need to de-serialize and serialize the ErrorMessage.
	 */
	public Profile() {
		
	}
	
	/**
	 * The four arguments in this constructor allow us create this instances on the fly.
	 * 
	 * @param id
	 * @param profileName
	 * @param firstName
	 * @param lastName
	 */
	public Profile(long id, String profileName, String firstName, String lastName) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProfileName() {
		return profileName;
	}
	
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
}