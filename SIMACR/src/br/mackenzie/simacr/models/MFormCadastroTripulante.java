/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeLogin;
import br.mackenzie.simacr.entidades.EntidadeTripulante;
import br.mackenzie.simacr.interfaces.ITripulante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MFormCadastroTripulante {

    //Metodo Pronto
    public void excluir(Long var) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeTripulante remover = manager.find(EntidadeTripulante.class, var);
        manager.remove(remover.getLogin());
        manager.remove(remover);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
    }

    //apenas para ser usado no construtor
    public ITripulante buscaTripulante(Long varId) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ITripulante tripulanteBuscar = manager.find(EntidadeTripulante.class, varId);

        return tripulanteBuscar;
    }

    //Metodo pronto
    public void salvar(String varNome, String varNascimento, String varNaturalidade, String varTelefone, String varProfissao, String varSexo, String varLogin, String varSenha) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeTripulante tripulante = new EntidadeTripulante(varNome, varNascimento, varNaturalidade, varTelefone, varProfissao, varSexo);
        EntidadeLogin login = new EntidadeLogin();
        login.setNome(varLogin);
        login.setSenha(varSenha);
        tripulante.setLogin(login);
        login.setTripulante(tripulante);
        manager.persist(tripulante);
        manager.persist(login);
        manager.getTransaction().begin();
        manager.getTransaction().commit();

    }
    //Metodo pronto

    public void atualizar(String varNome, String varNascimento, String varNaturalidade, String varTelefone, String varProfissao, String varSexo, String varLogin, String varSenha, Long id) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeTripulante tripulante = new EntidadeTripulante(varNome, varNascimento, varNaturalidade, varTelefone, varProfissao, varSexo);
        EntidadeTripulante tripulanteAtualizar = manager.find(EntidadeTripulante.class, id);
        tripulanteAtualizar.setNome(tripulante.getNome());
        tripulanteAtualizar.setNaturalidade(tripulante.getNaturalidade());
        tripulanteAtualizar.setTelefone(tripulante.getTelefone());
        tripulanteAtualizar.setProfissao(tripulante.getProfissao());
        tripulanteAtualizar.setSexo(tripulante.getSexo());
        tripulanteAtualizar.setData(tripulante.getNascimento());
        EntidadeLogin loginAtualizar = tripulanteAtualizar.getLogin();
        loginAtualizar.setNome(varLogin);
        loginAtualizar.setSenha(varSenha);
        manager.getTransaction().begin();
        manager.getTransaction().commit();

    }
}
