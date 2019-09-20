package com.thomaspamal.entities;

import com.thomaspamal.entities.FacturaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-20T14:17:25")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> descripcion;
    public static volatile SingularAttribute<Factura, String> tarifa;
    public static volatile SingularAttribute<Factura, FacturaPK> facturaPK;
    public static volatile SingularAttribute<Factura, String> fechainicial;
    public static volatile SingularAttribute<Factura, String> fechafinal;

}