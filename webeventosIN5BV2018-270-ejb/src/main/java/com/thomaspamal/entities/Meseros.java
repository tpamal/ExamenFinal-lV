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
@Table(name = "meseros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meseros.findAll", query = "SELECT m FROM Meseros m")
    , @NamedQuery(name = "Meseros.findByIdmeseros", query = "SELECT m FROM Meseros m WHERE m.meserosPK.idmeseros = :idmeseros")
    , @NamedQuery(name = "Meseros.findByNombres", query = "SELECT m FROM Meseros m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Meseros.findByApellidos", query = "SELECT m FROM Meseros m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "Meseros.findBySucursalIdubicacion", query = "SELECT m FROM Meseros m WHERE m.meserosPK.sucursalIdubicacion = :sucursalIdubicacion")})
public class Meseros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MeserosPK meserosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;

    public Meseros() {
    }

    public Meseros(MeserosPK meserosPK) {
        this.meserosPK = meserosPK;
    }

    public Meseros(MeserosPK meserosPK, String nombres, String apellidos) {
        this.meserosPK = meserosPK;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Meseros(int idmeseros, int sucursalIdubicacion) {
        this.meserosPK = new MeserosPK(idmeseros, sucursalIdubicacion);
    }

    public MeserosPK getMeserosPK() {
        return meserosPK;
    }

    public void setMeserosPK(MeserosPK meserosPK) {
        this.meserosPK = meserosPK;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meserosPK != null ? meserosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meseros)) {
            return false;
        }
        Meseros other = (Meseros) object;
        if ((this.meserosPK == null && other.meserosPK != null) || (this.meserosPK != null && !this.meserosPK.equals(other.meserosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.Meseros[ meserosPK=" + meserosPK + " ]";
    }
    
}
