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
public class DetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "iddetalle")
    private int iddetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura_idfactura")
    private int facturaIdfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura_reservaciones_idreservaciones")
    private int facturaReservacionesIdreservaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura_reservaciones_cliente_idcliente")
    private int facturaReservacionesClienteIdcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura_reservaciones_sucursal_idubicacion")
    private int facturaReservacionesSucursalIdubicacion;

    public DetallePK() {
    }

    public DetallePK(int iddetalle, int facturaIdfactura, int facturaReservacionesIdreservaciones, int facturaReservacionesClienteIdcliente, int facturaReservacionesSucursalIdubicacion) {
        this.iddetalle = iddetalle;
        this.facturaIdfactura = facturaIdfactura;
        this.facturaReservacionesIdreservaciones = facturaReservacionesIdreservaciones;
        this.facturaReservacionesClienteIdcliente = facturaReservacionesClienteIdcliente;
        this.facturaReservacionesSucursalIdubicacion = facturaReservacionesSucursalIdubicacion;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getFacturaIdfactura() {
        return facturaIdfactura;
    }

    public void setFacturaIdfactura(int facturaIdfactura) {
        this.facturaIdfactura = facturaIdfactura;
    }

    public int getFacturaReservacionesIdreservaciones() {
        return facturaReservacionesIdreservaciones;
    }

    public void setFacturaReservacionesIdreservaciones(int facturaReservacionesIdreservaciones) {
        this.facturaReservacionesIdreservaciones = facturaReservacionesIdreservaciones;
    }

    public int getFacturaReservacionesClienteIdcliente() {
        return facturaReservacionesClienteIdcliente;
    }

    public void setFacturaReservacionesClienteIdcliente(int facturaReservacionesClienteIdcliente) {
        this.facturaReservacionesClienteIdcliente = facturaReservacionesClienteIdcliente;
    }

    public int getFacturaReservacionesSucursalIdubicacion() {
        return facturaReservacionesSucursalIdubicacion;
    }

    public void setFacturaReservacionesSucursalIdubicacion(int facturaReservacionesSucursalIdubicacion) {
        this.facturaReservacionesSucursalIdubicacion = facturaReservacionesSucursalIdubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddetalle;
        hash += (int) facturaIdfactura;
        hash += (int) facturaReservacionesIdreservaciones;
        hash += (int) facturaReservacionesClienteIdcliente;
        hash += (int) facturaReservacionesSucursalIdubicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePK)) {
            return false;
        }
        DetallePK other = (DetallePK) object;
        if (this.iddetalle != other.iddetalle) {
            return false;
        }
        if (this.facturaIdfactura != other.facturaIdfactura) {
            return false;
        }
        if (this.facturaReservacionesIdreservaciones != other.facturaReservacionesIdreservaciones) {
            return false;
        }
        if (this.facturaReservacionesClienteIdcliente != other.facturaReservacionesClienteIdcliente) {
            return false;
        }
        if (this.facturaReservacionesSucursalIdubicacion != other.facturaReservacionesSucursalIdubicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.DetallePK[ iddetalle=" + iddetalle + ", facturaIdfactura=" + facturaIdfactura + ", facturaReservacionesIdreservaciones=" + facturaReservacionesIdreservaciones + ", facturaReservacionesClienteIdcliente=" + facturaReservacionesClienteIdcliente + ", facturaReservacionesSucursalIdubicacion=" + facturaReservacionesSucursalIdubicacion + " ]";
    }
    
}
