/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loanapplication.service;

import com.mycompany.loanapplication.entities.TblDistrictEntity;
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
    
}
