/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IConsultaOdontologica;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeConsultaOdontologica implements Serializable, IConsultaOdontologica {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private EntidadeTriagem triagem;
    
    @ManyToOne
    private EntidadeTripulante responsavel;
    
    private String dataConsulta;
    private String evolucaoClinica;
    private String observacoes;

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
        if (!(object instanceof EntidadeConsultaOdontologica)) {
            return false;
        }
        EntidadeConsultaOdontologica other = (EntidadeConsultaOdontologica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeConsultaOdontologica[ id=" + id + " ]";
    }

    @Override
    public ITriagem getITriagem() {
        return (ITriagem) triagem;
    }

    @Override
    public String getEvolucao() {
        return evolucaoClinica;
    }

    @Override
    public String getObservacao() {
        return observacoes;
    }

    @Override
    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String var) {
        dataConsulta = var;
    }

    public void setTriagem(EntidadeTriagem var) {
        triagem = var;
    }
    
    public void setEvolucao(String var)
    {
        evolucaoClinica = var;
    }
    
    public void setObservacoes(String var)
    {
        observacoes = var;
    }
    
    public void setResponsavel(EntidadeTripulante var)
    {
        responsavel = var;
    }
    
    @Override
    public ITripulante getResponsavel()
    {
        return responsavel;
    }    
}
