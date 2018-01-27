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
@Table(name = "tbl_Position", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPositionEntity.findAll", query = "SELECT t FROM TblPositionEntity t")
    , @NamedQuery(name = "TblPositionEntity.findByPositionID", query = "SELECT t FROM TblPositionEntity t WHERE t.positionID = :positionID")
    , @NamedQuery(name = "TblPositionEntity.findByPositionName", query = "SELECT t FROM TblPositionEntity t WHERE t.positionName = :positionName")
    , @NamedQuery(name = "TblPositionEntity.findByPositionKhName", query = "SELECT t FROM TblPositionEntity t WHERE t.positionKhName = :positionKhName")
    , @NamedQuery(name = "TblPositionEntity.findByPositionDescription", query = "SELECT t FROM TblPositionEntity t WHERE t.positionDescription = :positionDescription")
    , @NamedQuery(name = "TblPositionEntity.findByStatus", query = "SELECT t FROM TblPositionEntity t WHERE t.status = :status")
    , @NamedQuery(name = "TblPositionEntity.findByDepartmentID", query = "SELECT t FROM TblPositionEntity t WHERE t.departmentID = :departmentID")})
public class TblPositionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PositionID")
    private Integer positionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Position_Name")
    private String positionName;
    @Size(max = 250)
    @Column(name = "Position_KhName")
    private String positionKhName;
    @Size(max = 250)
    @Column(name = "Position_Description")
    private String positionDescription;
    @Column(name = "Status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepartmentID")
    private int departmentID;

    public TblPositionEntity() {
    }

    public TblPositionEntity(Integer positionID) {
        this.positionID = positionID;
    }

    public TblPositionEntity(Integer positionID, String positionName, int departmentID) {
        this.positionID = positionID;
        this.positionName = positionName;
        this.departmentID = departmentID;
    }

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionKhName() {
        return positionKhName;
    }

    public void setPositionKhName(String positionKhName) {
        this.positionKhName = positionKhName;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionID != null ? positionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPositionEntity)) {
            return false;
        }
        TblPositionEntity other = (TblPositionEntity) object;
        if ((this.positionID == null && other.positionID != null) || (this.positionID != null && !this.positionID.equals(other.positionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblPositionEntity[ positionID=" + positionID + " ]";
    }
    
}
