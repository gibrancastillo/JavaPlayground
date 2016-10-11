package com.ccc.rest.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_VALUE_PREFIX = "Basic ";
	
	/**
	 * This is an HTTP Request filter method.  The JAX-RS framework is going to call this filter method implementation, before
	 * the HTTP Request is served.  Here I will check if the HTTP Request has Basic Auth.
	 * 
	 * @param containerRequestContext
	 * @throws IOException
	 */
	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		List<String> authHeaders = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		
		if(authHeaders.size() > 0) {
			String authToken = authHeaders.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_VALUE_PREFIX, "");
			
			/*
			 * The Apache Commons Codec library has a Basic64 utility class that could also be used instead.
			 * In this case I am using the Jersey utility org.glassfish.jersey.internal.util.Base64
			 */
			String decodedString = Base64.decodeAsString(authToken);
			
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			/*
			 * This where you can do authentication.  If I have authentication information, like in a database,
			 * then using some business service I can check if the username and password match.
			 */
			if("user".equals(username) && "password".equals(password)) {
				return;
			}
		}
		
		Response unauthorizedStatus = Response
				.status(Response.Status.UNAUTHORIZED)
				.entity("User cannot access the resource")
				.build();
		
		containerRequestContext.abortWith(unauthorizedStatus);
	}
}