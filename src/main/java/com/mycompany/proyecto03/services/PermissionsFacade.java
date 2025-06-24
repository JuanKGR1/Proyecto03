/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto03.services;

import com.mycompany.proyecto03.entities.Permissions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jcgom
 */
@Stateless
public class PermissionsFacade extends AbstractFacade<Permissions> implements PermissionsFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_Proyecto03_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermissionsFacade() {
        super(Permissions.class);
    }
    
}
