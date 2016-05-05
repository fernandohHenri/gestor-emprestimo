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
@Table(name = "porte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porte.findAll", query = "SELECT p FROM Porte p"),
    @NamedQuery(name = "Porte.findByIdporte", query = "SELECT p FROM Porte p WHERE p.idporte = :idporte"),
    @NamedQuery(name = "Porte.findByValor", query = "SELECT p FROM Porte p WHERE p.valor = :valor")})
public class Porte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idporte")
    private Integer idporte;
    @Size(max = 255)
    @Column(name = "valor")
    private String valor;
    @OneToMany(mappedBy = "porteIdporte", fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimoList;

    public Porte() {
    }

    public Porte(Integer idporte) {
        this.idporte = idporte;
    }

    public Integer getIdporte() {
        return idporte;
    }

    public void setIdporte(Integer idporte) {
        this.idporte = idporte;
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
        hash += (idporte != null ? idporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porte)) {
            return false;
        }
        Porte other = (Porte) object;
        if ((this.idporte == null && other.idporte != null) || (this.idporte != null && !this.idporte.equals(other.idporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emprestimo.gestor.model.Porte[ idporte=" + idporte + " ]";
    }
    
}
