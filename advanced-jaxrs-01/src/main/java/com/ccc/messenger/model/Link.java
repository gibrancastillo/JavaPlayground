package com.ccc.messenger.model;

/**
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
 * - If you do this, you don't let the client programmer have to know amd hardcode these URIs in order to interact with the resources and the application state
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
 * @author gecasti
 *
 */
public class Link {
	private String link;
	private String rel;
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getRel() {
		return rel;
	}
	
	public void setRel(String rel) {
		this.rel = rel;
	}
}