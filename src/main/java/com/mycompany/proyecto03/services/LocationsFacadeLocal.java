/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyecto03.services;

import com.mycompany.proyecto03.entities.Locations;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jcgom
 */
@Local
public interface LocationsFacadeLocal {

    void create(Locations locations);

    void edit(Locations locations);

    void remove(Locations locations);

    Locations find(Object id);

    List<Locations> findAll();

    List<Locations> findRange(int[] range);

    int count();
    
}
