/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import br.mackenzie.simacr.interfaces.ILoteItemEstoque;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeItemEstoque implements Serializable, IEntidadeItemEstoque, IEntidadeComUmaString {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    public List<EntidadeLoteItemEstoque> lotes;    
    
    private String nome;
    private Integer quantidade;
    
    public List<EntidadeLoteItemEstoque> getLotes()
    {
        return lotes;
    }
    
    public void addLote(EntidadeLoteItemEstoque lote) {
        lotes.add(lote);
    }

    public void removeLote(EntidadeLoteItemEstoque lote) {
        lotes.remove(lote);
    }    
    
    public void removeTodosLotes() {
        int aux = lotes.size();
        for (; aux > 0; aux--) {
            lotes.remove(0);
        }
    }    
    
    public EntidadeItemEstoque(){
        quantidade=0;
    }
    
    
    @Override
    public String getNome(){
        return nome;
    }
    

    public void setNome(String var){
        nome = var;
    }
    
    @Override
    public Integer getQuantidade(){
        return quantidade;
    }
    

    public void setQuantidade(Integer var){
        quantidade+= var;
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
        if (!(object instanceof EntidadeItemEstoque)) {
            return false;
        }
        EntidadeItemEstoque other = (EntidadeItemEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeItemEstoque[ id=" + id + " ]";
    }

    @Override
    public Integer getTotal() {
        Integer total = 0;
        for(EntidadeLoteItemEstoque it: lotes)
            total+=it.getQuantidade();
        total+=quantidade;
        return total;
    }

    public List<ILoteItemEstoque> getILotes() {
        List<ILoteItemEstoque> retorno = new ArrayList<ILoteItemEstoque>();
        for (ILoteItemEstoque it : lotes) {
            retorno.add(it);
        }
        return retorno;
    }    
}
