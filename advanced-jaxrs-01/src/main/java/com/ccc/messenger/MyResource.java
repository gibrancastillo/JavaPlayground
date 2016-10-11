package com.ccc.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 * 
 * http://localhost:8080/messenger/
 * http://localhost:8080/messenger/webapi/myresource
 * <> Web Server:  Apache Tomcat, a pure Java HTTP web server
 *    - Catalina:  Servlet Container and JSP Container
 *    - Coyote:  Connector component that supports HTTP 1.1 protocol as a web server.
 *    - Jasper:  JSP Engine. Jasper parses JSP files to compile them into Java code as servlets (that can be handled by Catalina). 
 * <> Protocol:  HTTP
 * <> Hostname:  localhost
 * <> Port:  8080
 * <> Application-Context:  messenger, which is the maven project
 * <> REST API:  webapi
 * <> Resource Based URI:  myresource, this maps to the code that you write, a Resource class.
 * 
 * + Tomcat web server:  http://localhost:8080
 * + URL to access web app messenger:  http://localhost:8080/messenger/
 * + HTTP Request using HTTP Method GET
 * 
 * A RESTful Web App or a REST API Web App is just a standard Servlet Web Component or Web App.
 * 
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
