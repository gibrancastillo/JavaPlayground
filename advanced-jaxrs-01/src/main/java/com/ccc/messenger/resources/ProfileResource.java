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

import com.ccc.messenger.model.Profile;
import com.ccc.messenger.service.ProfileService;

/**
 * This is a RESTful Web Service
 * 
 * Web Services
 * ============
 * The exchange of data happens over the Web via the HTTP protocol.  The HTTP exchanges is as follows:  The Client sends an HTTP Request to the Server and when the Server is done
 * processing the HTTP Request, it sends an HTTP Response back to the Client.  This flow is similar to the websites; however, for Web Services the HTTP Response instead of containing
 * HTML, CSS and JavaScript formatting/styling for a website, it only return the data (XML or JSON) for the Client (a program, not a human).
 * 
 * The HTTP Protocol is the Message Format that the Client and the Server can understand.
 * 
 * Service Definition:  need to know the name of the class, the methods available, the methods arguments, the return type; in other words, you need to know about the API.  This concept
 * applies for Web Services, you need to know what the Web Service you are calling does, the operations, method argument, return type.  In other words, is a definition about the web service.
 * 
 * 
 * Web Services Types:
 *  * <> SOAP Web Service, Simple Object Access Protocol (name is discontinue but we are stuck with the acronym) that uses the SOAP protocol in the XML format with rules that detail
 * the structure and contents of the XML.  Messages are only exchange in HTTP Method POST.  The Service Definition use in SOAP Web Services is WSDL, is a document that defines what the
 * 	SOAP Web Service does.  It has all the details, the methods, return type, arguments, etc.  SOAP Web Services follow the SOAP Web Service Specification, basically a set of rules that 
 * dictate what every SOAP Web Service should be.  If a SOAP Web Service does not follow one of the SOAP Web Service Specification rules, is by definition not a SOAP Web Service.
 * 
 * 
 * 
 * <> REST Web Service, modern and lightweight and uses a lot of concepts behind HTTP which is the protocol use by the web.  REST Web Services has no protocol or no rules, it can send/receive
 * messages in XML, JSON or text format, as long as the Client and Server understand each other.  Messages can be exchange in any or all HTTP Methods (GET, POST, PUT, DELETE, etc.).  There
 * are some guidelines on which HTTP method to use depending on the operation you are trying to execute, but there are no rules.  There is little to no Service Definition in REST Web Services.
 * WADL is not a very popular service definition for REST Web Services.  Nowadays, those who want others to use their REST Web Services they create an API website with instructions on how
 * to call their REST Web Services (APIs).  RESTful Web Services do NOT have Specifications, it is a concept, is an idea.  Roy Fielding introduce the term REST, back in 2000.  Furthermore, 
 * Roy Fielding is one of the authors of the HTTP specification; therefore, REST Web Services make good use of the HTTP protocol.
 * 
 * - REpresentational State Transfer, it is not about Web Services at all; instead, it is an architecture style about the decisions and choices you have to make and the criteria and constraints
 *                                    you have to take into account.  It is a set of guidelines that work together.  When you apply the REST architecture guidelines for implementing/creating
 *                                    web services, then the Web Services become RESTful Web Services.
 * 
 * Therefore, depending how closely you follow the REST architecture style and guidelines to implement/create web services will determine how RESTful are your Web Services:
 * + Not RESTful Web Services
 * + Not fully RESTful Web Services
 * + Completely or Fully RESTful Web Services
 * 
 * To determine how RESTful are your REST Web Service APIs you can use 'The Richardson Maturity Model':
 * Level 0
 * -------
 * Not a RESTful Web Service API.  Also known as 'Swamp of POX' (Plain Old XML).  Everything is define in the XML document; therefore, there is not use of the HTTP concepts.
 * For a SOAP Web Service there is only One URL, the message or request body contains all the details (the operation that needs to be perform [create, remove, create, update, etc] and
 * the data that is needed for the operation).  Since the action is part of the request body, then one URL works.
 * 
 * Level 1
 * -------
 * Web Services at this level use a Resource URI, which is the starting level for a RESTful Web Service API.
 * Individual Resource URIs are use for each resource; for example, message request going to one URI, comment request going to another URI, profile request going to another URI, etc.
 * 
 * Level 2
 * -------
 * Web Services at this level comply with Level 1 and utilize different standard HTTP Request Methods (GET, POST, PUT, DELETE, etc) depending on the operation executed in the Resource URI.
 * The Resource URI specifies the resource that is being operated upon and the HTTP Request Method specifies what that operation is.  Furthermore, Web Services at this level make better use
 * of the HTTP status codes and the right use of Idempotence (repeatable HTTP Request Methods) and Non-Idempotence (HTTP Request Methods that cannot be repeated safely).
 * 
 * Level 3
 * -------
 * Web Services at this level comply with Level 2 and implement HATEOAS where the HTTP Responses have links (hypertext or hyperlinks or hypermedia) that control the application state
 * for the client; therefore, the client does not have to be aware of the different RESTful Web Service APIs
 * 
 * 
 * 
 * The main factor to think about when designing a RESTful Web Service API is to make it easy for the consumer, clients and developer to maintain. 
 * 
 * - Hyper Text Transfer Protocol, hypertext is a structure form of text which contains logical links to other text, these links are call hyperlinks.
 * 
 * - Resource Locations, REST Web Service APIs use Resource Based addresses (URLs), they just indicate the resource and are independent of the Server side implementation.  Web Apps and
 *                       Websites use are Action Based addresses (URLs).  Therefore, a good RESTful Web Service API makes good use of HTTP Methods using Resource Based addresses.
 *                       Resource locations are Resource URIs
 * 
 * - Metadata, a REST Web Service API tell the client the address to use to call the resource based address and the HTTP method to use in the call.  HTTP also defines HTTP Status Codes,
 *             HTTP response headers (content type like text/xml or application/json) to go along with the HTTP Response, so you don't just get the data (XML or JSON) but also the HTTP Status
 *             code and the response header.  Moreover, the same REST Web Service API can return in data in XML or JSON depending on who the client is and what the client is... depends 
 *             on 'Content Negotiation'.
 * 
 * - Resource relations are Resource URIs.
 * 		one to many relationship you choose to have the one side of the relationship to be the root resource and then the resource on the many size that follow it.
 * 		What about many to many relationships or one to one relationships?
 * 
 * 		The following are 'Instance Resource URIs', a single instance of a message or a comment because they typically have a unique id of the resource in the URI to identify the
 *      resource you are interested.  Like getting a message.
 * 		first level entity --> /profiles/{profileName}
 * 		first level entity --> /messages/{messageId}
 * 		Messages are not related to Profiles, because Messages are posted by someone with a Profile, so there is a one to many relationship between Profiles and Messages.  A profile user
 *      can have one or more messages.
 * 
 * 		comments are second level entities in relation to messages --> /messages/{messageId}/comments/{commentId}
 * 		likes are second level entities in relation to messages --> /messages/{messageId}/likes/{likeId}
 * 		shares are second level entities in relation to messages --> /messages/{messageId}/shares/{shareId}
 * 
 * - Collection URIs
 * 	    The following are 'Collection Resource URIs', a list of messages or a list of comments
 * 		represents all profiles --> /profiles
 * 		represents all messages --> /messages
 * 		represents all the comments for {messageId} --> /messages/{messageId}/comments
 * 		represents all the likes for {messageId} --> /messages/{messageId}/likes
 * 		represents all the shares for {messageId} --> /messages/{messageId}/shares
 * 		
 * 		How about all the comments for all messages (not for a particular {messageId})?
 * 		Would have work --> /comments
 * 		Will not work --> /messages/{messageId}/comments
 * 		This is why a decision has to be made on how you want the Resources to be access.
 * 
 * When you make REST Web Service API calls you are sending (HTTP Request) or receiving (HTTP Response), that is, transferring the 'Representational State' of the resource.
 * 
 * @author gecasti
 *
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getMessage(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	/**
	 * You can use the HTTP Method POST to perform an update operation; however, the standard practice is to use the HTTP Method PUT.  HTTP Method POST is use for creating a new resource.
	 * Therefore, this method creates or adds a new profile.
	 * 
	 * @param profile
	 * @return
	 */
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
}