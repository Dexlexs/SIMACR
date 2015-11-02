/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IReceita;
import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import br.mackenzie.simacr.interfaces.ITriagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class EntidadeReceita implements Serializable,IReceita {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private List<EntidadeReceita_Medicamento> medicamentos;

    
    @ManyToOne
    private EntidadeTripulante tripulante;

   
    
    @ManyToOne
    private EntidadeTriagem triagem;
    
    private boolean aviado;
    private int tipo;

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
        if (!(object instanceof EntidadeReceita)) {
            return false;
        }
        EntidadeReceita other = (EntidadeReceita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public EntidadeReceita()
    {
        aviado = false;
        medicamentos = new ArrayList<EntidadeReceita_Medicamento>();
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeReceita[ id=" + id + " ]";
    }

    @Override
    public boolean getAviado() {
        return aviado;
    }

    @Override
    public ArrayList<IReceita_Medicamento> getIReceita_Medicamento() {
      ArrayList<IReceita_Medicamento> recmed = new ArrayList<IReceita_Medicamento>();
      for(EntidadeReceita_Medicamento rm: medicamentos)
          recmed.add(rm);
      return recmed;
      
    }
    
    public List<EntidadeReceita_Medicamento> getReceita_Medicamento()
    {
        return medicamentos;
    }
    
    public void addReceita_Medicamento(EntidadeReceita_Medicamento var)
    {
        medicamentos.add(var);
    }
    
    public void setReceita_Medicamento(ArrayList<EntidadeReceita_Medicamento> var)
    {
        medicamentos = var;
    }
    
    public void setAviado()
    {
        aviado = true;
    }
    
    public void setTipo(int var)
    {
        tipo = var;
    }
    
    public int getTipo()
    {
        return tipo;
    }

    @Override
    public ITriagem getITriagem() {
        return (ITriagem)triagem;
    }
    
    public EntidadeTriagem getTriagem()
    {
        return triagem;
    }
    
    public void setTriagem(EntidadeTriagem var)
    {
        triagem = var;
    }
    
       public void setTripulante(EntidadeTripulante var)
    {
        tripulante = var;
    }

    
    public EntidadeTripulante getTripulante()
    {
        return tripulante;
    }
   
    
    
    
}
