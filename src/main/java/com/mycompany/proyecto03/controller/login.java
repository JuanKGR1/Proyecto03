/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyecto03.controller;

import com.mycompany.proyecto03.entities.Users;
import com.mycompany.proyecto03.services.UsersFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jcgom
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

    private String usuario;
    private String contrasenna;
    private Users user = new Users();
    
    @EJB
    UsersFacadeLocal ufl;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    
    public String iniciarSesion(){
        user = this.ufl.iniciarSesion(usuario, contrasenna);
        if(user.getEmployeeId()!=null){
            HttpSession sesion = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sesion.setAttribute("usuario", usuario);
            return "inicio?faces-redirect=true";
        }else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseñas invalidos", "MSG_ERROR");
            contexto.addMessage(null, fm);
            return null;
        }
    }
    
    public login() {
    }
    
}
