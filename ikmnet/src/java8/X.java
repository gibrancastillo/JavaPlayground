package java8;

class X {
	String s;
	public X(String s) { this.s = s; }
	@Override public String toString() { return s.toLowerCase(); }
	public String toLowerCase() { return s.toLowerCase(); }
}