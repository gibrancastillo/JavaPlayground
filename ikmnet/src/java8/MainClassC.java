package java8;

class MainClassA {

	public static void main(String[] args) {
		System.out.println("Class A " + args[0]);
	}
}

class MainClassB {
	public static void main(String[] args) {
		System.out.println("Class B");
		MainClassA.main(args);
	}
}