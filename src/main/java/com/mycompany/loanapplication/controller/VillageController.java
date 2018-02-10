package com.mycompany.loanapplication.controller;

import com.mycompany.loanapplication.entities.TblVillageEntity;
import com.mycompany.loanapplication.controller.util.JsfUtil;
import com.mycompany.loanapplication.controller.util.JsfUtil.PersistAction;
import com.mycompany.loanapplication.entities.TblCommuneEntity_Custom;
import com.mycompany.loanapplication.entities.TblVillageEntity_Custom;
import com.mycompany.loanapplication.service.TblCommnueEntityService;
import com.mycompany.loanapplication.service.TblVillageEntityService;
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

@Named("VillageController")
@SessionScoped
public class VillageController implements Serializable {

    @EJB
    private com.mycompany.loanapplication.service.TblVillageEntityService ejbFacade;
    @EJB
    private TblCommnueEntityService commnueEntityService;

    private List<TblVillageEntity_Custom> items = null;
    private TblVillageEntity selected;
    private TblVillageEntity selectedCreate;
    private Map<String, String> listCommune;

    public VillageController() {
        selectedCreate = new TblVillageEntity();
    }

    public TblVillageEntity getSelected() {
        return selected;
    }

    public void setSelected(TblVillageEntity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblVillageEntityService getFacade() {
        return ejbFacade;
    }

    public TblVillageEntity prepareCreate() {
        selected = selectedCreate;
        selectedCreate = new TblVillageEntity();
        initializeEmbeddableKey();
        return selectedCreate;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgCreateVillage"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            selectedCreate = new TblVillageEntity();
        }
    }

    public void prepareEdit(TblVillageEntity_Custom entity) throws IOException {
        selected = new TblVillageEntity();
        selected.setVillageID(entity.getVillageID());
        selected.setVillageName(entity.getVillageName());
        selected.setVillageKhName(entity.getVillageKhName());
        selected.setCommnueID(entity.getCommnueID());
        selected.setStatus(entity.getStatus());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/LoanApplication/Village/Edit.xhtml");
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgEditVillage"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void destroy(TblVillageEntity_Custom entity) {
        selected = new TblVillageEntity();
        selected.setVillageID(entity.getVillageID());
        selected.setVillageName(entity.getVillageName());
        selected.setVillageKhName(entity.getVillageKhName());
        selected.setCommnueID(entity.getCommnueID());
        selected.setStatus(entity.getStatus());
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgDeleteVillage"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblVillageEntity_Custom> getItems() {
        if (items == null) {
            items = getFacade().getAllVillage();
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
                    getFacade().edit(selectedCreate);
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

    public TblVillageEntity getTblVillageEntity(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TblVillageEntity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblVillageEntity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblVillageEntity.class)
    public static class TblVillageEntityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VillageController controller = (VillageController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblVillageEntityController");
            return controller.getTblVillageEntity(getKey(value));
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
            if (object instanceof TblVillageEntity) {
                TblVillageEntity o = (TblVillageEntity) object;
                return getStringKey(o.getVillageID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblVillageEntity.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the selectedCreate
     */
    public TblVillageEntity getSelectedCreate() {
        return selectedCreate;
    }

    /**
     * @param selectedCreate the selectedCreate to set
     */
    public void setSelectedCreate(TblVillageEntity selectedCreate) {
        this.selectedCreate = selectedCreate;
    }

    /**
     * @return the listCommune
     */
    public Map<String, String> getListCommune() {
        listCommune = new HashMap<>();
        List<TblCommuneEntity_Custom> list = new ArrayList<>();
        list = commnueEntityService.getAllCommune();

        for (TblCommuneEntity_Custom r : list) {
            listCommune.put(r.getCommnueName(), r.getCommnueID().toString());
        }

        return listCommune;
    }

    /**
     * @return the commnueEntityService
     */
    public TblCommnueEntityService getCommnueEntityService() {
        return commnueEntityService;
    }

}
