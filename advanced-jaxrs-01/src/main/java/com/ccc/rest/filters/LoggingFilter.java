package com.ccc.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * There are two types of filters in JAX-RS:
 * <> ContainerRequestFilter - a filter that executes before the HTTP Request is served.  Here you are intercepting the HTTP Request.
 * 
 * <> ContainerResponseFilter - a filter that executes after the HTTP Response is prepared and it's about to be sent to the client.
 *                              Here you are intercepting the HTTP Response.
 * 
 * This custom HTTP Request/Response Filter class uses the @Provider annotation to register itself with JAX-RS, so that JAX-RS knows that
 * this custom HTTP Request/Response Filter is available, so when this messenger RESTful API is about to server an HTTP Request to a Resource base API
 * and is about to sent the HTTP Response to the client JAX-RS is able to find this custom response filter and utilize it accordingly.
 * 
 * In order to register this class as a custom LoggingFilter for JAX-RS we annotate the class with @Provider to this class.
 * 
 * 
 * @author gecasti
 *
 */
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
	
	/**
	 * This is an HTTP Request filter method.  The JAX-RS framework is going to call this filter method implementation, before
	 * the HTTP Request is served.  Here you have a chance to modify the HTTP Request before is served to the Resource base API class; for instance,
	 * by adding an HTTP Header value.
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("HTTP Request Filter");
		System.out.println("HTTP Request Headers: " + requestContext.getHeaders());
	}
	
	/**
	 * This is an HTTP Response filter method.  The JAX-RS framework is going to call this filter method implementation, then
	 * the HTTP Response is about to be sent.  Here you have a chance to modify the HTTP Response before is sent to the client; for instance,
	 * by adding an HTTP Header value.
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		System.out.println("HTTP Response Filter");
		System.out.println("HTTP Response Headers: " + responseContext.getHeaders());
	}	
}