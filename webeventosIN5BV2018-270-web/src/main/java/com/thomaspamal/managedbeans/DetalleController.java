package com.thomaspamal.managedbeans;

import com.thomaspamal.entities.Detalle;
import com.thomaspamal.managedbeans.util.JsfUtil;
import com.thomaspamal.managedbeans.util.JsfUtil.PersistAction;
import com.thomaspamal.sessionsbeans.DetalleFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("detalleController")
@SessionScoped
public class DetalleController implements Serializable {

    @EJB
    private DetalleFacadeLocal ejbFacade;
    private List<Detalle> items = null;
    private Detalle selected;

    public DetalleController() {
    }

    public Detalle getSelected() {
        return selected;
    }

    public void setSelected(Detalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setDetallePK(new com.thomaspamal.entities.DetallePK());
    }

    private DetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Detalle prepareCreate() {
        selected = new Detalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Detalle> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Detalle getDetalle(com.thomaspamal.entities.DetallePK id) {
        return getFacade().find(id);
    }

    public List<Detalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Detalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Detalle.class)
    public static class DetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetalleController controller = (DetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detalleController");
            return controller.getDetalle(getKey(value));
        }

        com.thomaspamal.entities.DetallePK getKey(String value) {
            com.thomaspamal.entities.DetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.thomaspamal.entities.DetallePK();
            key.setIddetalle(Integer.parseInt(values[0]));
            key.setFacturaIdfactura(Integer.parseInt(values[1]));
            key.setFacturaReservacionesIdreservaciones(Integer.parseInt(values[2]));
            key.setFacturaReservacionesClienteIdcliente(Integer.parseInt(values[3]));
            key.setFacturaReservacionesSucursalIdubicacion(Integer.parseInt(values[4]));
            return key;
        }

        String getStringKey(com.thomaspamal.entities.DetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIddetalle());
            sb.append(SEPARATOR);
            sb.append(value.getFacturaIdfactura());
            sb.append(SEPARATOR);
            sb.append(value.getFacturaReservacionesIdreservaciones());
            sb.append(SEPARATOR);
            sb.append(value.getFacturaReservacionesClienteIdcliente());
            sb.append(SEPARATOR);
            sb.append(value.getFacturaReservacionesSucursalIdubicacion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detalle) {
                Detalle o = (Detalle) object;
                return getStringKey(o.getDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Detalle.class.getName()});
                return null;
            }
        }

    }

}
