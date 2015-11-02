/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IFilaTriagem;
import br.mackenzie.simacr.interfaces.IPaciente;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeFilaTriagem implements Serializable,IFilaTriagem {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private EntidadePaciente paciente;
    
    private String nomePaciente;

    public EntidadeFilaTriagem() {}
    
    public EntidadeFilaTriagem(EntidadePaciente var)
    {
        paciente = var;
        nomePaciente = paciente.getNome();
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
        if (!(object instanceof EntidadeFilaTriagem)) {
            return false;
        }
        EntidadeFilaTriagem other = (EntidadeFilaTriagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeFilaTriagem[ id=" + id + " ]";
    }

    public EntidadePaciente getPaciente() {
        return paciente;
    }



    @Override
    public IPaciente getIPaciente() {
        return (IPaciente)paciente;
    }
    

}
