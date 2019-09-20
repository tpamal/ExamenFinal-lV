/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomaspamal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "reservaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaciones.findAll", query = "SELECT r FROM Reservaciones r")
    , @NamedQuery(name = "Reservaciones.findByIdreservaciones", query = "SELECT r FROM Reservaciones r WHERE r.reservacionesPK.idreservaciones = :idreservaciones")
    , @NamedQuery(name = "Reservaciones.findByFechainicial", query = "SELECT r FROM Reservaciones r WHERE r.fechainicial = :fechainicial")
    , @NamedQuery(name = "Reservaciones.findByFechafinal", query = "SELECT r FROM Reservaciones r WHERE r.fechafinal = :fechafinal")
    , @NamedQuery(name = "Reservaciones.findByClienteIdcliente", query = "SELECT r FROM Reservaciones r WHERE r.reservacionesPK.clienteIdcliente = :clienteIdcliente")
    , @NamedQuery(name = "Reservaciones.findBySucursalIdubicacion", query = "SELECT r FROM Reservaciones r WHERE r.reservacionesPK.sucursalIdubicacion = :sucursalIdubicacion")})
public class Reservaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservacionesPK reservacionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechainicial")
    private String fechainicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechafinal")
    private String fechafinal;

    public Reservaciones() {
    }

    public Reservaciones(ReservacionesPK reservacionesPK) {
        this.reservacionesPK = reservacionesPK;
    }

    public Reservaciones(ReservacionesPK reservacionesPK, String fechainicial, String fechafinal) {
        this.reservacionesPK = reservacionesPK;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
    }

    public Reservaciones(int idreservaciones, int clienteIdcliente, int sucursalIdubicacion) {
        this.reservacionesPK = new ReservacionesPK(idreservaciones, clienteIdcliente, sucursalIdubicacion);
    }

    public ReservacionesPK getReservacionesPK() {
        return reservacionesPK;
    }

    public void setReservacionesPK(ReservacionesPK reservacionesPK) {
        this.reservacionesPK = reservacionesPK;
    }

    public String getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(String fechainicial) {
        this.fechainicial = fechainicial;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservacionesPK != null ? reservacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaciones)) {
            return false;
        }
        Reservaciones other = (Reservaciones) object;
        if ((this.reservacionesPK == null && other.reservacionesPK != null) || (this.reservacionesPK != null && !this.reservacionesPK.equals(other.reservacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.Reservaciones[ reservacionesPK=" + reservacionesPK + " ]";
    }
    
}
