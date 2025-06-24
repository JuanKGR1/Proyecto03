/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyecto03.services;

import com.mycompany.proyecto03.entities.UserRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jcgom
 */
@Local
public interface UserRolesFacadeLocal {

    void create(UserRoles userRoles);

    void edit(UserRoles userRoles);

    void remove(UserRoles userRoles);

    UserRoles find(Object id);

    List<UserRoles> findAll();

    List<UserRoles> findRange(int[] range);

    int count();
    
}
