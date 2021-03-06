package com.ccc.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ccc.messenger.model.ErrorMessage;

/**
 * Every exception in JAX-RS needs to implement the ExceptionMapper abstract interface class.
 * ExceptionMapper is a raw type, so you need to make it a generic type; the generic type is the exception that you want this
 * ExceptionMapper to map, which is your custom exception 'DataNotFoundException', that is going to be the generic type.
 * 
 * This custom exception mapper class uses the @Provider annotation to register itself with JAX-RS, so that JAX-RS knows that
 * this custom exception mapper is available, so when this messenger RESTful API throws an exception and it bubbles up to JAX-RS
 * JAX-RS looks at all the custom exception mappers annotated with @Provider and if it finds a method argument with the data type
 * of the thrown exception, hence mapping a custom exception to a response.
 * 
 * @author gecasti
 *
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
	
	/**
	 * Whenever you get an exception in messenger RESTful API class, JAX-RS is going to call this method
	 * passing the exception that was thrown and in this method you can write code to create the custom JSON response
	 * Therefore, here you prepare the custom JSON response and map it to the custom exception 'DataNotFoundException'
	 * so that Jersey can pass it back to the user, hence intercepting the exception before it bubbles up back to the user.
	 */
	@Override
	public Response toResponse(DataNotFoundException dnfe) {
		ErrorMessage errorMessage = new ErrorMessage(dnfe.getMessage(), 404, "http://www.motelife.co");
		
		return Response.status(Status.NOT_FOUND)
					   .entity(errorMessage)
					   .build();
	}
}