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
@Table(name = "tbl_Village", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVillageEntity.findAll", query = "SELECT t FROM TblVillageEntity t")
    , @NamedQuery(name = "TblVillageEntity.findByVillageID", query = "SELECT t FROM TblVillageEntity t WHERE t.villageID = :villageID")
    , @NamedQuery(name = "TblVillageEntity.findByVillageName", query = "SELECT t FROM TblVillageEntity t WHERE t.villageName = :villageName")
    , @NamedQuery(name = "TblVillageEntity.findByVillageKhName", query = "SELECT t FROM TblVillageEntity t WHERE t.villageKhName = :villageKhName")
    , @NamedQuery(name = "TblVillageEntity.findByStatus", query = "SELECT t FROM TblVillageEntity t WHERE t.status = :status")
    , @NamedQuery(name = "TblVillageEntity.findByCommnueID", query = "SELECT t FROM TblVillageEntity t WHERE t.commnueID = :commnueID")})
public class TblVillageEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "VillageID")
    private Integer villageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Village_Name")
    private String villageName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Village_KhName")
    private String villageKhName;
    @Column(name = "Status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CommnueID")
    private int commnueID;

    public TblVillageEntity() {
    }

    public TblVillageEntity(Integer villageID) {
        this.villageID = villageID;
    }

    public TblVillageEntity(Integer villageID, String villageName, String villageKhName, int commnueID) {
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
        if (!(object instanceof TblVillageEntity)) {
            return false;
        }
        TblVillageEntity other = (TblVillageEntity) object;
        if ((this.villageID == null && other.villageID != null) || (this.villageID != null && !this.villageID.equals(other.villageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblVillageEntity[ villageID=" + villageID + " ]";
    }
    
}
