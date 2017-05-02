package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		String[] a = { "A", "D", "B", "E", "C"};
		List<String> l = Arrays.asList(a);
		Collection<String> c = (Collection<String>) getCollection(l);
		for(String s : c)
			System.out.print(s);
	}
	
	static public <E extends CharSequence> Collection<? extends CharSequence> getCollection(Collection<E> c) {
		Collection<E> t = new TreeSet<E>();
		for(E e : c)
			t.add(e);
			return t;
	}
	
	/*static <E extends CharSequence> Collection<E> getCollection(Collection<E> c) {
		Collection<E> t = new TreeSet<E>();
		for(E e : c)
			t.add(e);
			return t;
	}*/
}