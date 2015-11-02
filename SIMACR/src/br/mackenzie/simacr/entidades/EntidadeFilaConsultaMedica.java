/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IFilaConsulta;
import br.mackenzie.simacr.interfaces.ITriagem;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeFilaConsultaMedica implements Serializable,IFilaConsulta {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private EntidadeTriagem triagem;
   
    
    private String nomePaciente;
    
    private Double temperatura;
    
    public EntidadeFilaConsultaMedica(){}

    public EntidadeFilaConsultaMedica(EntidadeTriagem var)
    {
        triagem = var;
        temperatura = var.getTemperatura();
        nomePaciente = var.getPaciente().getNome();
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
        if (!(object instanceof EntidadeFilaConsultaMedica)) {
            return false;
        }
        EntidadeFilaConsultaMedica other = (EntidadeFilaConsultaMedica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeFilaConsultaMedica[ id=" + id + " ]";
    }
    
    public EntidadeTriagem getTriagem()
    {
        return triagem;
    }

    @Override
    public ITriagem getITriagem() {
        return (ITriagem)triagem;
    }

    @Override
    public String getNome() {
        return nomePaciente;
    }
    
    public void setTemperatura(Double var)
    {
        temperatura = var;
    }
    
    @Override
    public Double getTemperatura()
    {
        return temperatura;
    }
    
}
