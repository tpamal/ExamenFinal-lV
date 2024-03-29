package com.thomaspamal.managedbeans;

import com.thomaspamal.entities.Reservaciones;
import com.thomaspamal.managedbeans.util.JsfUtil;
import com.thomaspamal.managedbeans.util.JsfUtil.PersistAction;
import com.thomaspamal.sessionsbeans.ReservacionesFacadeLocal;

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

@Named("reservacionesController")
@SessionScoped
public class ReservacionesController implements Serializable {

    @EJB
    private ReservacionesFacadeLocal ejbFacade;
    private List<Reservaciones> items = null;
    private Reservaciones selected;

    public ReservacionesController() {
    }

    public Reservaciones getSelected() {
        return selected;
    }

    public void setSelected(Reservaciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setReservacionesPK(new com.thomaspamal.entities.ReservacionesPK());
    }

    private ReservacionesFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Reservaciones prepareCreate() {
        selected = new Reservaciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReservacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReservacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReservacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Reservaciones> getItems() {
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

    public Reservaciones getReservaciones(com.thomaspamal.entities.ReservacionesPK id) {
        return getFacade().find(id);
    }

    public List<Reservaciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Reservaciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Reservaciones.class)
    public static class ReservacionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReservacionesController controller = (ReservacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reservacionesController");
            return controller.getReservaciones(getKey(value));
        }

        com.thomaspamal.entities.ReservacionesPK getKey(String value) {
            com.thomaspamal.entities.ReservacionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.thomaspamal.entities.ReservacionesPK();
            key.setIdreservaciones(Integer.parseInt(values[0]));
            key.setClienteIdcliente(Integer.parseInt(values[1]));
            key.setSucursalIdubicacion(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(com.thomaspamal.entities.ReservacionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdreservaciones());
            sb.append(SEPARATOR);
            sb.append(value.getClienteIdcliente());
            sb.append(SEPARATOR);
            sb.append(value.getSucursalIdubicacion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Reservaciones) {
                Reservaciones o = (Reservaciones) object;
                return getStringKey(o.getReservacionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Reservaciones.class.getName()});
                return null;
            }
        }

    }

}
