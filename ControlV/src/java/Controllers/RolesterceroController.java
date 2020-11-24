package Controllers;

import Models.Rolestercero;
import Controllers.util.JsfUtil;
import Controllers.util.JsfUtil.PersistAction;
import Models.RolesterceroFacade;

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

@Named("rolesterceroController")
@SessionScoped
public class RolesterceroController implements Serializable {

    @EJB
    private Models.RolesterceroFacade ejbFacade;
    private List<Rolestercero> items = null;
    private Rolestercero selected;

    public RolesterceroController() {
    }

    public Rolestercero getSelected() {
        return selected;
    }

    public void setSelected(Rolestercero selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setRolesterceroPK(new Models.RolesterceroPK());
    }

    private RolesterceroFacade getFacade() {
        return ejbFacade;
    }

    public Rolestercero prepareCreate() {
        selected = new Rolestercero();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Lang/Bundle").getString("RolesterceroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Lang/Bundle").getString("RolesterceroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Lang/Bundle").getString("RolesterceroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Rolestercero> getItems() {
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

    public Rolestercero getRolestercero(Models.RolesterceroPK id) {
        return getFacade().find(id);
    }

    public List<Rolestercero> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Rolestercero> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Rolestercero.class)
    public static class RolesterceroControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RolesterceroController controller = (RolesterceroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rolesterceroController");
            return controller.getRolestercero(getKey(value));
        }

        Models.RolesterceroPK getKey(String value) {
            Models.RolesterceroPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Models.RolesterceroPK();
            key.setRolesidRoles(Integer.parseInt(values[0]));
            key.setRoleshasTercerocol(Short.parseShort(values[1]));
            return key;
        }

        String getStringKey(Models.RolesterceroPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRolesidRoles());
            sb.append(SEPARATOR);
            sb.append(value.getRoleshasTercerocol());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Rolestercero) {
                Rolestercero o = (Rolestercero) object;
                return getStringKey(o.getRolesterceroPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Rolestercero.class.getName()});
                return null;
            }
        }

    }

}
