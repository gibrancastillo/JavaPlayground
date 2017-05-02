package java8;

public class MyClass {
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		Class c = myClass.getClass();
		
		try {
			System.out.println(c.getMethod("getNumber", null).toString());
			System.out.println(c.getDeclaredMethod("setNumber", null).toString());
		} catch(NoSuchMethodException | SecurityException e) {}
	}
	
	public Integer getNumber() {
		return 2;
	}
	
	public void setNumber(Integer n) { }
}