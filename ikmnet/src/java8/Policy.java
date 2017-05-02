package java8;

public class Policy {
	String name, type;
	public Policy(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
}