/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emprestimo.gestor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Olliver
 */
@Entity
@Table(name = "fase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fase.findAll", query = "SELECT f FROM Fase f"),
    @NamedQuery(name = "Fase.findByIdfases", query = "SELECT f FROM Fase f WHERE f.idfases = :idfases"),
    @NamedQuery(name = "Fase.findByValor", query = "SELECT f FROM Fase f WHERE f.valor = :valor")})
public class Fase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfases")
    private Integer idfases;
    @Size(max = 255)
    @Column(name = "valor")
    private String valor;
    @OneToMany(mappedBy = "faseIdfases", fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimoList;

    public Fase() {
    }

    public Fase(Integer idfases) {
        this.idfases = idfases;
    }

    public Integer getIdfases() {
        return idfases;
    }

    public void setIdfases(Integer idfases) {
        this.idfases = idfases;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<Emprestimo> getEmprestimoList() {
        return emprestimoList;
    }

    public void setEmprestimoList(List<Emprestimo> emprestimoList) {
        this.emprestimoList = emprestimoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfases != null ? idfases.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fase)) {
            return false;
        }
        Fase other = (Fase) object;
        if ((this.idfases == null && other.idfases != null) || (this.idfases != null && !this.idfases.equals(other.idfases))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emprestimo.gestor.model.Fase[ idfases=" + idfases + " ]";
    }
    
}
