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
@Table(name = "tbl_Nationality", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNationalityEntity.findAll", query = "SELECT t FROM TblNationalityEntity t")
    , @NamedQuery(name = "TblNationalityEntity.findByNationalityID", query = "SELECT t FROM TblNationalityEntity t WHERE t.nationalityID = :nationalityID")
    , @NamedQuery(name = "TblNationalityEntity.findByNationalityName", query = "SELECT t FROM TblNationalityEntity t WHERE t.nationalityName = :nationalityName")
    , @NamedQuery(name = "TblNationalityEntity.findByNationalityKhName", query = "SELECT t FROM TblNationalityEntity t WHERE t.nationalityKhName = :nationalityKhName")
    , @NamedQuery(name = "TblNationalityEntity.findByStatus", query = "SELECT t FROM TblNationalityEntity t WHERE t.status = :status")})
public class TblNationalityEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "NationalityID")
    private Integer nationalityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nationality_Name")
    private String nationalityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nationality_KhName")
    private String nationalityKhName;
    @Column(name = "Status")
    private Integer status;

    public TblNationalityEntity() {
    }

    public TblNationalityEntity(Integer nationalityID) {
        this.nationalityID = nationalityID;
    }

    public TblNationalityEntity(Integer nationalityID, String nationalityName, String nationalityKhName) {
        this.nationalityID = nationalityID;
        this.nationalityName = nationalityName;
        this.nationalityKhName = nationalityKhName;
    }

    public Integer getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(Integer nationalityID) {
        this.nationalityID = nationalityID;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    public String getNationalityKhName() {
        return nationalityKhName;
    }

    public void setNationalityKhName(String nationalityKhName) {
        this.nationalityKhName = nationalityKhName;
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
        hash += (nationalityID != null ? nationalityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNationalityEntity)) {
            return false;
        }
        TblNationalityEntity other = (TblNationalityEntity) object;
        if ((this.nationalityID == null && other.nationalityID != null) || (this.nationalityID != null && !this.nationalityID.equals(other.nationalityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblNationalityEntity[ nationalityID=" + nationalityID + " ]";
    }
    
}
