/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emprestimo.gestor.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Olliver
 */
@Entity
@Table(name = "navegacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Navegacao.findAll", query = "SELECT n FROM Navegacao n"),
    @NamedQuery(name = "Navegacao.findByIdnavegacao", query = "SELECT n FROM Navegacao n WHERE n.idnavegacao = :idnavegacao"),
    @NamedQuery(name = "Navegacao.findByData", query = "SELECT n FROM Navegacao n WHERE n.data = :data"),
    @NamedQuery(name = "Navegacao.findByPagina", query = "SELECT n FROM Navegacao n WHERE n.pagina = :pagina")})
public class Navegacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnavegacao")
    private Integer idnavegacao;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 255)
    @Column(name = "pagina")
    private String pagina;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioIdusuario;

    public Navegacao() {
    }

    public Navegacao(Integer idnavegacao) {
        this.idnavegacao = idnavegacao;
    }

    public Integer getIdnavegacao() {
        return idnavegacao;
    }

    public void setIdnavegacao(Integer idnavegacao) {
        this.idnavegacao = idnavegacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnavegacao != null ? idnavegacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Navegacao)) {
            return false;
        }
        Navegacao other = (Navegacao) object;
        if ((this.idnavegacao == null && other.idnavegacao != null) || (this.idnavegacao != null && !this.idnavegacao.equals(other.idnavegacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emprestimo.gestor.model.Navegacao[ idnavegacao=" + idnavegacao + " ]";
    }
    
}
