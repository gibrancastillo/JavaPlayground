package com.ccc.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * A model class (object), which is an Entity class
 * Annotated this model class with jakarta.xml.bind.annotation.XmlRootElement so that JAX-RS within Jersey
 * will use JAXB (Java Architecture for XML Binding) to convert the Message object to XML and vice versa.
 * JAXB comes bundle with Java Standard Edition
 * 
 * Jersey honors the annotation @XmlRootElement to convert the Message object to JSON and vice versa.
 * 
 * 
 * 
 * ===========
 * | HATEOAS |
 * ===========
 * - A way to provide links (hypertext or hyperlink or hypermedia) to resources in the REST Web Service API HTTP Response, so the client does not have to deal with the 
 *   REST Web Service API construction (Hardcoded) and the business flow.
 * - Making the response navigable
 * 
 * - 'H'ypermedia 'A's 'T'he 'E'ngine 'O'f 'A'pplication 'S'tate
 * - Remember that REST Web Service APIs have no Service Definition, there is no formal documentation for the API itself.
 * - HTTP, Hypertext is text that has links to other text, these links are call Hyperlinks.
 * - The HTTP Response comes with hyperlinks, provided by the REST Web Service API without the Client requesting for the hyperlinks, similar to hyperlinks in websites or web pages,
 *   they are available regardless the client wants to use them or not, but if they want them they are there.
 * - The client developer can just pick up the value after the right URI or hyperlink provided in the previous response and makes a subsequent call to those URIs and when the 
 *   subsequent response comes in that will have further hyperlinks or URIs that the client could be interested in, so the process repeats itself again.
 * - If you do this, you don't let the client programmer have to know and hardcode these URIs in order to interact with the resources and the application state
 * - You basically let the hypertext (hyperlinks) or hypermedia in the HTTP Response drive the client's interaction with the application state
 * - The Hypertext or Hypermdia been the driver or the engine of the application, hence making the REST Web Service interaction dynamic so the client does not have construct the URI
 *   because the resource URI is one of the properties in the resource.
 * <> href (link) - hpertext or hyperlink or hypermedia reference.  href is a property of the anchor tag which contains the URL.
 * <> rel - an attribute that you can add to any link to specify the relationship between the current document and the link document.  The most common example for rel are stylesheet links
 * The 'href' provides the actual URL being linked and the 'rel' attribute describes the relation of that link to the main document.  For example the link is a stylesheet of the main document,
 * so we can use the 'rel' attribute to add extra information in the links in the REST HTTP Response.
 *   
 *   For example:
 * {
 * 		"author" : "gibran",
 *      "created" : "2016-09-2016T17:37:57.177",
 *      "id" : "20",
 *      "links" : [
 *      	{
 *      		"link" : "http://localhost:8080/messenger/webapi/messages/1",
 *      		"rel" : "self"
 *      	},
 *      	{
 *      		"link" : "http://localhost:8080/messenger/webapi/messages/1/comments",
 *      		"rel" : "comments"
 *      	},
 *      	{
 *      		"link" : "http://localhost:8080/messenger/webapi/messages/1/likes",
 *      		"rel" : "likes"
 *      	},
 *      	{
 *      		"link" : "http://localhost:8080/messenger/webapi/messages/1/shares",
 *      		"rel" : "shares"
 *      	},
 *      	{
 *      		"link" : "http://localhost:8080/messenger/webapi/profiles/gibran",
 *      		"rel" : "profile"
 *      	}
 *      ],
 *      "message" : "Hola Mundo!",
 * }
 * 
 * - The way you structure HATEOS in the HTTP Response can be done in multiple ways, there is no right or wrong, you need to do it in a way that makes sense to you.
 * - The 'rel' attribute is part of the HTTP specification, so there are only certain standard values that are allow for, see http://www.iana.org/assignments//link-relations/link-relations.xml
 * - For 'rel' attribute comments and likes are not actual standardize values, but you can still use it.
 * - The idea is to have a REST Web Service API that is easy for the client to use and for the developer to maintain, you don't want to focus too much on getting things right and going by
 *   the book, at least	not at the cost of complicating the REST Web Service API too much.
 *   
 * 
 * 
 * 
 * @author gecasti
 *
 */
@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	
	/*
	 * A 'Map' of the commentId and Comment instance, because every Message instance has 0 or more comments.
	 * A Message instance has a Map of commentId to the Comment instance.
	 */
	private Map<Long, Comment> comments = new HashMap<>();
	
	/*
	 * Use for HATEOAS
	 * A list of links
	 */
	private List<Link> links = new ArrayList<>();
	
	/**
	 * Needed by JAXB to convert the Message object to XML or JSON and vice versa.
	 * We need to de-serialize and serialize the ErrorMessage.
	 */
	public Message() {
		
	}
	
	/**
	 * The three arguments in this constructor allow us create this instances on the fly.
	 * 
	 * @param id
	 * @param message
	 * @param author
	 */
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
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
	
	/**
	 * This method was marked with the @XmlTransient annotation because we don't want the comment list (comment data) to
	 * show up when the Message instance is retrieve by the API method call to getMessage() or getMessages().  We don't want
	 * the list of all the comments when we you access a Message.  You want the Comment list to be ignore when the Message
	 * instance is been converted to XML or JSON and the way to do that is by marking this method as @XmlTransient, this marks
	 * it as ignore for XML conversion but event JSON conversion is honor.
	 * 
	 * @return
	 */
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	/**
	 * This method was created and use in order to allow MessageResource to be able to add the HATEOAS links to the Message.
	 * 
	 * @param url a String value that represents the URL to the message itself.
	 * @param rel a String value that represents the relation of the link.
	 */
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	
	@Override
	public String toString() {
		return "";
	}
}