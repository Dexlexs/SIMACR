/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IMedicamento;
import br.mackenzie.simacr.interfaces.IReceita;
import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeReceita_Medicamento implements Serializable,IReceita_Medicamento {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private EntidadeReceita receita;
    
    @OneToOne
    private EntidadeMedicamento medicamento;
    
    private String prescricao;
    private Integer quantidade;

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
        if (!(object instanceof EntidadeReceita_Medicamento)) {
            return false;
        }
        EntidadeReceita_Medicamento other = (EntidadeReceita_Medicamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.models.EntidadeReceita_Medicamento[ id=" + id + " ]";
    }

    @Override
    public IReceita getIReceita() {
        return (IReceita)receita;
    }

    @Override
    public IMedicamento getIMedicamento() {
        return (IMedicamento)medicamento;
    }

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String getPrescricao() {
        return prescricao;
    }
    
    public void setQuantidade(Integer var)
    {
        quantidade = var;
    }
    
    public void setPrescricao(String var)
    {
        prescricao = var;
    }
    
    public void setReceita(EntidadeReceita var)
    {
        receita = var;
    }
    
    public void setMedicamento(EntidadeMedicamento var)
    {
        medicamento = var;
    }
    
    public EntidadeReceita getReceita()
    {
        return receita;
    }
    
    public EntidadeMedicamento getMedicamento()
    {
        return medicamento;
    }


    
    
}
