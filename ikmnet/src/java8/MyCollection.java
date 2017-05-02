package java8;

import java.util.Set;

class MyCollection<T> {
	private Set<T> set;
	public Set<T> getCollection() {
		return this.set;
	}
	
	public void TestCollection(MyCollection<?> collection) {
		Set set = collection.getCollection();
		Set<?> set1 = collection.getCollection();
	}
}