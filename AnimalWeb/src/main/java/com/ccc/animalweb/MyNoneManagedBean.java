/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.animalweb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.inject.Named;

/**
 * The lifetime (how long it survives) of a None scope manage bean is as long as
 * the referencing bean survives.
 * 
 * @author gecasti
 */
@ManagedBean
@Named(value = "myNoneManagedBean")
@NoneScoped
public class MyNoneManagedBean {
    
}