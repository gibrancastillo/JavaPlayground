package com.ccc.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ccc.messenger.model.Message;

public class RestApiClient {
	
	public static void main(String[] args) {
		/*
		 * JAX-RS provides the javax.ws.rs.client.Client interface to build and make 'fluent' REST Web Service API calls.
		 * YOu need to ask JAX-RS for an implementation of Client, to do that is by using javax.ws.rs.client.ClientBuilder.
		 */
		Client client = ClientBuilder.newClient();
		
		/*
		 * Build and make 'fluent' REST Web Service API calls
		 * 1. Specify the target URL endpoint
		 * 2. Build an HTTP Request using appropriate HTTP Method.
		 * 3. Capture HTTP Response in JAX-RS javax.ws.rs.core.Response object.
		 */
		// Using method chaining
		/*Response response = client
				.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1")
				.request()
				.get();
		
		// To get the JSON message from the response you use the readEntity method and pass the class you are expecting as a response, in this case Message.class
		//Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());
		*/
		
		/*
		 * The .request() takes the media type you want the REST API to produce; therefore, this value is added to the HTTP Header 'Accept = application/json' in the HTTP Request
		 * The .get() has several signatures, one of them allows you to pass the class or data type you expect the HTTP Response
		 */
		/*Message message = client
				.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(message.getMessage());
		*/
		
		/*
		 * Since you are passing a String.class to the .get() method, then JAX-RS is going to convert the HTTP Response payload into it's original format, in this case a JSON message.
		 * This is very handy for debugging because the REST API Client becomes an app like Postman
		 */
		/*String message = client
				.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		System.out.println(message);*/
		
		// Using WebTarget, Builder and Response
		/*WebTarget target = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1");
		Builder request = target.request();
		Response response = request.get();*/
		
		/*
		 * The following are Best Practices for REST API clients, not necessary but useful.
		 * They are recommended ways of managing your target instances in your REST API Client.
		 * 1. Create a Base or Root URL client target, which is your root context
		 * 2. Create a List of messages path, to get all the messages.
		 * 3. Create a single message path, to get a specific message.
		 */
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message1 = singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());
		
		
		/*
		 * Making a POST HTTP Request to create a new message
		 */
		Message newMessage = new Message(4, "My New Message from JAX-RS Client", "gigi");
		Response postResponse = messagesTarget
				.request()
				.post(Entity.json(newMessage));
		
		// Examine the HTTP status code and act accordingly
		if(postResponse.getStatus() != 201) {
			System.out.println("Error");
		} else {
			System.out.println(postResponse);
			// To get the JSON message from the response you use the readEntity method and pass the class you are expecting as a response, in this case Message.class
			Message createdMessage = postResponse.readEntity(Message.class);
			System.out.println(createdMessage.getMessage());
		}
		
		/*
		 * Making a PUT HTTP Request to update an existing message
		 */
		Message updateMessage = new Message(4, "My Updated Message from JAX-RS Client", "gigi");
		Response putResponse = singleMessageTarget
				.resolveTemplate("messageId", "4")
				.request()
				.put(Entity.json(updateMessage));
		
		System.out.println(putResponse);
		// To get the JSON message from the response you use the readEntity method and pass the class you are expecting as a response, in this case Message.class
		Message updatedMessage = putResponse.readEntity(Message.class);
		System.out.println(updatedMessage.getMessage());
		
	}
}