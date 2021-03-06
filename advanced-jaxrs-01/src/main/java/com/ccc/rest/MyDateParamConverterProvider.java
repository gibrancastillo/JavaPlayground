package com.ccc.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * In order to register this class as a custom ParamConverterProvider for JAX-RS we annotate the class with @Provider to this class.
 * 
 * To set up the Param conversion to happen with custom data types you have to let Jersey know how to do this conversion,  you need to use the following classes:
 * 
 * <> ParamConverter - use whenever you need to convert any of the Jersey Param Annotations from String to a custom data type, to do that, you need to implement a ParamConverter.
 *                     It is an interface that has methods to convert from a String to your custom data type using 'T fromString(String value)', T for Data Type Instance; therefore, you
 *                     have to write the logic to convert from a String to your custom data type and this becomes your custom param converter.  Next you need implement another interface
 *                     called the ParamConverterProvider.
 *                     + A custom param converter that does the actual conversion from String to custom data type.
 *                     
 * <> ParamConverterProvider - is a provider class which tells Jersey to use your your custom param converter given the custom data type.  It basically tells Jersey that whenever it sees
 *                             any param annotation on the custom data type (in this case MyDate) you use the custom param converter that the developer already implemented
 *                             ParamConveter getConverter(Class rawType, ...)
 *                             + A provider that maps the custom data type to the custom param converter
 * 
 * @author gecasti
 *
 */
@Provider
public class MyDateParamConverterProvider implements ParamConverterProvider {
	
	/**
	 * These three parameter in the method arguments (Class<T> rawType, Type genericType, Annotation[] annotations) are what Jersey sends to the
	 * ParamConverterProvider to see if it can provide the custom ParaConverter back so it sends the 'rawType', which is the custom data type, it sends the generic type
	 * in case you are dealing with a custom generic data type and it also sends a list of annotations, so this is an area of annotations so in the case of a @PathParam
	 * then a @PathParam would be one of the annotations in the list of annotations
	 */
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			// Return the right custom param converter.  The following is anonymous inner class
			return new ParamConverter<T>() {
				
				@Override
				public T fromString(String value) {
					Calendar requestedDate = Calendar.getInstance();  // Today's date
					
					if(value.equalsIgnoreCase("tomorrow")) {
						requestedDate.add(Calendar.DATE, 1);
					} else if(value.equalsIgnoreCase("yesterday")) {
						requestedDate.add(Calendar.DATE, -1);
					}
					
					MyDate myDate = new MyDate();
					myDate.setDate(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH));  // Calendar.MONTH is zero index, so Calendar.MONTH 0 is January.
					myDate.setYear(requestedDate.get(Calendar.YEAR));
					
					return rawType.cast(myDate);
				}
				
				@Override
				public String toString(T myBean) {
					if(myBean == null) {
						return null;
					}
					
					return myBean.toString();
				}
			};
		}
		
		return null;
	}
}