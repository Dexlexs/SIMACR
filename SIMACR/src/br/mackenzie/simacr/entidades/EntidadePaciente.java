/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IPaciente;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author root
 */
@Entity
public class EntidadePaciente implements Serializable,IPaciente {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String dataNascimento;
    private String profissao;
    private String cor;
    private String naturalidade;
    private String nacionalidade;
    private String comunidade;
    private String rio;
    private String estadoCivil;
    private String sexo;
    private String telefone;    
    
    
    public EntidadePaciente(String _nome, String _profissao, String _comunidade, String _rio, String _dataNascimento, String _telefone, String _cor, String _naturalidade, String _nacionalidade, String _estadoCivil, String _sexo)
    {
        nome = _nome;
        profissao = _profissao;
        comunidade = _comunidade;
        rio = _rio;
        dataNascimento = _dataNascimento;
        telefone = _telefone;
        cor = _cor;
        naturalidade = _naturalidade;
        nacionalidade = _nacionalidade;
        estadoCivil = _estadoCivil;
        sexo = _sexo;
    }
    
    public EntidadePaciente(){}
    
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
        if (!(object instanceof EntidadePaciente)) {
            return false;
        }
        EntidadePaciente other = (EntidadePaciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadePaciente[ id=" + id + " ]";
    }
/*
    @Override
    public ArrayList<ITriagem> getTriagem() {
        ArrayList<ITriagem> retorno = new ArrayList<ITriagem>();
        for(ITriagem tri: triagens)
            retorno.add(tri);
        return retorno;
    }

    @Override
    public void setTriagem(ITriagem var) {
        triagens.add((EntidadeTriagem)var);
    }*/

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String getProfissao() {
        return profissao;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String getNaturalidade() {
        return naturalidade;
    }

    @Override
    public String getComunidade() {
        return comunidade;
    }

    @Override
    public String getRio() {
        return rio;
    }

    @Override
    public String getEstadoCivil() {
        return estadoCivil;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setNome(String var) {
        nome = var;
    }

    @Override
    public void setDataNascimento(String var) {
        dataNascimento = var;
    }

    @Override
    public void setProfissao(String var) {
        profissao = var;
    }

    @Override
    public void setCor(String var) {
        cor = var;
    }

    @Override
    public void setNacionalidade(String var) {
        nacionalidade = var;
    }

    @Override
    public void setNaturalidade(String var) {
        naturalidade = var;
    }

    @Override
    public void setComunidade(String var) {
        comunidade = var;
    }

    @Override
    public void setRio(String var) {
        rio = var;
    }

    @Override
    public void setEstadoCivil(String var) {
        estadoCivil = var;
    }

    @Override
    public void setSexo(String var) {
        sexo = var;
    }

    @Override
    public void setTelefone(String var) {
        telefone = var;
    }
    
}
