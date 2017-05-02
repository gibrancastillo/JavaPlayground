/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.animalweb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
//import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author gecasti
 */
@ManagedBean
@Named(value = "myApplicationManagedBean")
@ApplicationScoped
public class MyApplicationManagedBean {

    /**
     * Creates a new instance of MyApplicationManagedBean
     */
    public MyApplicationManagedBean() {
    }
    
}
