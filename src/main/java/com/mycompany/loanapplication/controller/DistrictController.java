package com.mycompany.loanapplication.controller;

import com.mycompany.loanapplication.entities.TblDistrictEntity;
import com.mycompany.loanapplication.controller.util.JsfUtil;
import com.mycompany.loanapplication.controller.util.JsfUtil.PersistAction;
import com.mycompany.loanapplication.entities.TblDistrictEntity_Custom;
import com.mycompany.loanapplication.entities.TblProvinceEntity;
import com.mycompany.loanapplication.service.TblDistrictEntityService;
import com.mycompany.loanapplication.service.TblProvinceEntityService;
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

@Named("DistrictController")
@SessionScoped
public class DistrictController implements Serializable {

    @EJB
    private com.mycompany.loanapplication.service.TblDistrictEntityService ejbFacade;

    @EJB
    private TblProvinceEntityService provinceEntityService;

    private List<TblDistrictEntity_Custom> items = null;
    private TblDistrictEntity selected;
    private TblDistrictEntity selectCreate;
    private Map<String, String> listProvince;

    public DistrictController() {
        selectCreate = new TblDistrictEntity();
    }

    public TblDistrictEntity getSelected() {
        return selected;
    }

    public void setSelected(TblDistrictEntity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblDistrictEntityService getFacade() {
        return ejbFacade;
    }

    public TblDistrictEntity prepareCreate() {
        selectCreate = new TblDistrictEntity();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgCreateDistrict"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            selectCreate = new TblDistrictEntity();
        }
    }

    public void prepareEdit(TblDistrictEntity_Custom entity) throws IOException {
        selected = new TblDistrictEntity();
        selected.setDistrictID(entity.getDistrictID());
        selected.setDistrictKhName(entity.getDistrictKhName());
        selected.setDistrictName(entity.getDistrictName());
        selected.setProvinceID(entity.getProvinceID());
        selected.setStatus(entity.getStatus());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/LoanApplication/District/Edit.xhtml");
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgUpdateDistrict"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;
        }
    }

    public void destroy(TblDistrictEntity_Custom entity) {
        selected = new TblDistrictEntity();
        selected.setDistrictID(entity.getDistrictID());
        selected.setDistrictKhName(entity.getDistrictKhName());
        selected.setDistrictName(entity.getDistrictName());
        selected.setProvinceID(entity.getProvinceID());
        selected.setStatus(0);
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/properties/Bundle").getString("MsgDeleteDistrict"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblDistrictEntity_Custom> getItems() {
        if (items == null) {
            items = getFacade().getAllDistrict();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null || selectCreate != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.DELETE) {
                    selected.setStatus(0);
                    getFacade().edit(selected);
                } else if (persistAction == PersistAction.CREATE) {
                    selectCreate.setStatus(1);
                    getFacade().create(selectCreate);
                } else if (persistAction == PersistAction.UPDATE) {
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

    public TblDistrictEntity getTblDistrictEntity(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TblDistrictEntity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblDistrictEntity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblDistrictEntity.class)
    public static class TblDistrictEntityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DistrictController controller = (DistrictController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblDistrictEntityController");
            return controller.getTblDistrictEntity(getKey(value));
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
            if (object instanceof TblDistrictEntity) {
                TblDistrictEntity o = (TblDistrictEntity) object;
                return getStringKey(o.getDistrictID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblDistrictEntity.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the selectCreate
     */
    public TblDistrictEntity getSelectCreate() {
        return selectCreate;
    }

    /**
     * @param selectCreate the selectCreate to set
     */
    public void setSelectCreate(TblDistrictEntity selectCreate) {
        this.selectCreate = selectCreate;
    }

    /**
     * @return the listProvince
     */
    public Map<String, String> getListProvince() {

        listProvince = new HashMap<>();
        List<TblProvinceEntity> provinces = new ArrayList<>();
        provinces = getProvinceEntityService().getAllProvince();
        for (TblProvinceEntity r : provinces) {
            listProvince.put(r.getProvinceName(), r.getProvinceID().toString());
        }

        return listProvince;
    }

    /**
     * @param listProvince the listProvince to set
     */
    public void setListProvince(Map<String, String> listProvince) {
        this.listProvince = listProvince;
    }

    /**
     * @return the provinceEntityService
     */
    public TblProvinceEntityService getProvinceEntityService() {
        return provinceEntityService;
    }

}
