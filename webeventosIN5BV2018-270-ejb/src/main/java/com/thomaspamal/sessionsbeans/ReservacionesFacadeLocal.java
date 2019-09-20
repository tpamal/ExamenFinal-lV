/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomaspamal.sessionsbeans;

import com.thomaspamal.entities.Reservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface ReservacionesFacadeLocal {

    void create(Reservaciones reservaciones);

    void edit(Reservaciones reservaciones);

    void remove(Reservaciones reservaciones);

    Reservaciones find(Object id);

    List<Reservaciones> findAll();

    List<Reservaciones> findRange(int[] range);

    int count();
    
}
