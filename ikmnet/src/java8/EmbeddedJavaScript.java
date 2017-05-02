package java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EmbeddedJavaScript {
	
	public static void main(String[] args) {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("nashorn");
		
		try {
			engine.eval(
				"var i=0;"
			  + "i++;"
			  + "var String = Java.type(\"java.lang.String\");"
			  + "var str = new String(\"Java\");"
			  + "print(str);"
			  + "print(i);"
			);
		} catch(ScriptException se) { System.out.println("Script Exception"); }
	}
}