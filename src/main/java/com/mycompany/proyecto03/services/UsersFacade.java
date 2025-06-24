/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto03.services;

import com.mycompany.proyecto03.entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jcgom
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_Proyecto03_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    @Override
    public Users iniciarSesion(String usuario, String password){
        Query query = em.createQuery("SELECT U FROM Users U WHERE U.username=:username AND U.password=:password AND U.statusId.statusId=1");
        query.setParameter("username", usuario);
        query.setParameter("password", password);
        
        try {
            return (Users) query.getSingleResult();
        } catch (Exception e){
        }
        
        Users usuarioIn = new Users();
        return usuarioIn;
    }
        
}
