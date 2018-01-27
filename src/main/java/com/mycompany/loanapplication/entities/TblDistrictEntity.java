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
@Table(name = "tbl_District", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDistrictEntity.findAll", query = "SELECT t FROM TblDistrictEntity t")
    , @NamedQuery(name = "TblDistrictEntity.findByDistrictID", query = "SELECT t FROM TblDistrictEntity t WHERE t.districtID = :districtID")
    , @NamedQuery(name = "TblDistrictEntity.findByDistrictName", query = "SELECT t FROM TblDistrictEntity t WHERE t.districtName = :districtName")
    , @NamedQuery(name = "TblDistrictEntity.findByDistrictKhName", query = "SELECT t FROM TblDistrictEntity t WHERE t.districtKhName = :districtKhName")
    , @NamedQuery(name = "TblDistrictEntity.findByStatus", query = "SELECT t FROM TblDistrictEntity t WHERE t.status = :status")
    , @NamedQuery(name = "TblDistrictEntity.findByProvinceID", query = "SELECT t FROM TblDistrictEntity t WHERE t.provinceID = :provinceID")})
public class TblDistrictEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DistrictID")
    private Integer districtID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "District_Name")
    private String districtName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "District_KhName")
    private String districtKhName;
    @Column(name = "Status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProvinceID")
    private int provinceID;

    public TblDistrictEntity() {
    }

    public TblDistrictEntity(Integer districtID) {
        this.districtID = districtID;
    }

    public TblDistrictEntity(Integer districtID, String districtName, String districtKhName, int provinceID) {
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
        if (!(object instanceof TblDistrictEntity)) {
            return false;
        }
        TblDistrictEntity other = (TblDistrictEntity) object;
        if ((this.districtID == null && other.districtID != null) || (this.districtID != null && !this.districtID.equals(other.districtID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblDistrictEntity[ districtID=" + districtID + " ]";
    }
    
}
