package java8;

class Y<T> {
	T s;
	public Y(T s) { this.s = s; }
	@Override public String toString() { return s.toString(); }
}