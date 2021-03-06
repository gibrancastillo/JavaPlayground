package com.ccc.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 'Root' Resource based (not action based) URI class API.  The default Life Cycle of a JAX-RS Resource based class is 'Request Scoped'; therefore, every HTTP Request that
 * maps to this class results in a new instance of this resource based class.  Request Scope means that the scope of a resource instance is about the request, so a new instance
 * is created per request and then when the response is sent back or done the resource instance is destroyed.
 * 
 * The per request scope or default life cycle can be changed.  You can also have what's called the Singleton case, which is 'Session Scoped'.  With Singleton you can configure a
 * resource to be created just once and then JAX-RS holds on to that resource instance and utilizes it to handle all request.  To make a resource singleton all you have to do is
 * annotated with @Singleton.
 * 
 * These are the two type of Resource Life Cycle:  Default (Request Scoped) and Configure to Singleton (Session Scoped)
 * 
 * A Singleton annotation (Session Scoped) has an impact on the JAX-RS Param Annotations.
 * <> @Context
 * <> @BeanParam 
 * <> @CookieParam gives you access to cookies in the HTTP Request by cookie 'name'
 * <> @FormParam use when you want to access form submissions, when a form is submitted the values go as key value pair,
 *               so there is a key which is the name of the control like a text box and the value, been the value in the text box.
 *               To capture a request like this, sent from an HTML form to a REST API, you would use this param annotation. 
 * <> @HeaderParam gives you access to the 
 * <> @MatrixParam
 * <> @PathParam
 * <> @QueryParam
 * 
 * There is a resource validation that is happening.  JAX-RS is not able to inject into a Singleton resource, because the singleton resource based class gets created before
 * the HTTP Request and hence there is nothing in the param annotations to be injected.  Singleton resources are instantiated during application startup.  So, you cannot inject
 * request-specific information to their member variables.
 * 
 *  
 * @author gecasti
 *
 */
@Path("/{pathParam}/test")
//@Singleton
public class MyResource {
	//private int count;
	
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		//count++;
		
		//return "It works!  This method was called " + count + " time(s)";
		return "It works!  Path param used " + pathParamExample + " and Query param used " + queryParamExample;
	}
	
	/**
	 * The MessageBodyReader and the MessageBodyWriter is what converts from the raw content that get sends in the HTTP Request and HTTP Response to Java type or vice versa
	 * 
	 * 
	 * MessageBodyReaders
	 * ==================
	 * An HTTP Request (POST [create] or PUT [update]) has a message body or payload that could be in XML, JSON, plain text, etc.  The MessageBodyReader 'reads' the data in the message body
	 * of the HTTP Request in the content type submitted and specify in the @Consumer media type annotation and converts it to a Java object or Java instance content.
	 * 
	 * 
	 * 
	 * MessageBodyWriters
	 * ==================
	 * An HTTP Response (GET) has a message body or payload that could be in XML, JSON, plain text, etc.  The MessageBodyWriter converts the Java object or Java instance content to
	 * the specify content type provided in the @Produces media type annotation and 'writes' the data in the message body of the HTTP Response in the specify media type in the @Produces
	 * annotation and sends it to the client	
	 * 
	 * 
	 * 
	 * @return
	 */
	@GET
	@Path("/msg")
	@Produces(MediaType.TEXT_PLAIN)
	public Date msgBodyWriterMethod() {
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * Media types are used in @Produces and @Consumes annotations to tell the MessageBodyReaders (@Consumes) and MessageBodyWriters (@Produce) how to read or write the contents.
	 * 
	 * You can create your on custom media type, it is just a string or text message in the @Produces or @Consumes annotation that is use to identify how the data should be read or written;
	 * however, you have to map the custom media type to the correct custom MessageBodyReader and/or MessageBodyWriter. 
	 * 
	 * With only one media type in @Produces("text/shortdate") then the client can only request for one type of response, in this case the customize media type "text/shortdate" maps to the
	 * custom ShortDateMessageBodyWriter; however, with @Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate" }) the client can either request "text/plain" media type response without
	 * passing the HTTP Header parameter "Accept = text/plain" in the HTTP Request GET method (not required, is optional but you could) which is generated by custom DateMessageBodyWriter or
	 * "text/shortdate" media type response by passing the HTTP Header parameter "Accept = text/shortdate" in the HTTP Request GET method which is generated by custom ShortDateMessageBodyWriter
	 * 
	 * @return
	 */
	@GET
	@Path("/myMsg")
	//@Produces("text/shortdate")
	@Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate" })
	public Date msgBodyWriterMyMediaTypeMethod() {
		return Calendar.getInstance().getTime();
	}
}