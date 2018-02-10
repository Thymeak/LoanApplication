/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loanapplication.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author boysothymeak
 */
@Entity
public class TblVillageEntity_Custom implements Serializable {

   @Id
    @Column(name = "VillageID")
    private Integer villageID;    
    @Column(name = "Village_Name")
    private String villageName;    
    @Column(name = "Village_KhName")
    private String villageKhName;
    @Column(name = "Status")
    private Integer status;    
    @Column(name = "CommnueID")
    private int commnueID;
    @Column(name = "Commnue_Name")
    private String communeName;
    
    public TblVillageEntity_Custom() {
    }

    public TblVillageEntity_Custom(Integer villageID) {
        this.villageID = villageID;
    }

    public TblVillageEntity_Custom(Integer villageID, String villageName, String villageKhName, int commnueID) {
        this.villageID = villageID;
        this.villageName = villageName;
        this.villageKhName = villageKhName;
        this.commnueID = commnueID;
    }

    public Integer getVillageID() {
        return villageID;
    }

    public void setVillageID(Integer villageID) {
        this.villageID = villageID;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getVillageKhName() {
        return villageKhName;
    }

    public void setVillageKhName(String villageKhName) {
        this.villageKhName = villageKhName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getCommnueID() {
        return commnueID;
    }

    public void setCommnueID(int commnueID) {
        this.commnueID = commnueID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villageID != null ? villageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVillageEntity_Custom)) {
            return false;
        }
        TblVillageEntity_Custom other = (TblVillageEntity_Custom) object;
        if ((this.villageID == null && other.villageID != null) || (this.villageID != null && !this.villageID.equals(other.villageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblVillageEntity[ villageID=" + villageID + " ]";
    }

    /**
     * @return the communeName
     */
    public String getCommuneName() {
        return communeName;
    }

    /**
     * @param communeName the communeName to set
     */
    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }
    
}
