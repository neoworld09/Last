package Controllers;

import Models.Cuerponotificacion;
import Controllers.util.JsfUtil;
import Controllers.util.JsfUtil.PersistAction;
import Models.CuerponotificacionFacade;

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

@Named("cuerponotificacionController")
@SessionScoped
public class CuerponotificacionController implements Serializable {

    @EJB
    private Models.CuerponotificacionFacade ejbFacade;
    private List<Cuerponotificacion> items = null;
    private Cuerponotificacion selected;

    public CuerponotificacionController() {
    }

    public Cuerponotificacion getSelected() {
        return selected;
    }

    public void setSelected(Cuerponotificacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CuerponotificacionFacade getFacade() {
        return ejbFacade;
    }

    public Cuerponotificacion prepareCreate() {
        selected = new Cuerponotificacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Lang/Bundle").getString("CuerponotificacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Lang/Bundle").getString("CuerponotificacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Lang/Bundle").getString("CuerponotificacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Cuerponotificacion> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Lang/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Lang/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Cuerponotificacion getCuerponotificacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Cuerponotificacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cuerponotificacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Cuerponotificacion.class)
    public static class CuerponotificacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CuerponotificacionController controller = (CuerponotificacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cuerponotificacionController");
            return controller.getCuerponotificacion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cuerponotificacion) {
                Cuerponotificacion o = (Cuerponotificacion) object;
                return getStringKey(o.getIdcuerponotificacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cuerponotificacion.class.getName()});
                return null;
            }
        }

    }

}
