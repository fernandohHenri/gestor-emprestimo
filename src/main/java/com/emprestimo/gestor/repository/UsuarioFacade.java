/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emprestimo.gestor.repository;

import com.emprestimo.gestor.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olliver
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.mycompany_gestor1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario login(String nomeUsuario, String senha) {
        try {
            Usuario usuario = em.createNamedQuery("Usuario.findByLogin", Usuario.class).
                    setParameter("login", nomeUsuario).getSingleResult();

            if (usuario.getSenha().equals(senha)) {
                return usuario;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao buscar query!");
        }
        return null;
    }

    public Usuario porMatricula(String matricula) {
        try {
            Usuario usuario = em.createNamedQuery("Usuario.findByMatricula", Usuario.class).
                    setParameter("matricula", matricula).getSingleResult();
            return usuario;
        } catch (Exception ex) {
            System.out.println("Erro ao buscar por Matrícula");
        }
        return null;
    }
    
    public Usuario recuperarSenha(String login, String matricula) {
        try {
            Usuario usuario = em.createNamedQuery("Usuario.findByLogin", Usuario.class).
                    setParameter("login", login).getSingleResult();
            if(usuario.getMatricula().equals(matricula))
                return usuario;
        } catch (Exception ex) {
            System.out.println("Erro ao buscar por Matrícula");
        }
        return null;
    }
    
    

    public void salvar(Usuario usuario) {

        em.persist(usuario);
    }
    
}
