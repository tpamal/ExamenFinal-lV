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
@Table(name = "areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")
    , @NamedQuery(name = "Areas.findByIdareas", query = "SELECT a FROM Areas a WHERE a.areasPK.idareas = :idareas")
    , @NamedQuery(name = "Areas.findByNumerosillas", query = "SELECT a FROM Areas a WHERE a.numerosillas = :numerosillas")
    , @NamedQuery(name = "Areas.findByNumeromesas", query = "SELECT a FROM Areas a WHERE a.numeromesas = :numeromesas")
    , @NamedQuery(name = "Areas.findBySucursalIdubicacion", query = "SELECT a FROM Areas a WHERE a.areasPK.sucursalIdubicacion = :sucursalIdubicacion")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreasPK areasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numerosillas")
    private String numerosillas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numeromesas")
    private String numeromesas;

    public Areas() {
    }

    public Areas(AreasPK areasPK) {
        this.areasPK = areasPK;
    }

    public Areas(AreasPK areasPK, String numerosillas, String numeromesas) {
        this.areasPK = areasPK;
        this.numerosillas = numerosillas;
        this.numeromesas = numeromesas;
    }

    public Areas(int idareas, int sucursalIdubicacion) {
        this.areasPK = new AreasPK(idareas, sucursalIdubicacion);
    }

    public AreasPK getAreasPK() {
        return areasPK;
    }

    public void setAreasPK(AreasPK areasPK) {
        this.areasPK = areasPK;
    }

    public String getNumerosillas() {
        return numerosillas;
    }

    public void setNumerosillas(String numerosillas) {
        this.numerosillas = numerosillas;
    }

    public String getNumeromesas() {
        return numeromesas;
    }

    public void setNumeromesas(String numeromesas) {
        this.numeromesas = numeromesas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areasPK != null ? areasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.areasPK == null && other.areasPK != null) || (this.areasPK != null && !this.areasPK.equals(other.areasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.Areas[ areasPK=" + areasPK + " ]";
    }
    
}
