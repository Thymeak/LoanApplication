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
@Table(name = "tbl_Relationship", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRelationshipEntity.findAll", query = "SELECT t FROM TblRelationshipEntity t")
    , @NamedQuery(name = "TblRelationshipEntity.findByRelationshipID", query = "SELECT t FROM TblRelationshipEntity t WHERE t.relationshipID = :relationshipID")
    , @NamedQuery(name = "TblRelationshipEntity.findByRelationshipName", query = "SELECT t FROM TblRelationshipEntity t WHERE t.relationshipName = :relationshipName")
    , @NamedQuery(name = "TblRelationshipEntity.findByStatus", query = "SELECT t FROM TblRelationshipEntity t WHERE t.status = :status")})
public class TblRelationshipEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "RelationshipID")
    private Integer relationshipID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Relationship_Name")
    private String relationshipName;
    @Column(name = "Status")
    private Integer status;

    public TblRelationshipEntity() {
    }

    public TblRelationshipEntity(Integer relationshipID) {
        this.relationshipID = relationshipID;
    }

    public TblRelationshipEntity(Integer relationshipID, String relationshipName) {
        this.relationshipID = relationshipID;
        this.relationshipName = relationshipName;
    }

    public Integer getRelationshipID() {
        return relationshipID;
    }

    public void setRelationshipID(Integer relationshipID) {
        this.relationshipID = relationshipID;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
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
        hash += (relationshipID != null ? relationshipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRelationshipEntity)) {
            return false;
        }
        TblRelationshipEntity other = (TblRelationshipEntity) object;
        if ((this.relationshipID == null && other.relationshipID != null) || (this.relationshipID != null && !this.relationshipID.equals(other.relationshipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblRelationshipEntity[ relationshipID=" + relationshipID + " ]";
    }
    
}
