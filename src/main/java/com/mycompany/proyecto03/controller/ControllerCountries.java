/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyecto03.controller;

import com.mycompany.proyecto03.entities.Countries;
import com.mycompany.proyecto03.services.CountriesFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jcgom
 */
@Named(value = "controllerCountries")
@ViewScoped
public class ControllerCountries implements Serializable {
    
    Countries con = new Countries();
    @EJB
    CountriesFacadeLocal cfl;

    public Countries getCon() {
        return con;
    }

    public void setCon(Countries con) {
        this.con = con;
    }
    
     public  List<Countries> listarPaises (){
         try {
             return this.cfl.findAll();
         } catch(Exception e){
         }
         return null;
     }
    /**
     * Creates a new instance of ControllerCountries
     */
    public ControllerCountries() {
    }
    
}
