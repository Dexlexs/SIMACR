/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.ILote;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeLote implements Serializable, ILote {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numeroLote;
    private String validade;
    private Integer unidades;
    private String adquirido;
    

    public EntidadeLote() {
    }

    public EntidadeLote(String numeroLote, String validade, int unidades) {
        this.numeroLote = numeroLote;
        this.validade = validade;
        this.unidades = unidades;
    }
  

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadeLote)) {
            return false;
        }
        EntidadeLote other = (EntidadeLote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeLote[ id=" + id + " ]";
    }

    @Override
    public String getValidade() {
        return validade;
    }

    @Override
    public Integer getUnidades() {
        return unidades;
    }

    public void setValidade(String var) {
        this.validade = var;
    }

    public void setUnidades(Integer var) {
        this.unidades = var;
    }

    @Override
    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String var) {
        numeroLote = var;
    }
    
    public void setAdquirido(String var)
    {
        adquirido = var;
    }
    
    @Override
    public String getAdquirido()
    {
        return adquirido;
    }
    
}