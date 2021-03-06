package com.ccc.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.ccc.messenger.model.Message;

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
public class GenericDemo {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		List<Message> messages = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
					 .path("messages")
					 .queryParam("year", 2016)
					 .request(MediaType.APPLICATION_JSON)
					 .get(new GenericType<List<Message>>() { });  // an inline implementation
		
		System.out.println(messages);
	}
}