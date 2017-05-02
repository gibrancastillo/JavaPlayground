package java8;

public class PolicyTest {

	public static void main(String[] args) {
		Policy[] policies = {new Policy("Smith", "Internal"), new Policy("Doe", "External"), new Policy("John", "Internal")};
		
		/*for(int i = 0; i < 1; i++) {
			if(policies[i].getType().equals("Internal")) {
				System.out.println(policies[i].getName());
			}
		}*/
		
		for(Policy nextPolicy : policies) {
			if(nextPolicy.getType().equals("Internal")) {
				System.out.println(nextPolicy.getName());
				//break;
			}
		}
	}
}