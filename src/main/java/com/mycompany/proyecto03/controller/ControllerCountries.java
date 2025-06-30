/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyecto03.controller;

import com.mycompany.proyecto03.entities.Countries;
import com.mycompany.proyecto03.entities.Regions;
import com.mycompany.proyecto03.services.CountriesFacadeLocal;
import com.mycompany.proyecto03.services.RegionsFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author jcgom
 */
@Named(value = "controllerCountries")
@SessionScoped
public class ControllerCountries implements Serializable {
    
    Countries con = new Countries();
    Regions reg = new Regions();
    @EJB
    CountriesFacadeLocal cfl;
    @EJB
    RegionsFacadeLocal rfl;
    List<SelectItem> listaRegiones;    

    public Countries getCon() {
        return con;
    }

    public void setCon(Countries con) {
        this.con = con;
    }

    public Regions getReg() {
        return reg;
    }

    public void setReg(Regions reg) {
        this.reg = reg;
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
    
    public List<SelectItem> listarRegiones(){
        listaRegiones = new ArrayList<>();
        try {
            for (Regions reg : this.rfl.findAll()){
                SelectItem item = new SelectItem(reg.getRegionId(), reg.getRegionName());
                listaRegiones.add(item);
            }
            return listaRegiones;
        } catch (Exception e) {
        }
        return null;
    }
    
    public String crearPaisP1() {
        this.con = new Countries();
        return "/views/Countries/crearact.xhtml?faces-redirect=true";
    }
    
    public void crearPais(){
        try {
            this.con.setRegionId(reg);
            this.cfl.create(con);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pais registrado¡¡", "MSG_INFO");
            contexto.addMessage(null, fm);
            con = new Countries();
        } catch (Exception e) {
            
        }
    }
    
    public  String editarP1(Countries con2){
        this.con = con2;
        this.reg.setRegionId(con2.getRegionId().getRegionId());
        return "/views/Countries/crearact.xhtml?faces-redirect=true";
    }
    
        public  void editarP2(){
            try {
                this.con.setRegionId(reg);
                this.cfl.edit(con);
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pais editado¡¡", "MSG_INFO");
                contexto.addMessage(null, fm);
            } catch (Exception e) {
            }
        }
        
        public void eliminar (Countries con2){
            try {
                this.cfl.remove(con2);
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro fue eleminado¡", "MSG_INFO");
                contexto.addMessage(null, fm);
            } catch (Exception e) {
            }
        }
    }
