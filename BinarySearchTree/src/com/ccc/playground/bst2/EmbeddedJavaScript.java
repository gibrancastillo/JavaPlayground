package com.ccc.playground.bst2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EmbeddedJavaScript {

	public static void main(String[] args) throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		System.out.println("engine = " + engine);
		try {
			engine.eval(
			   "var i=0;"
			 + "i++;"
			 + "var String = Java.type(\"java.lang.String\");"
			 + "var str = new String(\"Java\");"
			 + "print(str);"
			 + "print(i);"
			);
		} catch (ScriptException se) {
			System.out.println("Script Exception");
		}
	}
}