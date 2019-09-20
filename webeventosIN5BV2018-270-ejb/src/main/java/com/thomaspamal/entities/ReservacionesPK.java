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
public class ReservacionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idreservaciones")
    private int idreservaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sucursal_idubicacion")
    private int sucursalIdubicacion;

    public ReservacionesPK() {
    }

    public ReservacionesPK(int idreservaciones, int clienteIdcliente, int sucursalIdubicacion) {
        this.idreservaciones = idreservaciones;
        this.clienteIdcliente = clienteIdcliente;
        this.sucursalIdubicacion = sucursalIdubicacion;
    }

    public int getIdreservaciones() {
        return idreservaciones;
    }

    public void setIdreservaciones(int idreservaciones) {
        this.idreservaciones = idreservaciones;
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
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
        hash += (int) idreservaciones;
        hash += (int) clienteIdcliente;
        hash += (int) sucursalIdubicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservacionesPK)) {
            return false;
        }
        ReservacionesPK other = (ReservacionesPK) object;
        if (this.idreservaciones != other.idreservaciones) {
            return false;
        }
        if (this.clienteIdcliente != other.clienteIdcliente) {
            return false;
        }
        if (this.sucursalIdubicacion != other.sucursalIdubicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.ReservacionesPK[ idreservaciones=" + idreservaciones + ", clienteIdcliente=" + clienteIdcliente + ", sucursalIdubicacion=" + sucursalIdubicacion + " ]";
    }
    
}
