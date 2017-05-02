/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.animalweb;

//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;

/**
 * A JSF Managed Bean class, managed beans are 'managed' by the container.
 * We do not manually create and destroy the bean.  We just use the beans while
 * being assured about the lifetime of the bean which will depend on the scope.
 * 
 * @author gecasti
 */
@ManagedBean
@Named(value = "myReqManagedBean")
@RequestScoped
public class MyRequestManagedBean {
    
    /**
     * Creates a new instance of MyRequestManagedBean
     */
    public MyRequestManagedBean() {
        
    }   
}