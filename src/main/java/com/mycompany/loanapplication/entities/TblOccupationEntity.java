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
@Table(name = "tbl_Occupation", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOccupationEntity.findAll", query = "SELECT t FROM TblOccupationEntity t")
    , @NamedQuery(name = "TblOccupationEntity.findByOccupationID", query = "SELECT t FROM TblOccupationEntity t WHERE t.occupationID = :occupationID")
    , @NamedQuery(name = "TblOccupationEntity.findByOccupationName", query = "SELECT t FROM TblOccupationEntity t WHERE t.occupationName = :occupationName")
    , @NamedQuery(name = "TblOccupationEntity.findByOccupationKhName", query = "SELECT t FROM TblOccupationEntity t WHERE t.occupationKhName = :occupationKhName")
    , @NamedQuery(name = "TblOccupationEntity.findByStatus", query = "SELECT t FROM TblOccupationEntity t WHERE t.status = :status")})
public class TblOccupationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "OccupationID")
    private Integer occupationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Occupation_Name")
    private String occupationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Occupation_KhName")
    private String occupationKhName;
    @Column(name = "Status")
    private Integer status;

    public TblOccupationEntity() {
    }

    public TblOccupationEntity(Integer occupationID) {
        this.occupationID = occupationID;
    }

    public TblOccupationEntity(Integer occupationID, String occupationName, String occupationKhName) {
        this.occupationID = occupationID;
        this.occupationName = occupationName;
        this.occupationKhName = occupationKhName;
    }

    public Integer getOccupationID() {
        return occupationID;
    }

    public void setOccupationID(Integer occupationID) {
        this.occupationID = occupationID;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public String getOccupationKhName() {
        return occupationKhName;
    }

    public void setOccupationKhName(String occupationKhName) {
        this.occupationKhName = occupationKhName;
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
        hash += (occupationID != null ? occupationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOccupationEntity)) {
            return false;
        }
        TblOccupationEntity other = (TblOccupationEntity) object;
        if ((this.occupationID == null && other.occupationID != null) || (this.occupationID != null && !this.occupationID.equals(other.occupationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblOccupationEntity[ occupationID=" + occupationID + " ]";
    }
    
}
