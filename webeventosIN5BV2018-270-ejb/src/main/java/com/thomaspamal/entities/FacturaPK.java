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
public class FacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idfactura")
    private int idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservaciones_idreservaciones")
    private int reservacionesIdreservaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservaciones_cliente_idcliente")
    private int reservacionesClienteIdcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservaciones_sucursal_idubicacion")
    private int reservacionesSucursalIdubicacion;

    public FacturaPK() {
    }

    public FacturaPK(int idfactura, int reservacionesIdreservaciones, int reservacionesClienteIdcliente, int reservacionesSucursalIdubicacion) {
        this.idfactura = idfactura;
        this.reservacionesIdreservaciones = reservacionesIdreservaciones;
        this.reservacionesClienteIdcliente = reservacionesClienteIdcliente;
        this.reservacionesSucursalIdubicacion = reservacionesSucursalIdubicacion;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getReservacionesIdreservaciones() {
        return reservacionesIdreservaciones;
    }

    public void setReservacionesIdreservaciones(int reservacionesIdreservaciones) {
        this.reservacionesIdreservaciones = reservacionesIdreservaciones;
    }

    public int getReservacionesClienteIdcliente() {
        return reservacionesClienteIdcliente;
    }

    public void setReservacionesClienteIdcliente(int reservacionesClienteIdcliente) {
        this.reservacionesClienteIdcliente = reservacionesClienteIdcliente;
    }

    public int getReservacionesSucursalIdubicacion() {
        return reservacionesSucursalIdubicacion;
    }

    public void setReservacionesSucursalIdubicacion(int reservacionesSucursalIdubicacion) {
        this.reservacionesSucursalIdubicacion = reservacionesSucursalIdubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfactura;
        hash += (int) reservacionesIdreservaciones;
        hash += (int) reservacionesClienteIdcliente;
        hash += (int) reservacionesSucursalIdubicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPK)) {
            return false;
        }
        FacturaPK other = (FacturaPK) object;
        if (this.idfactura != other.idfactura) {
            return false;
        }
        if (this.reservacionesIdreservaciones != other.reservacionesIdreservaciones) {
            return false;
        }
        if (this.reservacionesClienteIdcliente != other.reservacionesClienteIdcliente) {
            return false;
        }
        if (this.reservacionesSucursalIdubicacion != other.reservacionesSucursalIdubicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.FacturaPK[ idfactura=" + idfactura + ", reservacionesIdreservaciones=" + reservacionesIdreservaciones + ", reservacionesClienteIdcliente=" + reservacionesClienteIdcliente + ", reservacionesSucursalIdubicacion=" + reservacionesSucursalIdubicacion + " ]";
    }
    
}
