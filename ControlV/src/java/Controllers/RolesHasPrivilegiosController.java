package Controllers;

import Models.RolesHasPrivilegios;
import Controllers.util.JsfUtil;
import Controllers.util.JsfUtil.PersistAction;
import Models.RolesHasPrivilegiosFacade;

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

@Named("rolesHasPrivilegiosController")
@SessionScoped
public class RolesHasPrivilegiosController implements Serializable {

    @EJB
    private Models.RolesHasPrivilegiosFacade ejbFacade;
    private List<RolesHasPrivilegios> items = null;
    private RolesHasPrivilegios selected;

    public RolesHasPrivilegiosController() {
    }

    public RolesHasPrivilegios getSelected() {
        return selected;
    }

    public void setSelected(RolesHasPrivilegios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setRolesHasPrivilegiosPK(new Models.RolesHasPrivilegiosPK());
    }

    private RolesHasPrivilegiosFacade getFacade() {
        return ejbFacade;
    }

    public RolesHasPrivilegios prepareCreate() {
        selected = new RolesHasPrivilegios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Lang/Bundle").getString("RolesHasPrivilegiosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Lang/Bundle").getString("RolesHasPrivilegiosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Lang/Bundle").getString("RolesHasPrivilegiosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RolesHasPrivilegios> getItems() {
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

    public RolesHasPrivilegios getRolesHasPrivilegios(Models.RolesHasPrivilegiosPK id) {
        return getFacade().find(id);
    }

    public List<RolesHasPrivilegios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RolesHasPrivilegios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RolesHasPrivilegios.class)
    public static class RolesHasPrivilegiosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RolesHasPrivilegiosController controller = (RolesHasPrivilegiosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rolesHasPrivilegiosController");
            return controller.getRolesHasPrivilegios(getKey(value));
        }

        Models.RolesHasPrivilegiosPK getKey(String value) {
            Models.RolesHasPrivilegiosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Models.RolesHasPrivilegiosPK();
            key.setRolesidRoles(Integer.parseInt(values[0]));
            key.setPrivilegiosidPrivilegios(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(Models.RolesHasPrivilegiosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRolesidRoles());
            sb.append(SEPARATOR);
            sb.append(value.getPrivilegiosidPrivilegios());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof RolesHasPrivilegios) {
                RolesHasPrivilegios o = (RolesHasPrivilegios) object;
                return getStringKey(o.getRolesHasPrivilegiosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RolesHasPrivilegios.class.getName()});
                return null;
            }
        }

    }

}
