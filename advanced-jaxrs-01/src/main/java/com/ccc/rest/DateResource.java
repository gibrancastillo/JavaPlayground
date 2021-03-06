package com.ccc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Param (Annotation) Converters
 * =============================
 * Jersey comes with a set of bundled Param Converters that know how to convert to the right data type for some of the native data types; for example, from a String in the URL to a 'long'
 * or 'int' or 'String' data type.  But let's say you have your own data type that you need convert from String in the URL to your data type so Jersey won't be able to do the conversion,
 * because Jersey has no idea how to convert from a String to your custom data type.  This is where creating your own Param (Annotation) Converters helps, so you can create your own Param
 * Converters that handles that conversion.
 * 
 * For creating or implementing a Param (Annotations) Converter we need our custom data type that the Param Converter converts from String to your data type.  Sample custom data type:
 * public class MyDate {
 *     private int date;
 *     private int month;
 *     private int year;
 * }
 * 
 * So I want to convert from a String date in URL API call to MyDate object.  Here are the RESTful Application APIs that will be call:
 * <> http://localhost:8080/advanced-jaxrs-01/webapi/date/{datePathParam}
 * <> http://localhost:8080/advanced-jaxrs-01/webapi/date/today
 * <> http://localhost:8080/advanced-jaxrs-01/webapi/date/tomorrow
 * <> http://localhost:8080/advanced-jaxrs-01/webapi/date/yesterday
 * 
 * 
 * @author gecasti
 *
 */
@Path("date/{dateString}")
public class DateResource {
	
	/**
	 * Jersey's Param Converter is able to convert the "dateString" path param String variable value to a String object; however, if you replace '@PathParam("dateString") String dateString'
	 * with '@PathParam("dateString") MyDate myDate' then Jersey at compile time would throw a ModelValidationException at front and it won't even start the application because it knows that
	 * there is this path param annotation on a custom data type (in this case MyDate) and at some point of time Jersey has to do the conversion from String to the custom data type and it
	 * doesn't know how.  To set up the Param conversion to happen with custom data types you have to let Jersey know how to do this conversion,  you need to use the following classes:
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
	 * @param dateString
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateString") MyDate myDate) {
		return "I Got " + myDate;
	}
}