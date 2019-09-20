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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.facturaPK.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByFechainicial", query = "SELECT f FROM Factura f WHERE f.fechainicial = :fechainicial")
    , @NamedQuery(name = "Factura.findByFechafinal", query = "SELECT f FROM Factura f WHERE f.fechafinal = :fechafinal")
    , @NamedQuery(name = "Factura.findByDescripcion", query = "SELECT f FROM Factura f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "Factura.findByTarifa", query = "SELECT f FROM Factura f WHERE f.tarifa = :tarifa")
    , @NamedQuery(name = "Factura.findByReservacionesIdreservaciones", query = "SELECT f FROM Factura f WHERE f.facturaPK.reservacionesIdreservaciones = :reservacionesIdreservaciones")
    , @NamedQuery(name = "Factura.findByReservacionesClienteIdcliente", query = "SELECT f FROM Factura f WHERE f.facturaPK.reservacionesClienteIdcliente = :reservacionesClienteIdcliente")
    , @NamedQuery(name = "Factura.findByReservacionesSucursalIdubicacion", query = "SELECT f FROM Factura f WHERE f.facturaPK.reservacionesSucursalIdubicacion = :reservacionesSucursalIdubicacion")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPK facturaPK;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tarifa")
    private String tarifa;

    public Factura() {
    }

    public Factura(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Factura(FacturaPK facturaPK, String fechainicial, String fechafinal, String descripcion, String tarifa) {
        this.facturaPK = facturaPK;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public Factura(int idfactura, int reservacionesIdreservaciones, int reservacionesClienteIdcliente, int reservacionesSucursalIdubicacion) {
        this.facturaPK = new FacturaPK(idfactura, reservacionesIdreservaciones, reservacionesClienteIdcliente, reservacionesSucursalIdubicacion);
    }

    public FacturaPK getFacturaPK() {
        return facturaPK;
    }

    public void setFacturaPK(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPK != null ? facturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaPK == null && other.facturaPK != null) || (this.facturaPK != null && !this.facturaPK.equals(other.facturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.Factura[ facturaPK=" + facturaPK + " ]";
    }
    
}
