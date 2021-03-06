package com.ccc.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ccc.messenger.model.Comment;
import com.ccc.messenger.service.CommentService;

/**
 * This is a sub-resource based class use by root resource(s).
 * The value in the @Path annotation at the class level is only going to have "/", no real value denoting that the path value to be use is the remainder
 * of the path coming from the root resource; in other words, if the user executed http://localhost:8080/messenger/webapi/messages/12/comments/1, then the
 * root resource method call was map with '/12/comments' and the remainder '1' would be pass to this sub resource to be use by the correct method in this
 * sub resource class based on the HTTP Request method and the method's @Path('{commentId}) map to the remainder of the path pass to this sub-resource class.
 * NOTE that the class level @Path annotation is optional for sub resources.
 * 
 * This design allows us to have separate APIs and separate resources so we don't put all of them in the parent or root resource, you can actually delegate
 * API calls in other sub resources.
 * 
 * 
 * @author gecasti
 *
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	/**
	 * The commentId is part of the remainder of the path pass on to this sub resource; however, this sub-resource has access to the messageId which is part of
	 * the parent or root resource annotation but since this is the call which actually lead to this method been executed, the messageId param is available to this method as well.	 
	 * 
	 * @param messageId
	 * @param commentId
	 * @return
	 */
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
}