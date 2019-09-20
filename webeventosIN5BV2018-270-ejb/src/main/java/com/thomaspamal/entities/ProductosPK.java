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
public class ProductosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idmenu")
    private int idmenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura_idfactura")
    private int facturaIdfactura;

    public ProductosPK() {
    }

    public ProductosPK(int idmenu, int facturaIdfactura) {
        this.idmenu = idmenu;
        this.facturaIdfactura = facturaIdfactura;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public int getFacturaIdfactura() {
        return facturaIdfactura;
    }

    public void setFacturaIdfactura(int facturaIdfactura) {
        this.facturaIdfactura = facturaIdfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmenu;
        hash += (int) facturaIdfactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosPK)) {
            return false;
        }
        ProductosPK other = (ProductosPK) object;
        if (this.idmenu != other.idmenu) {
            return false;
        }
        if (this.facturaIdfactura != other.facturaIdfactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thomaspamal.entities.ProductosPK[ idmenu=" + idmenu + ", facturaIdfactura=" + facturaIdfactura + " ]";
    }
    
}
