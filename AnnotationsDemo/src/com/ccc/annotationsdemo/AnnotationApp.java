package com.ccc.annotationsdemo;

import java.lang.annotation.Annotation;
import java.security.Provider;

import com.ccc.annotationsdemo.SimpleNote.Remark;

@SimpleNote(desc="Class to play with annotations",
			author="Gibran Casatillo",
			length=12,
			name="Gibran Castillo",
			skills={"code", "test"},
			provider=Provider.class,
			remark=Remark.EXCELLENT)
@ShorthandAnnotation(value={"unit", "integration"})
public class AnnotationApp {
	
	@SimpleNote(desc="Method to play with annotations",
				length=12,
				name="Gibran Castillo",
				skills={"code", "test"},
				provider=Provider.class,
				remark=Remark.EXCELLENT)
	@ShorthandAnnotation({"unit", "integration"})
	public void someMethod(int param1) {
		
	}
	
	public static void main(String[] args) {
		/*
		 * NOTE that annotations processing are usually done by frameworks (like JAX-RS, JPA, Spring, Hibernate, etc.)
		 * Developers job revolve around using the annotations provided by the different tools and frameworks and not actually processing those annotations
		 * 
		 * But to show how annotations are process, the code below is use for getting annotations on this AnnotationApp class.
		 */
		
		Class<AnnotationApp> c = AnnotationApp.class;
		Annotation[] allAnnotations = c.getAnnotations();
		
		for(Annotation annotation : allAnnotations) {
			if(annotation instanceof SimpleNote) {
				SimpleNote simpleNote = (SimpleNote) annotation;
				System.out.println("On class annotations: " 
						+ "desc=" + simpleNote.desc()
						+ " author=" + simpleNote.author()
						+ " length=" + simpleNote.length()
						+ " name=" + simpleNote.name());
			}
		}
		
		
		// The code below is use for getting annotations on the someMetho() in the AnnotationApp class.
		try {
			Annotation[] someMethodAnnotations = c.getDeclaredMethod("someMethod", Integer.TYPE).getAnnotations();
			
			for(Annotation annotation : someMethodAnnotations) {
				SimpleNote simpleNote = (SimpleNote) annotation;
				System.out.println("On method annotations: " 
						+ "desc=" + simpleNote.desc()
						+ " author=" + simpleNote.author()
						+ " length=" + simpleNote.length()
						+ " name=" + simpleNote.name());
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}