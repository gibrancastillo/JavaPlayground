/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.animalweb;

import java.util.Random;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * The lifetime (how long it survives) of a View scope manage bean is as long as
 * the user stays on the same view (page).
 * 
 * @author gecasti
 */
@ManagedBean
@Named(value = "myViewManagedBean")
@ViewScoped
public class MyViewManagedBean {
    private int number = new Random().nextInt();
    
    /**
     * Creates a new instance of MyViewManagedBean
     */
    public MyViewManagedBean() {
        
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
}