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
@Table(name = "tbl_Province", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProvinceEntity.findAll", query = "SELECT t FROM TblProvinceEntity t")
    , @NamedQuery(name = "TblProvinceEntity.findByProvinceID", query = "SELECT t FROM TblProvinceEntity t WHERE t.provinceID = :provinceID")
    , @NamedQuery(name = "TblProvinceEntity.findByProvinceName", query = "SELECT t FROM TblProvinceEntity t WHERE t.provinceName = :provinceName")
    , @NamedQuery(name = "TblProvinceEntity.findByProvinceKhName", query = "SELECT t FROM TblProvinceEntity t WHERE t.provinceKhName = :provinceKhName")
    , @NamedQuery(name = "TblProvinceEntity.findByStatus", query = "SELECT t FROM TblProvinceEntity t WHERE t.status = :status")})
public class TblProvinceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProvinceID")
    private Integer provinceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Province_Name")
    private String provinceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Province_KhName")
    private String provinceKhName;
    @Column(name = "Status")
    private Integer status;

    public TblProvinceEntity() {
    }

    public TblProvinceEntity(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public TblProvinceEntity(Integer provinceID, String provinceName, String provinceKhName) {
        this.provinceID = provinceID;
        this.provinceName = provinceName;
        this.provinceKhName = provinceKhName;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceKhName() {
        return provinceKhName;
    }

    public void setProvinceKhName(String provinceKhName) {
        this.provinceKhName = provinceKhName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceID != null ? provinceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProvinceEntity)) {
            return false;
        }
        TblProvinceEntity other = (TblProvinceEntity) object;
        if ((this.provinceID == null && other.provinceID != null) || (this.provinceID != null && !this.provinceID.equals(other.provinceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblProvinceEntity[ provinceID=" + provinceID + " ]";
    }
    
}
