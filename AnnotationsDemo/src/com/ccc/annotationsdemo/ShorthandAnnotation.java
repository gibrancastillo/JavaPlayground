package com.ccc.annotationsdemo;

public @interface ShorthandAnnotation {
	// Shorthand notation for value element
	String[] value();
	String author() default "Enrique Castillo";
}