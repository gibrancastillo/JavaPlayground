package com.ccc.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * The Jersey Param Annotations (they go in the method signature):
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
 * 
 * 
 * @author gecasti
 *
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("/annotations")
	public String getParamUsingAnnotations() {
		return "Testing The Jersey Param Annotations";
	}
	
	/**
	 * The Matrix Param is utilize in the API URI call using ";" like this http://localhost:8080/messenger/webapi/injectdemo/annotations;param=value
	 * 
	 * @param matrixParam
	 * @return
	 */
	@GET
	@Path("matrixannotation")
	public String getStringUsingMatrixParam(@MatrixParam("param") String matrixParam) {
		return "Testing The Jersey Matrix Param Annotation.  Matrix param: " + matrixParam;
	}
	
	@GET
	@Path("matrixheaderannotation")
	public String getStringUsingMatrixHeaderParam(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderKey") String headerParam) {
		return "Testing The Jersey Matrix/Header Param Annotation.\n  Matrix param: " + matrixParam + "\n  Header param: " + headerParam;
	}
	
	@GET
	@Path("matrixheadercookieannotation")
	public String getStringUsingMatrixHeaderCookieParam(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderKey") String headerParam,
											@CookieParam("customCookieName") String cookieParam) {
		return "Testing The Jersey Matrix/Header/Cookie Param Annotation.\n  Matrix param: " + matrixParam + "\n  Header param: " + headerParam + "\n  Cookie param: " + cookieParam;
	}
	
	/**
	 * The Header Parameters are sent in the payload as part of the HTTP Request.  The client can send custom values in the HTTP Header in the HTTP Request.
	 * This header param is something developers would utilize more, typically to send metadata about the HTTP Request; for instance, OAuth (authentication token)
	 * or the URL executed by the client or hostname/port of the client for callback.
	 * 
	 * @param headerParam
	 * @return
	 */
	@GET
	@Path("headerannotation")
	public String getStringUsingHeaderParam(@HeaderParam("customHeaderKey") String headerParam) {
		return "Testing The Jersey Header Param Annotation.\n  Header param: " + headerParam;
	}
	
	@GET
	@Path("cookieannotation")
	public String getStringUsingCookieParam(@HeaderParam("customCookieName") String cookieParam) {
		return "Testing The Jersey Cookie Param Annotation.\n  Cookie param: " + cookieParam;
	}
	
	/**
	 * So far the all the param annotations requires you to know the name of the variable; for instance, the name of the cookie.
	 * What if you don't know the name of the cookie or if you want to access all the cookies, to do that you use the @Context annotation
	 * 
	 * The way to access the context is by annotating the @Context, which can be annotated to special data types of arguments like:
	 * <> UriInfo.java - what Jersey does is inject a instance of UriInfo, which contains a lot of information about the URI that was access that lead to this method from been call.
	 * <> HttpHeaders.java - contains HTTP Header information.
	 * 
	 * 
	 * @param uriInfo
	 * @return
	 */
	@GET
	@Path("context")
	public String getStringUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = httpHeaders.getCookies().toString();
		
		return "Context \n Path: " + path + "\n Cookies: " + cookies;
	}
}