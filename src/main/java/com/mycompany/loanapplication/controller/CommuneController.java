package com.mycompany.loanapplication.controller;

import com.mycompany.loanapplication.entities.TblCommnueEntity;
import com.mycompany.loanapplication.controller.util.JsfUtil;
import com.mycompany.loanapplication.controller.util.JsfUtil.PersistAction;
import com.mycompany.loanapplication.entities.TblCommuneEntity_Custom;
import com.mycompany.loanapplication.entities.TblDistrictEntity;
import com.mycompany.loanapplication.entities.TblDistrictEntity_Custom;
import com.mycompany.loanapplication.service.TblCommnueEntityService;
import com.mycompany.loanapplication.service.TblDistrictEntityService;
import java.io.IOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

@Named("CommuneController")
@SessionScoped
public class CommuneController implements Serializable {

    @EJB
    private com.mycompany.loanapplication.service.TblCommnueEntityService ejbFacade;
    
    @EJB
    private TblDistrictEntityService districtEntityService;
    
    private List<TblCommuneEntity_Custom> items = null;
    private TblCommnueEntity selected;
    private TblCommnueEntity selectedCreate;
    private Map<String,String> listDistrict;

    public CommuneController() {
        selectedCreate = new TblCommnueEntity();
    }

    public TblCommnueEntity getSelected() {
        return selected;
    }

    public void setSelected(TblCommnueEntity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblCommnueEntityService getFacade() {
        return ejbFacade;
    }

    public TblCommnueEntity prepareCreate() {
        selectedCreate = new TblCommnueEntity();
        initializeEmbeddableKey();
        return selectedCreate;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgCreateCommune"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            selectedCreate = new TblCommnueEntity();
        }
    }

    public void prepareEdit(TblCommuneEntity_Custom entity) throws IOException {
        selected = new TblCommnueEntity();
        selected.setCommnueID(entity.getCommnueID());
        selected.setCommnueKhName(entity.getCommnueKhName());
        selected.setCommnueName(entity.getCommnueName());
        selected.setDistrictID(entity.getDistrictID());
        selected.setStatus(entity.getStatus());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/LoanApplication/Commune/Edit.xhtml");
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgEditCommune"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;
        }
    }

    public void destroy(TblCommuneEntity_Custom entity) {
        selected = new TblCommnueEntity();
        selected.setCommnueID(entity.getCommnueID());
        selected.setCommnueKhName(entity.getCommnueKhName());
        selected.setCommnueName(entity.getCommnueName());
        selected.setDistrictID(entity.getDistrictID());
        selected.setStatus(0);
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgDeleteCommune"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblCommuneEntity_Custom> getItems() {
        if (items == null) {
            items = getFacade().getAllCommune();
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
                } else if (persistAction == PersistAction.UPDATE) {
                    getFacade().edit(selected);
                } else if (persistAction == PersistAction.CREATE) {
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

    public TblCommnueEntity getTblCommnueEntity(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TblCommnueEntity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblCommnueEntity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblCommnueEntity.class)
    public static class TblCommnueEntityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CommuneController controller = (CommuneController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblCommnueEntityController");
            return controller.getTblCommnueEntity(getKey(value));
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
            if (object instanceof TblCommnueEntity) {
                TblCommnueEntity o = (TblCommnueEntity) object;
                return getStringKey(o.getCommnueID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblCommnueEntity.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the selectedCreate
     */
    public TblCommnueEntity getSelectedCreate() {
        return selectedCreate;
    }

    /**
     * @param selectedCreate the selectedCreate to set
     */
    public void setSelectedCreate(TblCommnueEntity selectedCreate) {
        this.selectedCreate = selectedCreate;
    }

    /**
     * @return the listDistrict
     */
    public Map<String,String> getListDistrict() {
        
        List<TblDistrictEntity_Custom> entity = new ArrayList<TblDistrictEntity_Custom>();
        entity = getDistrictEntityService().getAllDistrict();
        listDistrict = new HashMap<>();
        for(TblDistrictEntity_Custom r : entity){
            listDistrict.put(r.getDistrictName(), r.getDistrictID().toString());
        }        
        
        return listDistrict;
    }

    /**
     * @param listDistrict the listDistrict to set
     */
    public void setListDistrict(Map<String,String> listDistrict) {
        this.listDistrict = listDistrict;
    }

    /**
     * @return the districtEntityService
     */
    public TblDistrictEntityService getDistrictEntityService() {
        return districtEntityService;
    }

}
