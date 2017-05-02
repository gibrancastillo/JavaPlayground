package java8;

/*public class Account<T> {
	private T accountType;
	public void add(T newType) { accountType = newType; }
	public T get() { return accountType; }
}*/

public class Account<S> {
	private S accountType;
	public void add(S newType) { accountType = newType; }
	public S get() { return accountType; }
}