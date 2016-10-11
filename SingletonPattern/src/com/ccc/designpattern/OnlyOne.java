package com.ccc.designpattern;

/**
 * A singleton is a class that can be implemented "only one time in a JVM per class loader".
 * Repeated calls always return the same instance.
 * Singleton ensures that a class has only one instance, and provide a "global point of access".
 * It can be an issue if singleton class gets loaded by multiple class loaders or JVMs.
 * 
 * Class loaders are hierarchical. Classes are introduced into the JVM as they are referenced by name in a class that
 * is already running in the JVM. So, how is the very first class loaded? The very first class is especially loaded with
 * the help of static main( ) method declared in your class. All the subsequently loaded classes are loaded by the
 * classes, which are already loaded and running. A class loader creates a namespace. All JVMs include at least one
 * class loader that is embedded within the JVM called the primordial (or bootstrap) class loader. Now let’s look at
 * non-primordial class loaders. The JVM has hooks in it to allow user defined class loaders to be used in place of
 * primordial class loader. Let us look at the class loaders created by the JVM.
 * 
 * Bootstrap (primordial) class loader:  Not reloadable, loads JDK internal classes, java.* packages. (as defined in the sun.boot.class.path system property, typically loads rt.jar and i18n.jar)
 * Extensions class loader:  Not reloadable, loads jar files from JDK extensions directory (as defined in the java.ext.dirs system property – usually lib/ext directory of the JRE)
 * System class loader:  Not reloadable, loads classes from system classpath (as defined by the java.class.path property, which is set by the CLASSPATH environment variable or –classpath or –cp command line options)
 * 
 * @author gecasti
 *
 */
public class OnlyOne {
	private static OnlyOne one = new OnlyOne();
	
	/**
	 * With a private constructor you prevent subclassing and this class cannot be instantiated from outside.
	 */
	private OnlyOne() { }
	
	public static OnlyOne getInstance() {
		return one;
	}
}