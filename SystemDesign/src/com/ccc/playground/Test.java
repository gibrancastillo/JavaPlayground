package com.ccc.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public final class Test {
    private Long myLong;
    private String myString;
    private final List<Integer> myCollection;
    
    public Test(Long myLong, String myString, List<Integer> myCollection) {
      this.myLong = myLong;
      this.myString = myString;
      this.myCollection = new ArrayList<>(myCollection);
    }
    
    public Long getMyLong() {
      return myLong;
    }
    
    public String getMyString() {
      return myString;
    }
    
    public List<Integer> getMyCollection() {
      return Collections.unmodifiableList(myCollection);
    }
    
    public static void main(String[] args) {
      Long theLong = 123L;
      String theString = "someString";
      List<Integer> testCollection = new ArrayList<>();
      testCollection.add(1);
      testCollection.add(2);
      
      Test theTest = new Test(theLong, theString, testCollection);
      
      System.out.println(theTest.getMyCollection());

      theTest.getMyCollection().add(3);
      
      System.out.println(theTest.getMyCollection());
    }
}