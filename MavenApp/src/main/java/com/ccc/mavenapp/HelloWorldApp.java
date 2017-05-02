/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.mavenapp;

/**
 *
 * @author gecasti
 */
public class HelloWorldApp {
    public String sayHello(String name) {
        return "Hello " + name;
    }
    
    public static void main(String[] args) {
        HelloWorldApp helloWorldApp = new HelloWorldApp();
        System.out.println(helloWorldApp.sayHello("Java EE!"));
    }
}