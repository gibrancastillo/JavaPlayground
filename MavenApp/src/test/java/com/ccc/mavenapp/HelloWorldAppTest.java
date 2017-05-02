/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.mavenapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gecasti
 */
public class HelloWorldAppTest {
    
    public HelloWorldAppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sayHello method, of class HelloWorldApp.
     */
    @Test
    public void testSayHello() {
        /*System.out.println("sayHello");
        String name = "";
        HelloWorldApp instance = new HelloWorldApp();
        String expResult = "";
        String result = instance.sayHello(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
        
        // arrange
        HelloWorldApp instance = new HelloWorldApp();
        String expResult = "Hello Java EE!";
        
        // act
        String result = instance.sayHello("Java EE!");
        
        // assert
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class HelloWorldApp.
     */
    /*@Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        HelloWorldApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
