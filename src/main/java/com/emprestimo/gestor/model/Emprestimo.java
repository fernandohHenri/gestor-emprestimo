/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emprestimo.gestor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Olliver
 */
@Entity
@Table(name = "emprestimo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e"),
    @NamedQuery(name = "Emprestimo.findByIdEmprestimo", query = "SELECT e FROM Emprestimo e WHERE e.idEmprestimo = :idEmprestimo"),
    @NamedQuery(name = "Emprestimo.findByCliente", query = "SELECT e FROM Emprestimo e WHERE e.cliente = :cliente"),
    @NamedQuery(name = "Emprestimo.findByContrapartida", query = "SELECT e FROM Emprestimo e WHERE e.contrapartida = :contrapartida"),
    @NamedQuery(name = "Emprestimo.findByCpf", query = "SELECT e FROM Emprestimo e WHERE e.cpf = :cpf"),
    @NamedQuery(name = "Emprestimo.findByData", query = "SELECT e FROM Emprestimo e WHERE e.data = :data"),
    @NamedQuery(name = "Emprestimo.findByItensFinanciar", query = "SELECT e FROM Emprestimo e WHERE e.itensFinanciar = :itensFinanciar"),
    @NamedQuery(name = "Emprestimo.findByValorFinanciamento", query = "SELECT e FROM Emprestimo e WHERE e.valorFinanciamento = :valorFinanciamento")})
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmprestimo")
    private Integer idEmprestimo;
    @Size(max = 255)
    @Column(name = "cliente")
    private String cliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "contrapartida")
    private Double contrapartida;
    @Size(max = 255)
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 255)
    @Column(name = "itens_financiar")
    private String itensFinanciar;
    @Column(name = "valor_financiamento")
    private Double valorFinanciamento;
    @JoinColumn(name = "agencia_cod_agencia", referencedColumnName = "cod_agencia")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agencia agenciaCodAgencia;
    @JoinColumn(name = "fase_idfases", referencedColumnName = "idfases")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fase faseIdfases;
    @JoinColumn(name = "porte_idporte", referencedColumnName = "idporte")
    @ManyToOne(fetch = FetchType.LAZY)
    private Porte porteIdporte;
    @OneToMany(mappedBy = "emprestimoIdemprestimo", fetch = FetchType.LAZY)
    private List<Registro> registroList;

    public Emprestimo() {
    }

    public Emprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getContrapartida() {
        return contrapartida;
    }

    public void setContrapartida(Double contrapartida) {
        this.contrapartida = contrapartida;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getItensFinanciar() {
        return itensFinanciar;
    }

    public void setItensFinanciar(String itensFinanciar) {
        this.itensFinanciar = itensFinanciar;
    }

    public Double getValorFinanciamento() {
        return valorFinanciamento;
    }

    public void setValorFinanciamento(Double valorFinanciamento) {
        this.valorFinanciamento = valorFinanciamento;
    }

    public Agencia getAgenciaCodAgencia() {
        return agenciaCodAgencia;
    }

    public void setAgenciaCodAgencia(Agencia agenciaCodAgencia) {
        this.agenciaCodAgencia = agenciaCodAgencia;
    }

    public Fase getFaseIdfases() {
        return faseIdfases;
    }

    public void setFaseIdfases(Fase faseIdfases) {
        this.faseIdfases = faseIdfases;
    }

    public Porte getPorteIdporte() {
        return porteIdporte;
    }

    public void setPorteIdporte(Porte porteIdporte) {
        this.porteIdporte = porteIdporte;
    }

    @XmlTransient
    public List<Registro> getRegistroList() {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList) {
        this.registroList = registroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmprestimo != null ? idEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.idEmprestimo == null && other.idEmprestimo != null) || (this.idEmprestimo != null && !this.idEmprestimo.equals(other.idEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emprestimo.gestor.model.Emprestimo[ idEmprestimo=" + idEmprestimo + " ]";
    }
    
}
