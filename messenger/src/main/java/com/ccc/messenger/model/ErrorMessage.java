package com.ccc.messenger.model;

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
public class ErrorMessage {
	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	/**
	 * Needed by JAXB to convert the ErrorMessage object to XML or JSON and vice versa.
	 * We need to de-serialize and serialize the ErrorMessage.
	 */
	public ErrorMessage() {
		
	}
	
	/**
	 * The three arguments in this constructor allow us create this instances on the fly.
	 * 
	 * @param errorMessage
	 * @param errorCode
	 * @param documentation
	 */
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getDocumentation() {
		return documentation;
	}
	
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}