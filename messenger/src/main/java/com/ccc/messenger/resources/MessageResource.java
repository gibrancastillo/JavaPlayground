package com.ccc.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ccc.messenger.model.Message;
import com.ccc.messenger.resources.beans.MessageFilterBean;
import com.ccc.messenger.service.MessageService;

/**
 * 'Root' Resource based (not action based) URI class API.  In this case the resource is 'messages'.  The HTTP Methods tell you the operation to be made on the resource.
 * 
 * HTTP Request       SQL          Operation                                    Success/Failure            HTTP Status Code
 *   Method        Statement
 * <> POST   --->   INSERT     --> 'C'reate              (Non-Idempotence)    --> Success                 --> 201   'Created'
 *                                                                            --> Wrong Format            --> 400   'Bad Request'
 *                                                                            --> Wrong Data              --> 415   'Unsupported Media Type'
 *                                                                            --> Failure                 --> 500   'Internal Server Error'
 *     
 * <> GET    --->   SELECT     --> 'R'ead (Retrieve)                          --> Success                 --> 200   'OK'
 *                                                                            --> Not Found               --> 404   'Not Found'
 *                                                                            --> Failure                 --> 500   'Internal Server Error'
 * 
 * <> PUT    --->   UPDATE     --> 'U'pdate (Modify)     (Idempotence)        --> Success                 --> 200   'OK'
 *                                                                            --> Wrong Format            --> 400   'Bad Request'
 *                                                                            --> Wrong Data              --> 415   'Unsupported Media Type'
 *                                                                            --> Not Found               --> 404   'Not Found'
 *                                                                            --> Failure                 --> 500   'Internal Server Error'
 * 
 * <> DELETE --->   DELETE     --> 'D'elete (Destroy)                         --> Success                 --> 200   'OK'
 *                                                                            --> Success                 --> 204   'No Content'
 *                                                                            --> Not Found               --> 404   'Not Found'
 *                                                                            --> Failure                 --> 500   'Internal Server Error'
 * 
 * You can use the HTTP Method POST to perform an update operation; however, the standard practice is to use the HTTP Method PUT.  HTTP Method POST is use for creating a new resource.
 * The HTTP Method GET is read-only; while POST, PUT and DELETE are write HTTP Methods.
 * The following are repeatable (Idempotence) HTTP Methods:  GET, PUT and DELETE.  Meaning that can be applied safely multiple times without changing the result beyond the initial application.
 * The HTTP Method POST cannot be repeated safely (Non-Idempotence).
 * 
 * 
 * A bit uncommon:  HEAD, OPTIONS, etc.
 * 
 * Since every method in this resource based class either consumes or produces a JSON, then you can move their annotations from the method to the class, to make them global, centralized
 * and accessible and utilize by every method in this resource based class.
 * 
 * HTTP Status Codes use for HTTP Responses.  There are five HTTP Status Codes Classes.  The first digit indicates to what class the code belongs to
 * 
 * HTTP Status Codes
 * =================
 * <> 1XX - Informational
 * <> 2XX - Success, for example 200 is OK, 201 is Created, 204 is No Content, etc.
 * <> 3XX - Redirection, use by the Server to ask the client to do further action to complete the request, for example, 302 is found, 304 is Not Modified, or 307 is Temporary Redirect	 
 * <> 4XX - Client Error, return by the Server if the request syntax could have been incorrect or the client is requesting something is not supposed to see (unauthorized)
 *          400 is Bad Request, 401 is Unauthorized, 403 is Forbidden, 404 is Not Found, 415 is Unsupported Media Type, etc. 
 * <> 5XX - Server Error
 * 
 * 
 * There are several libraries (frameworks) that allow you to write REST Web Service API applications; for instance, Restlet (https://restlet.com/), REST Easy (http://resteasy.jboss.org/)
 * and Jersey.  If you learn one of these libraries, you learned them all, they all follow a common interface and implement a common API, that is JAX-RS.
 * 
 * <> JAX-RS (javax.ws.rs.*) has a bunch of interfaces and annotations but it does not have any functionality, you need classes that implement the JAX-RS interfaces and read these
 *                           annotations, that is where libraries (frameworks like Restlet, REST Easy and Jersey) come in.  These libraries look at your code and see where you called
 *                           the JAX-RS APIs and they do the actual work.
 *                           Every JAX-RS library (frameworks like Restlet, REST Easy and Jersey) comes with a copy of JAX-RS API (like a jar with interfaces & annotations)
 * 
 * <> Jersey is a 'reference implementation' for the JAX-RS specification, it's like a model implementation for the API and this implementation is built by a lot of the same people 
 *           who designed JAX-RS API specification.
 *           
 * 
 * Content Negotiation
 * ===================
 * Is when the client and the server exchange media type to decide the content type the client is going to 'send' to the server (application/json or text/xml or plain/text etc.)
 * and content type it wants to get back from the server (application/json or text/xml or plain/text etc.).  The client identifies the media type is going to be sending to the server by
 * setting the 'Content-Type' HTTP Header parameter; for example Content-Type = application/json and by sending the message in that content type (JSON or XML or text etc.) which maps to
 * the @Consumes(MediaType.APPLICATION_JSON) annotation, if is set to something else or not supported the server cannot consume and process the client's request content type.  The client
 * identifies the media type it wants to get back from the server by setting the 'Accept' HTTP Header parameter; for example, Accept = application/json which maps to the 
 * @Produces(MediaType.APPLICATION_JSON) annotation, if is set to something else or not supported the server cannot produce or create the response content type.
 * 
 * You could annotate @Produces to support more than one content type; for example, JSON and XML, this means it can either send back to the client a JSON message or an XML message by
 * just doing the following at the class level @Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML }); therefore, the REST Web Service API supports JSON and XML.
 * You could do this at the method level instead of the class level, at the method level you would need to have a method that produces a JSON content type and a method that produces 
 * an XML content type.
 * 
 * The Client passes in the HTTP Header:
 * <> Accept - to tell the server what format it can accept
 * <> Content-Type - to tell the server what format it's actually sending messages in
 * 
 * The Server has two annotations:
 * <> @Produces - to tell what output or response or content type it (the class or the method) can produce
 * <> @Consumes - to specify the format of the request that it (the class or the method) can consume
 * 
 * HTTP Response:  Accepts value maps to the @Produces
 * HTTP Request:   Content-Type value maps to the @Consumes
 * 
 * 
 * @author gecasti
 *
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class MessageResource {
	private MessageService messageService = new MessageService();
	
	/**
	 * The annotation @Produces(MediaType.APPLICATION_XML) tells Jersey to send an HTTP Response in an XML format.  Changing MediaType.APPLICATION_XML
	 * to MediaType.APPLICATION_JSON tells Jersey to send an HTTP Response in a JSON format.  However, for this to work, that is, for a java object
	 * to be converted to JSON and vice versa you have to add the jersey-media-moxy.jar because there is no JSON converter that comes out of the box
	 * (Jersey or JSD or JEE) and JAXB only handles XML conversion from java object to XML and vice versa.
	 * 
	 * Message Body Writer is a class that converts from a Java type or object to a JSON or XML.  The annotation @Produces calls the correct Message
	 * Body Writer which does the conversion from a Java object to JSON.
	 * 
	 * http://localhost:8080/messenger/webapi/messages
	 * Protocol:  http
	 * Tomcat Server Hostname:  localhost
	 * Tomcat Server Port:  8080
	 * Java REST API WebApp Context:  messenger
	 * Java REST API WebApp URL Pattern:  webapi
	 * Java REST API WebApp Resource:  messages
	 * 
	 * Since we cannot have another method to get all the messages base on year (filtering) or pagination (start & size),
	 * we have to modify getMessages() from looking like this to what it looks now
	 * @GET
	 * public List<Message> getMessages() {
	 *     return messageService.getAllMessages();
	 * }
	 * 
	 * To be able to filter by year http://localhost:8080/messenger/webapi/messages?year=2016 you need to get a hold of the year query parameter by using the
	 * annotation @QueryParam for year and this you annotate in the method argument.  Now Jersey can differentiate between API URI calls, so when the client executes or calls
	 * http://localhost:8080/messenger/webapi/messages without the year query parameter, then the query parameter year value is '0', which maps to getAllMessages() and
	 * http://localhost:8080/messenger/webapi/messages?year=2016 to getAllMessagesFilterByYear(year)
	 * 
	 * To be able to paginate by start (zero base) and size http://localhost:8080/messenger/webapi/messages?start=2&size=1 you need to get a hold of the start and size query parameter
	 * by using the annotation @QueryParam for index and size, which are annotated in the method argument.
	 * 
	 * @return
	 */
	/*@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if(year > 0) {
			//Filtering
			return messageService.getAllMessagesFilterByYear(year);
		}
		
		//start is zero based; however, don't change the size to >= 0 or the getAllMessages() method will never be called!
		if(start >= 0 && size > 0) {
			//Pagination
			return messageService.getAllMessagesPaginated(start, size);
		}
		
		return messageService.getAllMessages();
	}*/
	
	/**
	 * If you have a huge amount of Jersey Param annotations in a method signature and you don't like it, to solve this problem you can use the @BeanParam annotation.
	 * To make this work, you first create a separate bean class (like a POJO) which has all the Jersey Param annotations in the method signature, which become members
	 * variable with their respective Jersey Param annotations with getters and setters.  And then you replace all the Jersey Param annotations in the method signature
	 * with just the @BeanParam with an instance of the bean class (like a POJO, in this case the MessageFilterBea).  What Jersey is going to do is going to see that 
	 * MessageFilterBean is the bean the user is looking for and hence Jersey is going to inspect the HTTP Request for all the different things this bean is looking for. 
	 * 
	 * @param messageFilterBean
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@BeanParam MessageFilterBean messageFilterBean) {
		System.out.println("getJsonMessages method called, because the client's HTTP Header parameter Accept=application/json, method produces & returns to client a JSON Content Type response");
		
		if(messageFilterBean.getYear() > 0) {
			//Filtering
			return messageService.getAllMessagesFilterByYear(messageFilterBean.getYear());
		}
		
		//start is zero based; however, don't change the size to >= 0 or the getAllMessages() method will never be called!
		if(messageFilterBean.getStart() >= 0 && messageFilterBean.getSize() > 0) {
			//Pagination
			return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessages(@BeanParam MessageFilterBean messageFilterBean) {
		System.out.println("getXmlMessages method called, because the client's HTTP Header parameter Accept=text/xml, method produces & returns to client an XML Content Type response");
		
		if(messageFilterBean.getYear() > 0) {
			//Filtering
			return messageService.getAllMessagesFilterByYear(messageFilterBean.getYear());
		}
		
		//start is zero based; however, don't change the size to >= 0 or the getAllMessages() method will never be called!
		if(messageFilterBean.getStart() >= 0 && messageFilterBean.getSize() > 0) {
			//Pagination
			return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	/**
	 * Accessing Path params.  The @Path annotation can be map to the method as well; therefore, this API call
	 * http://localhost:8080/messenger/webapi/messages/1 will return message object with id 1.  This is a dynamic API call.
	 * The curly braces "{}" tell Jersey that text within the curly braces is a variable, which a portion of the URI, making it a dynamic API call.
	 * In this case we name the variable 'messageId'.  To capture or get a hold of the 'messageId' variable and send it to the MessageService class use the Jersey
	 * feature that actually passes in the value in 'messageId' as a method argument, to make that happen use the Jersey annotation @PathParam, which tells Jersey
	 * to inject the value of the variable 'messageId' from the dynamic API call into the method argument.  Jersey will try to convert the value of the variable
	 * 'messageId' from the dynamic API call to the data type of the method argument, in this case long.
	 * 
	 * Method API without HATEOAS:
	 * @GET
	 * @Path("/{messageId}")
	 * public Message getMessage(@PathParam("messageId") long messageId) {
	 *     return messageService.getMessage(messageId);
	 * }
	 * 
	 * uriInfo
	 * 		.getAbsolutePathBuilder()
	 * 			|
	 * 			|
	 * 			|_______ UriBuilder
	 *                        .path("blah")                         /blah/    hardcoded
	 *                        
	 *                        or you can use the overloaded path method that takes any resource class and is going to
	 *                        find the @Path annotation to this resource which is annotated at the class level and it's going
	 *                        to add that to the URL that it's building
	 *                        .path(MessageResource.class)         /messages/
	 * 
	 * @param messageId
	 * @return
	 */
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(messageId);
		message.addLink(getSelfUri(uriInfo, message.getId()), "self");
		message.addLink(getProfileUri(uriInfo, message.getAuthor()), "profile");
		message.addLink(getCommentsUri(uriInfo, message.getId()), "comments");
		
		return message;
	}
	
	/**
	 * Not very elegant or best way to build HATEOAS HTTP Responses but it works.
	 * 
	 * @param uriInfo
	 * @param messageId
	 * @return
	 */
	private String getSelfUri(UriInfo uriInfo, long messageId) {
		String uri = uriInfo.getBaseUriBuilder()  //This gives you http://localhost:8080/messenger/webapi
			   .path(MessageResource.class)       //This gives you                                     /messages
			   .path(Long.toString(messageId))    //This gives you                                          /{messageId}
			   .build()
			   .toString();
		
		return uri;
	}
	
	/**
	 * 
	 * @param uriInfo
	 * @param profileName
	 * @return
	 */
	private String getProfileUri(UriInfo uriInfo, String profileName) {
		String uri = uriInfo.getBaseUriBuilder()  //This gives you http://localhost:8080/messenger/webapi
			    .path(ProfileResource.class)      //This gives you                                     /profiles
				.path(profileName)                //This gives you                                          /{profileName}
				.build()
				.toString();
		
		return uri;
	}
	
	/**
	 * CommentResource is a sub-resource and the @Path annotation at the class level is just '/'; therefore, you need to build the comments URI a little bit different.
	 * 
	 * @param uriInfo
	 * @param messageId
	 * @return
	 */
	private String getCommentsUri(UriInfo uriInfo, long messageId) {
		String uri = uriInfo.getBaseUriBuilder()                        //This gives you http://localhost:8080/messenger/webapi
				.path(MessageResource.class)                            //This gives you                                     /messages
				.path(MessageResource.class, "commentResourceCRUDOps")  //This gives you                                          /{messageId}/comments
				.path(CommentResource.class)                            //This gives you                                                             /
				.resolveTemplate("messageId", messageId)
				.build()
				.toString();
		
		return uri;
	}
	
	/**
	 * Accessing Path params.  The @Path annotation can be map to the method as well; therefore, this API call
	 * http://localhost:8080/messenger/webapi/messages/test will return "respond with test"  The problem with this is that this API call is static
	 * @return
	 */
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "respond with test";
	}
	
	/**
	 * For this to work properly the HTTP POST Request calling this API method should have in the Header the parameter "Content-Type = application/json"
	 * and the Body (payload) should be in JSON format.  Moreover, in this method API accept the Model type (in this case Message.java) as argument to
	 * bind to the HTTP POST Request body.  With this requirements met, Jersey knows to convert the HTTP POST Request body in JSON format to the Message Java object.
	 * 
	 * The @Produces annotation produces a JSON output to return back to the client.  Since this method consumes a JSON output coming from the client
	 * then you need to add the @Consumes annotation.  The @Post annotation maps the HTTP POST Request to this method.
	 * 
	 * You can use the HTTP Method POST to perform an update operation; however, the standard practice is to use the HTTP Method PUT.  HTTP Method POST is use for creating a new resource.
	 * Therefore, this method creates or adds a new message.
	 * 
	 * 
	 * In order to return the correct HTTP Method status code 201 for created to the client we don't return the Message data type:
	 * @POST
	 * public Message addMessage(Message message) {
	 *     return messageService.addMessage(message);
	 * }
	 * 
	 * instead we return Jersey Response data type as implemented below	and Jersey is going to convert the Message object to JSON and set the HTTP status code.
	 * @POST
	 * public Response addMessage(Message message, @Context UriInfo uriInfo) {
	 *     Message createdMessage = messageService.addMessage(message);
	 *     return Response.status(Status.CREATED)
						  .entity(createdMessage)
						   .build();
		}
	 * 
	 * 
	 * In order to return the resource URL call back to the client in the HTTP Header in the HTTP Response is by accessing the context by annotating the @Context,
	 * which can be annotated to special data types of arguments like:
	 * <> UriInfo.java - what Jersey does is inject a instance of UriInfo, which contains a lot of information about the URI that was access that lead to this method from been call.
	 * <> HttpHeaders.java - contains HTTP Header information.
	 *  
	 * @param message
	 * @return
	 */
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		//Create the new Message
		Message newMessage = messageService.addMessage(message);
		
		//Get the new Message's Id
		String newId = String.valueOf(newMessage.getId());
		
		//Build the resource URL use to call this API method + new message Id created.
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		
		System.out.println("Resource location: " + uri);
		
		/*
		 * Response.created sets the HTTP status code to 201 - created and allows you to send back the resource URL use to call this API method + new message Id created.
		 * This is a short cut to set the HTTP status code and the location (resource URL use to call this API method).
		 */
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	
	/**
	 * You need the message id to update or modify the message you are targeting to change; therefore, you want the API URI to provide the message id in case the message id
	 * is not provided in the HTTP PUT Request body in JSON format.
	 * 
	 * You can use the HTTP Method POST to perform an update operation; however, the standard practice is to use the HTTP Method PUT.  HTTP Method POST is use for creating a new resource.
	 * Therefore, this method updates or modifies an existing message.
	 * 
	 * @param message
	 * @return
	 */
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId) {
		messageService.removeMessage(messageId);
	}
	
	/**
	 * You still have the root resource, but use Hook method in root resource to delegate responsibility to the sub-resource
	 * We do not annotate this method with any HTTP Request method (@GET, @POST, @PUT or @DELETE or whatever) so that we can utilize this method 
	 * to get one comment, get all comments, to create or add a new comment, to update an existing comment or to remove an existing comment.
	 * Therefore, no matter what HTTP Request method is use to call this RESTful API it will work, what Jersey using JAX-RS is going to do is execute
	 * this method and see that the return type is a sub-resource, so is going to look for the actual method to execute inside the sub-resource
	 * base on the HTTP Request method (@GET, @POST, @PUT or @DELETE or whatever) and return accordingly.
	 * Furthermore, we want this method to return an instance of the sub-resource we are delegating to.  
	 * 
	 * This design allows us to have separate APIs and separate resources so we don't put all of them in the parent or root resource, you can actually delegate
	 * API calls in other sub resources.
	 * 
	 * @return
	 */
	@Path("/{messageId}/comments")
	public CommentResource commentResourceCRUDOps() {
		return new CommentResource();
	}	
}