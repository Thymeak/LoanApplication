/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loanapplication.service;

import com.mycompany.loanapplication.entities.TblCommnueEntity;
import com.mycompany.loanapplication.entities.TblCommuneEntity_Custom;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author boysothymeak
 */
@Stateless
public class TblCommnueEntityService extends AbstractService<TblCommnueEntity> {

    @PersistenceContext(unitName = "com.mycompany_LoanApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblCommnueEntityService() {
        super(TblCommnueEntity.class);
    }

    public List<TblCommuneEntity_Custom> getAllCommune() {
        try {
            String query = "SELECT c.*,d.District_Name FROM dbo.tbl_Commnue c \n"
                    + "JOIN dbo.tbl_District d ON c.DistrictID = d.DistrictID\n"
                    + "WHERE c.Status=1;";
            return getEntityManager().createNativeQuery(query, TblCommuneEntity_Custom.class)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
