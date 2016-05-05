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
@Table(name = "agencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a"),
    @NamedQuery(name = "Agencia.findByCodAgencia", query = "SELECT a FROM Agencia a WHERE a.codAgencia = :codAgencia"),
    @NamedQuery(name = "Agencia.findByDependencia", query = "SELECT a FROM Agencia a WHERE a.dependencia = :dependencia"),
    @NamedQuery(name = "Agencia.findByNome", query = "SELECT a FROM Agencia a WHERE a.nome = :nome"),
    @NamedQuery(name = "Agencia.findByPrefixo", query = "SELECT a FROM Agencia a WHERE a.prefixo = :prefixo"),
    @NamedQuery(name = "Agencia.findByUf", query = "SELECT a FROM Agencia a WHERE a.uf = :uf")})
public class Agencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_agencia")
    private Integer codAgencia;
    @Size(max = 255)
    @Column(name = "dependencia")
    private String dependencia;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "prefixo")
    private Integer prefixo;
    @Size(max = 255)
    @Column(name = "uf")
    private String uf;
    @OneToMany(mappedBy = "agenciaCodAgencia", fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimoList;

    public Agencia() {
    }

    public Agencia(Integer codAgencia) {
        this.codAgencia = codAgencia;
    }

    public Integer getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(Integer codAgencia) {
        this.codAgencia = codAgencia;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Integer prefixo) {
        this.prefixo = prefixo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
        hash += (codAgencia != null ? codAgencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agencia)) {
            return false;
        }
        Agencia other = (Agencia) object;
        if ((this.codAgencia == null && other.codAgencia != null) || (this.codAgencia != null && !this.codAgencia.equals(other.codAgencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emprestimo.gestor.model.Agencia[ codAgencia=" + codAgencia + " ]";
    }
    
}
