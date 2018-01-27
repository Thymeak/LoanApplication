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
@Table(name = "tbl_Department", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartmentEntity.findAll", query = "SELECT t FROM TblDepartmentEntity t")
    , @NamedQuery(name = "TblDepartmentEntity.findByDepartmentID", query = "SELECT t FROM TblDepartmentEntity t WHERE t.departmentID = :departmentID")
    , @NamedQuery(name = "TblDepartmentEntity.findByDepartmentName", query = "SELECT t FROM TblDepartmentEntity t WHERE t.departmentName = :departmentName")
    , @NamedQuery(name = "TblDepartmentEntity.findByDepartmentDescription", query = "SELECT t FROM TblDepartmentEntity t WHERE t.departmentDescription = :departmentDescription")
    , @NamedQuery(name = "TblDepartmentEntity.findByStatus", query = "SELECT t FROM TblDepartmentEntity t WHERE t.status = :status")
    , @NamedQuery(name = "TblDepartmentEntity.findByMainDepartmentID", query = "SELECT t FROM TblDepartmentEntity t WHERE t.mainDepartmentID = :mainDepartmentID")})
public class TblDepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Department_Name")
    private String departmentName;
    @Size(max = 250)
    @Column(name = "Department_Description")
    private String departmentDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Main_DepartmentID")
    private int mainDepartmentID;

    public TblDepartmentEntity() {
    }

    public TblDepartmentEntity(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public TblDepartmentEntity(Integer departmentID, String departmentName, int status, int mainDepartmentID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.status = status;
        this.mainDepartmentID = mainDepartmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMainDepartmentID() {
        return mainDepartmentID;
    }

    public void setMainDepartmentID(int mainDepartmentID) {
        this.mainDepartmentID = mainDepartmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartmentEntity)) {
            return false;
        }
        TblDepartmentEntity other = (TblDepartmentEntity) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblDepartmentEntity[ departmentID=" + departmentID + " ]";
    }
    
}
