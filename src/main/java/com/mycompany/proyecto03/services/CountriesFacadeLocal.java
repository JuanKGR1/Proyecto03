/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyecto03.services;

import com.mycompany.proyecto03.entities.Countries;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jcgom
 */
@Local
public interface CountriesFacadeLocal {

    void create(Countries countries);

    void edit(Countries countries);

    void remove(Countries countries);

    Countries find(Object id);

    List<Countries> findAll();

    List<Countries> findRange(int[] range);

    int count();
    
}
