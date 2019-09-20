/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomaspamal.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByIddetalle", query = "SELECT d FROM Detalle d WHERE d.detallePK.iddetalle = :iddetalle")
    , @NamedQuery(name = "Detalle.findByFacturaIdfactura", query = "SELECT d FROM Detalle d WHERE d.detallePK.facturaIdfactura = :facturaIdfactura")
    , @NamedQuery(name = "Detalle.findByFacturaReservacionesIdreservaciones", query = "SELECT d FROM Detalle d WHERE d.detallePK.facturaReservacionesIdreservaciones = :facturaReservacionesIdreservaciones")
    , @NamedQuery(name = "Detalle.findByFacturaReservacionesClienteIdcliente", query = "SELECT d FROM Detalle d WHERE d.detallePK.facturaReservacionesClienteIdcliente = :facturaReservacionesClienteIdcliente")
    , @NamedQuery(name = "Detalle.findByFacturaReservacionesSucursalIdubicacion", query = "SELECT d FROM Detalle d WHERE d.detallePK.facturaReservacionesSucursalIdubicacion = :facturaReservacionesSucursalIdubicacion")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePK detallePK;

    public Detalle() {
    }

    public Detalle(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public Detalle(int iddetalle, int facturaIdfactura, int facturaReservacionesIdreservaciones, int facturaReservacionesClienteIdcliente, int facturaReservacionesSucursalIdubicacion) {
        this.detallePK = new DetallePK(iddetalle, facturaIdfactura, facturaReservacionesIdreservaciones, facturaReservacionesClienteIdcliente, facturaReservacionesSucursalIdubicacion);
    }

    public DetallePK getDetallePK() {
        return detallePK;
    }

    public void setDetallePK(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePK != null ? detallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.detallePK == null && other.detallePK != null) || (this.detallePK != null && !this.detallePK.equals(other.detallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.Detalle[ detallePK=" + detallePK + " ]";
    }
    
}
