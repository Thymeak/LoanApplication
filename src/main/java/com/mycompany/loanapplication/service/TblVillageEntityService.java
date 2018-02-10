/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loanapplication.service;

import com.mycompany.loanapplication.entities.TblVillageEntity;
import com.mycompany.loanapplication.entities.TblVillageEntity_Custom;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author boysothymeak
 */
@Stateless
public class TblVillageEntityService extends AbstractService<TblVillageEntity> {

    @PersistenceContext(unitName = "com.mycompany_LoanApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblVillageEntityService() {
        super(TblVillageEntity.class);
    }

    public List<TblVillageEntity_Custom> getAllVillage() {
        try {
            String query = "SELECT v.*,c.Commnue_Name FROM dbo.tbl_Village v\n"
                    + "JOIN dbo.tbl_Commnue c ON v.CommnueID = c.CommnueID\n"
                    + "WHERE v.Status=1;";
            return getEntityManager().createNativeQuery(query, TblVillageEntity_Custom.class)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
