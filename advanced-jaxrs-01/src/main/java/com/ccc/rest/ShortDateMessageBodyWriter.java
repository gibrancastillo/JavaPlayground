package com.ccc.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * In order to register this class as a custom MessageBodyWriter for JAX-RS we annotate the class with @Provider to this class.
 * 
 * You need to identify the custom media type(s) this custom MessageBodyWriter can handle as identify in the @Producer media type by annotating this class with @Produces
 * 
 * @author gecasti
 *
 */
@Provider
@Produces("text/shortdate")
public class ShortDateMessageBodyWriter implements MessageBodyWriter<Date> {
	
	/**
	 * A deprecated method, don't have to implement it.  The recommended best practice is to just return -1.
	 */
	@Override
	public long getSize(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}
	
	/**
	 * This method is an implementation that you write to let Jersey know if a certain type of something that this writer can handle
	 */
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Date.class.isAssignableFrom(type);
	}
	
	/**
	 * This writes the data that will go into the HTTP Response message body
	 */
	@Override
	public void writeTo(Date date,
			Class<?> type,
			Type genericType,
			Annotation[] annotations,
			MediaType mediaType,
			MultivaluedMap<String, Object> multiValueMap,
			OutputStream out) throws IOException, WebApplicationException {
		
		String shortDate = date.getDate() + "-" + date.getMonth() + "-" + date.getYear();
		
		out.write(shortDate.getBytes());
	}	
}