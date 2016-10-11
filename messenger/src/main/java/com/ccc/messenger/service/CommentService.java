package com.ccc.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ccc.messenger.dao.DatabaseClass;
import com.ccc.messenger.model.Comment;
import com.ccc.messenger.model.ErrorMessage;
import com.ccc.messenger.model.Message;

/**
 * 
 * @author gecasti
 *
 */
public class CommentService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		return new ArrayList<Comment>(comments.values());
	}
	
	//filtering - pending
	
	//pagination - pending
	
	/**
	 * JAX-RS and/or Jersey has no context or no information about the kind of exceptions your application (in this case messenger) could throw. it could be
	 * a custom exception, it could be a null pointer exception, but JAX-RS and/or Jersey don't really know what to do with it, perhaps because something that
	 * was requested was not found, it could be because it was a server error; so it's really hard to map an exception to an HTTP status code or to a response
	 * by default; therefore, JAX-RS relies on custom exception mappers.
	 * 
	 * However, JAX-RS has its own set of exceptions that it does map to HTTP status codes and responses and since JAX-RS knows what those exceptions are, you don't
	 * need to write a custom exception mapper for those exceptions JAX-RS knows how to handle.  JAX-RS already knows what the response for those exceptions should be.
	 * 
	 * A 'WebApplicationException' is an exception that Jersey via JAX-RS already knows how to handle
	 * 
	 * @param messageId
	 * @param commentId
	 * @return
	 */
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = null;
		Response response = null;
		Message message = messages.get(messageId);
		
		if(message == null) {
			errorMessage = new ErrorMessage("Message look up with message id " + messageId + " not found.", 404, "http://www.motelife.co");
			response = Response.status(Status.NOT_FOUND)
							   .entity(errorMessage)
							   .build();
			/*
			 * You don't need to create a custom JSON response and map it to custom exception mapper,
			 * Jersey via JAX-RS knows what to do using the WebApplicationException.  Out of the box.
			 */
			throw new WebApplicationException(response);
		}
		
		Map<Long, Comment> comments = message.getComments();
		//Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		
		if(comment == null) {
			errorMessage = new ErrorMessage("Comment look with comment id " + commentId + " in message id " + messageId + " not found.", 404, "http://www.motelife.co");
			response = Response.status(Status.NOT_FOUND)
							   .entity(errorMessage)
							   .build();
			/*
			 * You don't need to create a custom JSON response and map it to custom exception mapper,
			 * Jersey via JAX-RS knows what to do using the WebApplicationException.  Out of the box.
			 */
			throw new WebApplicationException(response);
		}
		
		return comment;
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		if(comment.getId() <= 0) {
			return null;
		}
		
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		return comments.remove(commentId);
	}
}