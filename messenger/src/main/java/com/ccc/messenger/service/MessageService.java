package com.ccc.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.ccc.messenger.dao.DatabaseClass;
import com.ccc.messenger.exception.DataNotFoundException;
import com.ccc.messenger.model.Message;

/**
 * A Service (stub) class to interact with the Data Access class (could use JDBC, JPA, Spring, Hibernate, etc).
 * 
 * Using an in memory Map to behave like a database, to support all the CRUD operations.
 * Create:  POST
 * Read:    GET
 * Update:  PUT
 * Delete:  DELETE
 * 
 * @author gecasti
 *
 */
public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hola Mundo!", "gibran"));
		messages.put(2L, new Message(2L, "Hola Jersey", "gibran"));
	}
	
	public List<Message> getAllMessages() {
		// Parsing a collection to the ArrayList constructor initialized the List with those elements!
		return new ArrayList<Message>(messages.values());
	}
	
	/**
	 * Filtering, in this case by year http://localhost:8080/messenger/webapi/messages?year=2016 
	 * 
	 * @param year
	 * @return
	 */
	public List<Message> getAllMessagesFilterByYear(int year) {
		List<Message> filteredMessagesByYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			
			if(cal.get(Calendar.YEAR) == year) {
				filteredMessagesByYear.add(message);
			}
		}
		
		return filteredMessagesByYear;
	}
	
	/**
	 * Pagination, in this case get 20 messages starting at index 9  http://localhost:8080/messenger/webapi/messages?start=10&size=20
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> paginatedMessageList = new ArrayList<Message>(messages.values());
		
		//Pagination validation
		if(start + size > paginatedMessageList.size()) {
			return new ArrayList<Message>();
		}
		
		//Do actual pagination
		return paginatedMessageList.subList(start, start + size);
	}
	
	/**
	 * The following implementation is the happy path
	 * public Message getMessage(long id) {
	 *     return messages.get(id);
	 * }
	 * 
	 * It returns null (HTTP status code 204 - No content) if no Message is found
	 * 
	 * @param id
	 * @return
	 */
	public Message getMessage(long id) {
		Message message = messages.get(id);
		
		if(message == null) {
			/*
			 * If we throw this custom exception without handling it, then the MessageService will throw this custom exception
			 * to the MessageResource (the calling class to this method) and if the MessageResource does not have anything to 
			 * handle this custom exception as well; therefore, MessageResource throws it up.  Hence the custom exception keeps
			 * bubbling up and JAX-RS in Jersey does not handle it either so the custom exception goes all the way up to the 
			 * Tomcat Servlet container, which has some default behavior when there are exceptions that get bubble up and the 
			 * default is to show the standard Tomcat error page for any exception.  We do not want to show HTML responses to a 
			 * ESTful API.  We want to create a custom JSON payload to show when there is an exception.  The way to prevent this is 
			 * by intercepting the bubbling up of the custom exception, we want the Jersey framework to intercept the bubbling up
			 * of the custom exception and return a JSON response so that the bubbling up of the custom exception does not go all
			 * the way up to the Tomcat Servlet container.  In order to do this you:
			 * 1.  Prepare the JSON response
			 * 2.  Map the JSON response to the custom exception so that we tell Jersey, when this custom exception is thrown
			 *     return the map JSON response.
			 * The concept or design is similar to mapping an URL pattern to a response, now we are mapping a custom exception to a response.
			 * 
			 */
			throw new DataNotFoundException("Message look up with message id " + id + " not found.");
		}
		
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}