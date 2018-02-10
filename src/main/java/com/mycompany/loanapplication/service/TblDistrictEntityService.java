/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loanapplication.service;

import com.mycompany.loanapplication.entities.TblDistrictEntity;
import com.mycompany.loanapplication.entities.TblDistrictEntity_Custom;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author boysothymeak
 */
@Stateless
public class TblDistrictEntityService extends AbstractService<TblDistrictEntity> {

    @PersistenceContext(unitName = "com.mycompany_LoanApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDistrictEntityService() {
        super(TblDistrictEntity.class);
    }

    public List<TblDistrictEntity_Custom> getAllDistrict() {
        try {
            String query = "SELECT d.*,p.Province_Name FROM dbo.tbl_District d \n"
                    + "JOIN dbo.tbl_Province p ON d.ProvinceID = p.ProvinceID\n"
                    + "WHERE d.Status=1;";
            return getEntityManager().createNativeQuery(query, TblDistrictEntity_Custom.class)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
