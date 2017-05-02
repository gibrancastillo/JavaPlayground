/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.animalweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;

/**
 *
 * @author gecasti
 */
@ManagedBean
@Named(value = "animalManagedBean")
@RequestScoped
public class AnimalManagedBean {
    private String type;
    private String totalNo;
    private String password;
    private String textArea;
    private boolean mailMe;
    private int selectedPerson;
    private int[] selectedPeople;
    private List<Person> peopleList;
    
    private Person person = new Person(1, "Francisco");
    
    private List<String> colorList;
    private Map<String, String> colorMap;
    
    /*
     * The annotation @ManagedProperty is a very limited form of dependency injection.
     */
    @ManagedProperty(value="#{mySessionManagedBean}")
    private MySessionManagedBean mySessionManagedBean;
    
    @PostConstruct
    public void init() {
        colorList = new ArrayList<>();
        colorList.add("Red");
        colorList.add("Blue");
        colorList.add("Green");
        
        colorMap = new HashMap<>();
        colorMap.put("R", "Red");
        colorMap.put("B", "Blue");
        colorMap.put("G", "Green");
        colorMap.put("Y", "Yellow");
    }
    
    /**
     * Creates a new instance of AnimalManagedBean
     */
    public AnimalManagedBean() {
    }  
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getTotalNo() {
        return totalNo;
    }
    
    public void setTotalNo(String totalNo) {
        this.totalNo = totalNo;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getTextArea() {
        return textArea;
    }
    
    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }
    
    public boolean isMailMe() {
        return mailMe;
    }
    
    public void setMailMe(boolean mailMe) {
        this.mailMe = mailMe;
    }
    
    public int getSelectedPerson() {
        return selectedPerson;
    }
    
    public void setSelectedPerson(int selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
    
    public int[] getSelectedPeople() {
        return selectedPeople;
    }
    
    public void setSelectedPeople(int[] selectedPeople) {
        this.selectedPeople = selectedPeople;
    }
    
    public MySessionManagedBean getMySessionManagedBean() {
        return mySessionManagedBean;
    }
    
    public void setMySessionManagedBean(MySessionManagedBean mySessionManagedBean) {
        this.mySessionManagedBean = mySessionManagedBean;
    }
    
    public List<Person> getPeopleList() {
        // In real app this data would be populated from database, instead of hard coded
        peopleList = new ArrayList<>();
        peopleList.add(new Person(1, "Gibran"));
        peopleList.add(new Person(2, "Enrique"));
        peopleList.add(new Person(3, "Castillo"));
        peopleList.add(new Person(4, "Zaldivar"));
        peopleList.add(new Person(5, "Fernando"));
        
        return peopleList;
    }
    
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public List<String> getColorList() {
        return colorList;
    }
    
    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }
    
    public Map<String, String> getColorMap() {
        return colorMap;
    }
    
    public void setColorMap(Map<String, String> colorMap) {
        this.colorMap = colorMap;
    }
    
    public String saveAnimal() {
        // code to save the animal in ZooDB
        System.out.println("Saving animal " + this.type);
        System.out.println("Mail Me? " + this.mailMe);
        System.out.println("You selected this person " + this.selectedPerson);
        System.out.println("You selected the following people ");
        
        for(int i : this.selectedPeople) {
            System.out.println(i);
        }
        
        /*
         * return null means to display (HTTP Response) in same page
         * or page that made HTTP Request.  To remain in the same page.
         */
        //return null;
        return "show";
    }
    
    /**
     * This does the same thing as returning null to an action attribute in the 
     * h:commandButton component.  However, for this to work, you use the actionListener
     * attribute in the h:commandButton component.
     * 
     * @param e 
     */
    public void someMethod(ActionEvent e) {
        // code to save the animal in ZooDB
        System.out.println("Saving animal " + this.type);
    }
}