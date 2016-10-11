package com.ccc.messenger.exception;

/**
 * Extending RuntimeException because we want this exception to be a runtime exception
 * 
 * Exception Handling in JAX-RS via Jersey
 * 
 * If we throw this custom exception in a Service class like MessagService without handling it, then the MessageService will throw this custom exception to the
 * MessageResource (the calling class) and if the MessageResource does not have anything to handle this custom exception as well; therefore, MessageResource throws it up.
 * Hence the custom exception keeps bubbling up and JAX-RS in Jersey does not handle it either so the custom exception goes all the way up to the Tomcat Servlet container,
 * which has some default behavior when there are exceptions that get bubble up and the default is to show the standard Tomcat HTML error page for any exception.  We do not
 * want to show HTML responses to a RESTful API.  We want to create a custom JSON payload to show when there is an exception.  The way to prevent this is by intercepting the
 * bubbling up of the custom exception, we want the Jersey framework to intercept the bubbling up of the custom exception and return a JSON response so that the bubbling up
 * of the custom exception does not go all the way up to the Tomcat Servlet container.  In order to do this you:
 * 1.  Prepare the JSON response
 * 2.  Map the JSON response to the custom exception so that we tell Jersey, when this custom exception is thrown return the map JSON response.
 * The concept or design is similar to mapping an URL pattern to a response, now we are mapping a custom exception to a response.
 * The way we map exceptions to responses in JAX-RS via Jersey is by using a class call ExceptionMapper  
 * 
 * @author gecasti
 *
 */
public class DataNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4272978096651713812L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
}