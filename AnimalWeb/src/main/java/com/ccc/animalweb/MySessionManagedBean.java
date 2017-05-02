/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.animalweb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;

/**
 * Configuring web.xml to handle JSF HTTP Requests
 * web.xml is the main web configuration file.  Whereas faces-config.xml is the JSF configuration file.
 * @author gecasti
 */
@ManagedBean
@Named(value = "mySessionManagedBean")
@SessionScoped
public class MySessionManagedBean implements Serializable {
    private int number = new Random().nextInt();
    /**
     * Creates a new instance of MySessionManagedBean
     */
    public MySessionManagedBean() {
        
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
}