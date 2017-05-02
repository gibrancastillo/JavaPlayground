package java8;

public class ForLoop {
	public static void main(String[] args) {
		int j = 0;
		int a[] = {2, 4};
		do for (int i : a)
			System.out.print(i + " ");
		while(j++ < 1);
	}
}