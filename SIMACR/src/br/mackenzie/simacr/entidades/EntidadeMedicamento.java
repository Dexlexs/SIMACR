/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.ILote;
import br.mackenzie.simacr.interfaces.IMedicamento;
import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeMedicamento implements Serializable, IMedicamento {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    public List<EntidadeLote> lotes;
    private String nomeComercial;
    private String principioAtivo;
    private String laboratorio;
    private String formaFarmaceutica;
    private Integer emEstoque = Integer.valueOf(0);
    private Integer reservado = Integer.valueOf(0);

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EntidadeLote> getLotes() {
        return lotes;
    }

    @Override
    public ArrayList<ILote> getILotes() {
        ArrayList<ILote> retorno = new ArrayList<ILote>();
        for (EntidadeLote it : lotes) {
            retorno.add(it);
        }
        return retorno;
    }

    public void setMedicamento_Receita(IReceita_Medicamento var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addLote(EntidadeLote lote) {
        lotes.add(lote);
    }

    public void removeLote(EntidadeLote lote) {
        lotes.remove(lote);
    }

    public void removeTodosLotes() {
        int aux = lotes.size();
        for (; aux > 0; aux--) {
            lotes.remove(0);
        }
    }

    @Override
    public String getNomeComercial() {
        return nomeComercial;
    }

    @Override
    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    @Override
    public String getLaboratorio() {
        return laboratorio;
    }

    @Override
    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setNomeComercial(String var) {
        nomeComercial = var;
    }

    public void setPrincipioAtivo(String var) {
        principioAtivo = var;
    }

    public void setLaboratorio(String var) {
        laboratorio = var;
    }

    @Override
    public Integer getEmEstoque() {
        return emEstoque;
    }

    public void setFormaFarmaceutica(String var) {
        formaFarmaceutica = var;
    }

    public void setEmEstoque(Integer var) {
        emEstoque += var;
    }

    public void setReservado(Integer var) {
        reservado += var;
        emEstoque -= var;
    }

    public void setQuantidadeEntregue(Integer var) {
        reservado -= var;
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
        if (!(object instanceof EntidadeMedicamento)) {
            return false;
        }
        EntidadeMedicamento other = (EntidadeMedicamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeMedicamento[ id=" + id + " ]";
    }

    @Override
    public Integer getEmReserva() {
        return reservado;
    }

    @Override
    public Integer getQtdMedicamento() {
        Integer retorno = 0;
        for (Iterator<EntidadeLote> it = lotes.iterator(); it.hasNext();) {
            EntidadeLote lot = it.next();
            retorno = retorno + lot.getUnidades();
        }
        return retorno;
    }
}