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
public class TblCommuneEntity_Custom implements Serializable {

   
    @Id
    @Column(name = "CommnueID")
    private Integer commnueID;    
    @Column(name = "Commnue_Name")
    private String commnueName;
       @Column(name = "Commnue_KhName")
    private String commnueKhName;
    @Column(name = "Status")
    private Integer status;   
    @Column(name = "DistrictID")
    private int districtID;
    @Column(name = "District_Name")
    private String districtName;

    public TblCommuneEntity_Custom() {
    }

    public TblCommuneEntity_Custom(Integer commnueID) {
        this.commnueID = commnueID;
    }

    public TblCommuneEntity_Custom(Integer commnueID, String commnueName, String commnueKhName, int districtID) {
        this.commnueID = commnueID;
        this.commnueName = commnueName;
        this.commnueKhName = commnueKhName;
        this.districtID = districtID;
    }

    public Integer getCommnueID() {
        return commnueID;
    }

    public void setCommnueID(Integer commnueID) {
        this.commnueID = commnueID;
    }

    public String getCommnueName() {
        return commnueName;
    }

    public void setCommnueName(String commnueName) {
        this.commnueName = commnueName;
    }

    public String getCommnueKhName() {
        return commnueKhName;
    }

    public void setCommnueKhName(String commnueKhName) {
        this.commnueKhName = commnueKhName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commnueID != null ? commnueID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCommuneEntity_Custom)) {
            return false;
        }
        TblCommuneEntity_Custom other = (TblCommuneEntity_Custom) object;
        if ((this.commnueID == null && other.commnueID != null) || (this.commnueID != null && !this.commnueID.equals(other.commnueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblCommnueEntity[ commnueID=" + commnueID + " ]";
    }

    /**
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
}
