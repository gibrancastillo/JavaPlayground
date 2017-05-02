package java8;

import java.util.SortedSet;
import java.util.TreeSet;

public class IkmTest7 {

	public static void main(String[] args) {
		SortedSet<Element> s = new TreeSet<Element>();
		s.add(new Element(15));
		s.add(new Element(10));
		s.add(new Element(25));
		s.add(new Element(10));
		System.out.println(s.first() + " " + s.size());
	}
}