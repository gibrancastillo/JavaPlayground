package com.ccc.annotationsdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations by default are retain (available) at runtime and are made available to classes, methods, parameters, constructors, Enums, Interfaces and all the other programming element types.
 * <> To restrict or disallowed annotations to just classes or methods, you have to use the annotation java.lang.annotation.Target within your annotation class.
 * <> To control how long annotations are retain (available) you can use the annotation java.lang.annotation.Retention within your annotation class.
 *      - @Retention(RetentionPolicy.SOURCE)  Only available in source code.  Not available in compiled class file.
 *      - @Retention(RetentionPolicy.CLASS)   Only available till compilation.  Not available at runtime.
 *      - @Retention(RetentionPolicy.RUNTIME) Annotation object available at runtime.
 * 
 * @author gecasti
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleNote {
	/*
	 * Annotation element types that can be use:
	 * - Primitive types:  byte, short, int, float, double, char and boolean
	 * - java.lang.String
	 * - java.lang.Class
	 * - Enum type
	 * - Annotation type
	 * - Array of any of the above type eg:  String[], int[],...
	 */
	
	String desc();
	String author() default "Enrique Castillo";
	
	int length();
	String name();
	String[] skills();
	Class provider();
	
	// Enum type
	Remark remark();
	
	public enum Remark {
		POOR_CODING, SATISFACTORY, EXCELLENT, INCORRECT, INCOMPLETE
	};
	
	
}