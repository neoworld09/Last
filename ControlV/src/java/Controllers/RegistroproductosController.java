package Controllers;

import Models.Registroproductos;
import Controllers.util.JsfUtil;
import Controllers.util.JsfUtil.PersistAction;
import Models.RegistroproductosFacade;

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

@Named("registroproductosController")
@SessionScoped
public class RegistroproductosController implements Serializable {

    @EJB
    private Models.RegistroproductosFacade ejbFacade;
    private List<Registroproductos> items = null;
    private Registroproductos selected;

    public RegistroproductosController() {
    }

    public Registroproductos getSelected() {
        return selected;
    }

    public void setSelected(Registroproductos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RegistroproductosFacade getFacade() {
        return ejbFacade;
    }

    public Registroproductos prepareCreate() {
        selected = new Registroproductos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Lang/Bundle").getString("RegistroproductosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Lang/Bundle").getString("RegistroproductosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Lang/Bundle").getString("RegistroproductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Registroproductos> getItems() {
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

    public Registroproductos getRegistroproductos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Registroproductos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Registroproductos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Registroproductos.class)
    public static class RegistroproductosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RegistroproductosController controller = (RegistroproductosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "registroproductosController");
            return controller.getRegistroproductos(getKey(value));
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
            if (object instanceof Registroproductos) {
                Registroproductos o = (Registroproductos) object;
                return getStringKey(o.getIdRegistroproducto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Registroproductos.class.getName()});
                return null;
            }
        }

    }

}
