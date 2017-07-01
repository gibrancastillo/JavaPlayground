package com.ccc.arraylist;

/**
 * List Abstract Data Type (ADT), defines a data type in terms of a type and set of operations on that type.
 * 
 * @author Gibran E. Castillo
 *
 */
public interface List {
	public void clear();
	public void insert(Object it);
	public void append(Object it);
	public Object remove();
	public void setFirst();
	public void next();
	public void previous();
	public int length();
	public void setPosition(int position);
	public void setValue(Object it);
	public Object currentValue();
	public boolean isEmpty();
	public boolean isCurrInList();
	public void print();
}