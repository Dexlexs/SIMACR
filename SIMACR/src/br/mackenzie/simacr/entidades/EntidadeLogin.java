/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.ILogin;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeLogin implements Serializable,ILogin {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private EntidadeTripulante tripulante;
    private String nome;
    private String senha;

    public EntidadeLogin() {
    }

    public EntidadeLogin(String nome, EntidadeTripulante tripulante, String senha) {
        this.nome = nome;
        this.tripulante = tripulante;
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public ITripulante getITripulante() {
        return tripulante;
    }

    public EntidadeTripulante getTripulante() {
        return tripulante;
    }

    public void setTripulante(EntidadeTripulante var) {
        tripulante = var;
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
        if (!(object instanceof EntidadeLogin)) {
            return false;
        }
        EntidadeLogin other = (EntidadeLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeLogin[ id=" + id + " ]";
    }
}