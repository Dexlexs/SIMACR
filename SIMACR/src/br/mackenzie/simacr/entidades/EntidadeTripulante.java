/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.ILogin;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeTripulante implements Serializable, ITripulante {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private EntidadeLogin login;
    
    private String nome;
    private String sexo;
    private String profissao;
    private String telefone;
    private String naturalidade;
    private String dataNascimento;

    public EntidadeTripulante() {
    }
    
    //Sempre que for feito um construtor com parametros, é necessário colocar um 
    public EntidadeTripulante(String nome, String dataNascimento,  String naturalidade, String telefone, String profissao, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
        this.profissao = profissao;
        this.telefone = telefone;
        this.naturalidade = naturalidade;
        this.dataNascimento = dataNascimento;
    }    

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public EntidadeLogin getLogin()
    {
        return login;
    }
   
    @Override
    public ILogin getILogin()
    {
        return (ILogin)login;
    }
    
    public void setLogin(EntidadeLogin var)
    {
        login = var;
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
        if (!(object instanceof EntidadeTripulante)) {
            return false;
        }
        EntidadeTripulante other = (EntidadeTripulante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public String getNaturalidade() {
        return naturalidade;
    }

    @Override
    public String getProfissao() {
        return profissao;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public String getNascimento() {
        return dataNascimento;
    }


    public void setNome(String var) {
        nome = var;
    }


    public void setProfissao(String var) {
        profissao = var;
    }


    public void setNaturalidade(String var) {
        naturalidade = var;
    }


    public void setTelefone(String var) {
        telefone = var;
    }


    public void setSexo(String var) {
        sexo = var;
    }


    public void setData(String var) {
        dataNascimento = var;
    }
    
    
}