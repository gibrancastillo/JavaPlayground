package com.ccc.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST APIs are stateless, this means that the RESTful application running on the server does not maintain any state, it does not maintain information
 * that persist across multiple request.  In other words, the client and the server do not remember any previous interaction between each other; therefore,
 * classic session-based authentication does not work for REST APIs.
 * 
 * The following are a list of some of the REST Web Service APIs stateless authentication mechanisms:
 * <> Basic Auth (Basic Access Authentication):  Every time the client sends an HTTP Request to the server, the client authenticates with the server.
 *                                               In other words, the client sends the username/password information.
 *    Client-Side
 *    The username/password are sent in the HTTP Header of the HTTP Request.  The way to do this is by following a specific protocol, you take the username
 *    and password and you concatenate them separated by a colon, like this "username:password" and then you do Base64 encoding on the "username:password"
 *    String and you get an encoded String "dXNIcm5hbWU6cGFzc3dvcmQ=".  You take this Base64 encoded String and in your HTTP Header of your HTTP Request you
 *    create a new header parameter with a key called "Authorization" and with a value "Basic dXNIcm5hbWU6cGFzc3dvcmQ="
 * 
 *    Server-Side
 *    The Server gets the HTTP Request and it examines the HTTP Header of the HTTP Request and the server finds the "Authorization" header and gets the value.
 *    The Server checks the first word of the value and it notices that it says 'Basic' so the server knows that this is Basic Auth and then it gest the second
 *    word, which is the Base64 encoded String 'dXNIcm5hbWU6cGFzc3dvcmQ=' and the server does Basic64 decoding to get "username:password" and then the server
 *    can do a match for the username and password.
 *    
 *    Note that Base64 encoding and decoding is not encryption; the Base64 encoded String is not secure; therefore, when using Basic Auth you always
 *    use the HTTPS protocol to send the HTTP Request, so the username/password are protected.
 *    Security is not the intent of the encoding step.  Rather, the intent of the encoding is to encode non-HTTP-compatible characters that may be in the username
 *    and/or password into those that are HTTP-compatible.
 *    
 *    Advantages:  Simple, Stateless server, and supported by all web browsers
 *    Disadvantages:  Requires HTTPS, Subject to replay attacks, "Logout" is tricky (Browser caching)
 * 
 * <> Digest Access Authentication:  This actually does encryption off a secret key that's being sent in the HTTP Header of the HTTP Request.  It does not use
 *                                   username and password, instead it has a secret id
 *                                   
 * <> Asymmetric Cryptography:  This is the public key cryptography, there is a public key and a private key (digital pen)
 * 
 * <> OAuth:  1.0 and 2.0 are very different, but this REST Web Service API stateless authentication is gaining a lot of popularity.
 * 
 * <> JSON Web Tokens:  
 * 
 * 
 * @author gecasti
 *
 */
@Path("secured")
public class SecuredResource {
	
	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	public String securedMethod() {
		return "This API needs login";
	}
}