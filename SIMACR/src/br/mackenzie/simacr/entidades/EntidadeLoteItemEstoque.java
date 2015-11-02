/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.ILoteItemEstoque;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author H_W
 */
@Entity
public class EntidadeLoteItemEstoque implements Serializable,ILoteItemEstoque {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroLote;
    private Integer quantidade;

    public EntidadeLoteItemEstoque() {
    }

    public EntidadeLoteItemEstoque(String varNumeroLote, Integer varQuantidade) {
        numeroLote = varNumeroLote;
        quantidade = varQuantidade;
    }

    @Override
    public String getNumeroLote() {
        return numeroLote;
    }

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setNumeroLote(String var) {
        numeroLote = var;
    }

    public void setQuantidade(Integer var) {
        quantidade = var;
    }

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
        if (!(object instanceof EntidadeLoteItemEstoque)) {
            return false;
        }
        EntidadeLoteItemEstoque other = (EntidadeLoteItemEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeLoteItemEstoque[ id=" + id + " ]";
    }
}
