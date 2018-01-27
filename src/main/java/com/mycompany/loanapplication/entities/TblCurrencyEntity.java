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
@Table(name = "tbl_Currency", catalog = "dbLoanApplication", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCurrencyEntity.findAll", query = "SELECT t FROM TblCurrencyEntity t WHERE t.status = 1")
    , @NamedQuery(name = "TblCurrencyEntity.findByCurrencyID", query = "SELECT t FROM TblCurrencyEntity t WHERE t.currencyID = :currencyID")
    , @NamedQuery(name = "TblCurrencyEntity.findByCurrencyCode", query = "SELECT t FROM TblCurrencyEntity t WHERE t.currencyCode = :currencyCode")
    , @NamedQuery(name = "TblCurrencyEntity.findByCurrencyName", query = "SELECT t FROM TblCurrencyEntity t WHERE t.currencyName = :currencyName")
    , @NamedQuery(name = "TblCurrencyEntity.findByCurrencySymbol", query = "SELECT t FROM TblCurrencyEntity t WHERE t.currencySymbol = :currencySymbol")
    , @NamedQuery(name = "TblCurrencyEntity.findByStatus", query = "SELECT t FROM TblCurrencyEntity t WHERE t.status = :status")})
public class TblCurrencyEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CurrencyID")
    private Integer currencyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CurrencyCode")
    private String currencyCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CurrencyName")
    private String currencyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CurrencySymbol")
    private String currencySymbol;
    @Column(name = "Status")
    private Integer status;

    public TblCurrencyEntity() {
    }

    public TblCurrencyEntity(Integer currencyID) {
        this.currencyID = currencyID;
    }

    public TblCurrencyEntity(Integer currencyID, String currencyCode, String currencyName, String currencySymbol) {
        this.currencyID = currencyID;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
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
        hash += (currencyID != null ? currencyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCurrencyEntity)) {
            return false;
        }
        TblCurrencyEntity other = (TblCurrencyEntity) object;
        if ((this.currencyID == null && other.currencyID != null) || (this.currencyID != null && !this.currencyID.equals(other.currencyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.loanapplication.TblCurrencyEntity[ currencyID=" + currencyID + " ]";
    }
    
}
