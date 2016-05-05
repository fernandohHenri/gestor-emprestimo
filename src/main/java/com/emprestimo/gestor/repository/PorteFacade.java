/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emprestimo.gestor.repository;

import com.emprestimo.gestor.model.Porte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olliver
 */
@Stateless
public class PorteFacade extends AbstractFacade<Porte> {

    @PersistenceContext(unitName = "com.mycompany_gestor1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PorteFacade() {
        super(Porte.class);
    }
    
}
