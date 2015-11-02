/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeComunidade implements Serializable,IEntidadeComUmaString {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private EntidadeRio rio;
    
    private String nomeComunidade;

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
        if (!(object instanceof EntidadeComunidade)) {
            return false;
        }
        EntidadeComunidade other = (EntidadeComunidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String getNome()
    {
        return nomeComunidade;
    }
    
    public void setNomeComunidade(String var)
    {
        nomeComunidade = var;
    }
    
    public void setRio(EntidadeRio var)
    {
        rio = var;
    }
    
    public EntidadeRio getRio()
    {
        return rio;
    }
    
}
