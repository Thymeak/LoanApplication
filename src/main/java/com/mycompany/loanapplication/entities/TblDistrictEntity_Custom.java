/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loanapplication.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



/**
 *
 * @author boysothymeak
 */
@Entity
public class TblDistrictEntity_Custom implements Serializable {
    
    @Id    
    @Column(name = "DistrictID")
    private Integer districtID;   
    @Column(name = "District_Name")
    private String districtName;   
    @Column(name = "District_KhName")
    private String districtKhName;   
    @Column(name = "Status")
    private Integer status;    
    @Column(name = "ProvinceID")
    private int provinceID;
    @Column(name = "Province_Name")
    private String provinceName;

    public TblDistrictEntity_Custom() {
    }

    public TblDistrictEntity_Custom(Integer districtID) {
        this.districtID = districtID;
    }

    public TblDistrictEntity_Custom(Integer districtID, String districtName, String districtKhName, int provinceID) {
        this.districtID = districtID;
        this.districtName = districtName;
        this.districtKhName = districtKhName;
        this.provinceID = provinceID;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictKhName() {
        return districtKhName;
    }

    public void setDistrictKhName(String districtKhName) {
        this.districtKhName = districtKhName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtID != null ? districtID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDistrictEntity_Custom)) {
            return false;
        }
        TblDistrictEntity_Custom other = (TblDistrictEntity_Custom) object;
        if ((this.districtID == null && other.districtID != null) || (this.districtID != null && !this.districtID.equals(other.districtID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblDistrictEntity[ districtID=" + districtID + " ]";
    }

    /**
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
}
