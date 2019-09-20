/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomaspamal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author programacion
 */
@Embeddable
public class AreasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idareas")
    private int idareas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sucursal_idubicacion")
    private int sucursalIdubicacion;

    public AreasPK() {
    }

    public AreasPK(int idareas, int sucursalIdubicacion) {
        this.idareas = idareas;
        this.sucursalIdubicacion = sucursalIdubicacion;
    }

    public int getIdareas() {
        return idareas;
    }

    public void setIdareas(int idareas) {
        this.idareas = idareas;
    }

    public int getSucursalIdubicacion() {
        return sucursalIdubicacion;
    }

    public void setSucursalIdubicacion(int sucursalIdubicacion) {
        this.sucursalIdubicacion = sucursalIdubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idareas;
        hash += (int) sucursalIdubicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasPK)) {
            return false;
        }
        AreasPK other = (AreasPK) object;
        if (this.idareas != other.idareas) {
            return false;
        }
        if (this.sucursalIdubicacion != other.sucursalIdubicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.AreasPK[ idareas=" + idareas + ", sucursalIdubicacion=" + sucursalIdubicacion + " ]";
    }
    
}
