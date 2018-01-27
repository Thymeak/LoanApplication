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
@Table(name = "tbl_Commnue", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCommnueEntity.findAll", query = "SELECT t FROM TblCommnueEntity t")
    , @NamedQuery(name = "TblCommnueEntity.findByCommnueID", query = "SELECT t FROM TblCommnueEntity t WHERE t.commnueID = :commnueID")
    , @NamedQuery(name = "TblCommnueEntity.findByCommnueName", query = "SELECT t FROM TblCommnueEntity t WHERE t.commnueName = :commnueName")
    , @NamedQuery(name = "TblCommnueEntity.findByCommnueKhName", query = "SELECT t FROM TblCommnueEntity t WHERE t.commnueKhName = :commnueKhName")
    , @NamedQuery(name = "TblCommnueEntity.findByStatus", query = "SELECT t FROM TblCommnueEntity t WHERE t.status = :status")
    , @NamedQuery(name = "TblCommnueEntity.findByDistrictID", query = "SELECT t FROM TblCommnueEntity t WHERE t.districtID = :districtID")})
public class TblCommnueEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CommnueID")
    private Integer commnueID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Commnue_Name")
    private String commnueName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Commnue_KhName")
    private String commnueKhName;
    @Column(name = "Status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DistrictID")
    private int districtID;

    public TblCommnueEntity() {
    }

    public TblCommnueEntity(Integer commnueID) {
        this.commnueID = commnueID;
    }

    public TblCommnueEntity(Integer commnueID, String commnueName, String commnueKhName, int districtID) {
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
        if (!(object instanceof TblCommnueEntity)) {
            return false;
        }
        TblCommnueEntity other = (TblCommnueEntity) object;
        if ((this.commnueID == null && other.commnueID != null) || (this.commnueID != null && !this.commnueID.equals(other.commnueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblCommnueEntity[ commnueID=" + commnueID + " ]";
    }
    
}
