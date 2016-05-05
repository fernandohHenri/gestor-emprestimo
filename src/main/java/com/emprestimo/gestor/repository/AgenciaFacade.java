/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emprestimo.gestor.repository;

import com.emprestimo.gestor.model.Agencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olliver
 */
@Stateless
public class AgenciaFacade extends AbstractFacade<Agencia> {

    @PersistenceContext(unitName = "com.mycompany_gestor1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenciaFacade() {
        super(Agencia.class);
    }
    
    public Agencia porId(Integer codAgencia) {
        Agencia retorno = null;
        try {
            retorno = em.createNamedQuery("Agencia.findByCodAgencia", Agencia.class).
                    setParameter("cod_agencia", codAgencia).getSingleResult();
            System.out.println("Retorno porID = "+ retorno.getNome());

        } catch (Exception ex) {
            System.out.println("Erro ao buscar query!");
        }
        return retorno;
    }
    
}
