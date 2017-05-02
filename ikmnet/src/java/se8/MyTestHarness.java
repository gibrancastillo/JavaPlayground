package java.se8;

public class MyTestHarness {
	public void writeString() {
		//object creation
		MySuper object = new MySuper();
		System.out.println(object.buildString("0,"));
	}
	
	public static void main(String[] args) {
		new MyTestHarness().writeString();
	}
}