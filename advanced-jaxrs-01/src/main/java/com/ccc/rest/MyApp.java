package com.ccc.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This is not a REST Web Application, we are not using a web.xml nor a (Jersey) Servlet.  This is just a RESTful Application.
 * The way we configure and bootstrap the JAX-RS Application (RESTful Application) is by writing a Jersey Servlet in web.xml and this is how
 * 
 * 1. Defined an application (in this case MyApp.class which is not a web application) which extends javax.ws.rs.core.Application which tells Jersey that this is a JAX-RS Application
 *    In other words, the MyApp.class will bootstrap and handle the HTTP Request/Response.
 * 
 * 2. By default if you don't have the configuration to tell Jersey where are the Resource classes, then Jersey looks at all the classes in your classpath and if there is any class annotated
 *    with @Path then Jersey picks it up and processes it accordingly.  If you want to configure or tell Jersey where are the Resource classes you overwrite the
 *    public Set<Class<?>> getClasses() method in javax.ws.rs.core.Application.  The Set of classes you return in the getClasses() method are the only Resource classes that you want Jersey
 *    to look up and processes accordingly. 
 * 
 * 3. The URL mapping to your API is done by Annotating the define application (in this case MyApp.class) with @ApplicationPath("webapi") which says that any HTTP Request that comes to this
 *    RESTful Application that has /webapi/ in the front of the URI is handle by the defined application, in this case MyApp.class.  The Jersey Application of set up one maps to /webapi/* 
 *    so we know all of our RESTful Web Service APIs are exposed at /webapi/*
 * 
 * @author gecasti
 *
 */
@ApplicationPath("webapi")
public class MyApp extends Application {
	
}