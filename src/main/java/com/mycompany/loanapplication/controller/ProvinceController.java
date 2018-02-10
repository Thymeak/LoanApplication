package com.mycompany.loanapplication.controller;

import com.mycompany.loanapplication.entities.TblProvinceEntity;
import com.mycompany.loanapplication.controller.util.JsfUtil;
import com.mycompany.loanapplication.controller.util.JsfUtil.PersistAction;
import com.mycompany.loanapplication.service.TblProvinceEntityService;
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

@Named("ProvinceController")
@SessionScoped
public class ProvinceController implements Serializable {

    @EJB
    private com.mycompany.loanapplication.service.TblProvinceEntityService ejbFacade;
    private List<TblProvinceEntity> items = null;
    private TblProvinceEntity selected;
    private TblProvinceEntity selectedCreate;

    public ProvinceController() {
        selectedCreate = new TblProvinceEntity();
    }

    public TblProvinceEntity getSelected() {
        return selected;
    }

    public void setSelected(TblProvinceEntity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblProvinceEntityService getFacade() {
        return ejbFacade;
    }

    public TblProvinceEntity prepareCreate() {
        selectedCreate = new TblProvinceEntity();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgCreateProvince"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            selectedCreate = new TblProvinceEntity();
        }
    }
    
    public void prepareEdit(TblProvinceEntity entity) throws IOException{
        selected = new TblProvinceEntity();
        selected = entity;
        FacesContext.getCurrentInstance().getExternalContext().redirect("/LoanApplication/Province/Edit.xhtml");
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgUpdateProvice"));
    }

    public void destroy(TblProvinceEntity entity) {
        selected = new TblProvinceEntity();
        selected = entity;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgDeleteProvince"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblProvinceEntity> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null || selectedCreate != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.DELETE) {
                    selected.setStatus(0);
                    getFacade().edit(selected);
                } else if(persistAction == PersistAction.UPDATE){
                    getFacade().edit(selected);
                }else if(persistAction == PersistAction.CREATE){
                    selectedCreate.setStatus(1);
                    getFacade().create(selectedCreate);
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

    public TblProvinceEntity getTblProvinceEntity(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TblProvinceEntity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblProvinceEntity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblProvinceEntity.class)
    public static class TblProvinceEntityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProvinceController controller = (ProvinceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblProvinceEntityController");
            return controller.getTblProvinceEntity(getKey(value));
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
            if (object instanceof TblProvinceEntity) {
                TblProvinceEntity o = (TblProvinceEntity) object;
                return getStringKey(o.getProvinceID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblProvinceEntity.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the selectedCreate
     */
    public TblProvinceEntity getSelectedCreate() {
        return selectedCreate;
    }

    /**
     * @param selectedCreate the selectedCreate to set
     */
    public void setSelectedCreate(TblProvinceEntity selectedCreate) {
        this.selectedCreate = selectedCreate;
    }

}
