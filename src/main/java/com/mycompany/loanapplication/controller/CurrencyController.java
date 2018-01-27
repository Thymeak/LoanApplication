package com.mycompany.loanapplication.controller;

import com.mycompany.loanapplication.entities.TblCurrencyEntity;
import com.mycompany.loanapplication.controller.util.JsfUtil;
import com.mycompany.loanapplication.controller.util.JsfUtil.PersistAction;
import com.mycompany.loanapplication.service.TblCurrencyEntityFacade;
import java.io.IOException;

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

@Named("CurrencyController")
@SessionScoped
public class CurrencyController implements Serializable {

    @EJB
    private com.mycompany.loanapplication.service.TblCurrencyEntityFacade ejbFacade;
    private List<TblCurrencyEntity> items = null;
    private TblCurrencyEntity selected;
    private TblCurrencyEntity selectedCreate;

    public CurrencyController() {
        selectedCreate = new TblCurrencyEntity();
        selected = new TblCurrencyEntity();
    }

    public TblCurrencyEntity getSelected() {
        return selected;
    }

    public void setSelected(TblCurrencyEntity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblCurrencyEntityFacade getFacade() {
        return ejbFacade;
    }
    
    public void prepareEdit(TblCurrencyEntity entity) throws IOException{    
        selected = new TblCurrencyEntity();
        selected = entity;
        FacesContext.getCurrentInstance().getExternalContext().redirect("/LoanApplication/faces/Currency/Edit.xhtml");
    }

    public TblCurrencyEntity prepareCreate() {
        selectedCreate = new TblCurrencyEntity();
        initializeEmbeddableKey();
        return selectedCreate;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MsgCreateCurrency"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            selectedCreate = new TblCurrencyEntity();
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MsgUpdateCurreny"));
    }

    public void destroy(TblCurrencyEntity entity) {
        selected = new TblCurrencyEntity();
        selected = entity;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MsgDeleteCurrency"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblCurrencyEntity> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null || selectedCreate != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.UPDATE) {
                    getFacade().edit(selected);
                } else if(persistAction == PersistAction.CREATE) {
                    selectedCreate.setStatus(1);
                    getFacade().create(selectedCreate);
                } else {
                    selected.setStatus(0);
                    getFacade().edit(selected);
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

    public TblCurrencyEntity getTblCurrencyEntity(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TblCurrencyEntity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblCurrencyEntity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblCurrencyEntity.class)
    public static class TblCurrencyEntityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CurrencyController controller = (CurrencyController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblCurrencyEntityController");
            return controller.getTblCurrencyEntity(getKey(value));
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
            if (object instanceof TblCurrencyEntity) {
                TblCurrencyEntity o = (TblCurrencyEntity) object;
                return getStringKey(o.getCurrencyID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblCurrencyEntity.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the selectedCreate
     */
    public TblCurrencyEntity getSelectedCreate() {
        return selectedCreate;
    }

    /**
     * @param selectedCreate the selectedCreate to set
     */
    public void setSelectedCreate(TblCurrencyEntity selectedCreate) {
        this.selectedCreate = selectedCreate;
    }

}
