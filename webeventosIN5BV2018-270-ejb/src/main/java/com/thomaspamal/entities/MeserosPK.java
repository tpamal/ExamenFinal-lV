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
public class MeserosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idmeseros")
    private int idmeseros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sucursal_idubicacion")
    private int sucursalIdubicacion;

    public MeserosPK() {
    }

    public MeserosPK(int idmeseros, int sucursalIdubicacion) {
        this.idmeseros = idmeseros;
        this.sucursalIdubicacion = sucursalIdubicacion;
    }

    public int getIdmeseros() {
        return idmeseros;
    }

    public void setIdmeseros(int idmeseros) {
        this.idmeseros = idmeseros;
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
        hash += (int) idmeseros;
        hash += (int) sucursalIdubicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeserosPK)) {
            return false;
        }
        MeserosPK other = (MeserosPK) object;
        if (this.idmeseros != other.idmeseros) {
            return false;
        }
        if (this.sucursalIdubicacion != other.sucursalIdubicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.MeserosPK[ idmeseros=" + idmeseros + ", sucursalIdubicacion=" + sucursalIdubicacion + " ]";
    }
    
}
