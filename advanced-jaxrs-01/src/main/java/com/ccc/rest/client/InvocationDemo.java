package com.ccc.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Creating Invocations - you can prepare an HTTP Request and put in all the things you need that HTTP Request to do.
 * For instance, you need to know where the target is, what is the HTTP Request format, what is the body of the HTTP Request, the HTTP Method.
 * The idea is to create an HTTP Request object which contains all the information about the request, except you have not made the HTTP Request.
 * Therefore, you can pass around this HTTP Request object and have some other code issued a request without knowing what the request is, without
 * knowing the details of that request because is already ready to be issued or executed.
 * 
 * API to get all messages by year:  /webapi/messages?year={year}
 * 
 * @author gecasti
 *
 */
public class InvocationDemo {
	
	public static void main(String[] args) {
		InvocationDemo demo = new InvocationDemo();
		
		// This invocation object is ready to be executed whenever and from this code or from some other code.
		Invocation invocation = demo.prepareRequestForMessagesByYear(2016);
		
		// This issues or executes the HTTP Request
		Response invocationResponse = invocation.invoke();
		System.out.println(invocationResponse.getStatus());
		System.out.println(invocationResponse.toString());
	}
	
	/**
	 * Builds the HTTP Request.
	 * 
	 * @param year
	 * @return
	 */
	public Invocation prepareRequestForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();
		
		/*
		 * Preparing the HTTP Request so it can be executed or issued whenever and from some other code.
		 * This returns a list of generic types; a list of messages in this case.
		 */
		return client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
					 .path("messages")
					 .queryParam("year", year)
					 .request(MediaType.APPLICATION_JSON)
					 .buildGet();
	}
}