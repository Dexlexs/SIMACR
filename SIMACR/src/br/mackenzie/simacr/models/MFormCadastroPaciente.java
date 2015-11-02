/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadePaciente;
import br.mackenzie.simacr.entidades.EntidadeRio;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IPaciente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author root
 */
public class MFormCadastroPaciente {

    public void excluir(IPaciente paciente) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        manager.remove(manager.find(EntidadePaciente.class, paciente.getId()));
        //realiza a transacao e sincroniza o BD
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();        
    }

    public void salvar(String nome, String profissao, String comunidade, String rio, String dataNascimento, String telefone, String cor, String naturalidade, String nacionalidade, String estadoCivil, String sexo) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();             
        EntidadePaciente pacienteSalvar = new EntidadePaciente(nome,profissao,comunidade,rio,dataNascimento,telefone,cor,naturalidade,nacionalidade,estadoCivil,sexo);
        manager.persist(pacienteSalvar);

        manager.getTransaction().begin();
        manager.getTransaction().commit();        
        manager.close();
        factory.close();        
    }

    public void atualizar(String nome, String profissao, String comunidade, String rio, String dataNascimento, String telefone, String cor, String naturalidade, String nacionalidade, String estadoCivil, String sexo, IPaciente paciente) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();          
        EntidadePaciente atualizacao = manager.find(EntidadePaciente.class, paciente.getId()); 
        atualizacao.setNome(nome);
        atualizacao.setProfissao(profissao);
        atualizacao.setComunidade(comunidade);
        atualizacao.setRio(rio);
        atualizacao.setDataNascimento(dataNascimento);
        atualizacao.setTelefone(telefone);
        atualizacao.setCor(cor);
        atualizacao.setNaturalidade(naturalidade);
        atualizacao.setNacionalidade(nacionalidade);
        atualizacao.setEstadoCivil(estadoCivil);
        atualizacao.setSexo(sexo);
        manager.getTransaction().begin();
        manager.getTransaction().commit();    
        manager.close();
        factory.close();        
    }

    public Long getIDRio(String nomeRio) {
        if(nomeRio.equals("") || nomeRio.equals("null"))
            return null;        
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        Query queryRio = manager.createQuery("SELECT e FROM EntidadeRio e WHERE(nomeRio = '" + nomeRio + "')");
        EntidadeRio ER = (EntidadeRio)queryRio.getSingleResult();
        return ER.getId();
    }

    public ArrayList<IEntidadeComUmaString> getRios() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ArrayList<IEntidadeComUmaString> listaRetorno;
        String strQuery = "SELECT e FROM EntidadeRio e";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (ArrayList<IEntidadeComUmaString>) minhaQuery.getResultList();
        return listaRetorno;
    }

    public ArrayList<IEntidadeComUmaString> getPeles() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ArrayList<IEntidadeComUmaString> listaRetorno;
        String strQuery = "SELECT e FROM EntidadeCorDePele e";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (ArrayList<IEntidadeComUmaString>) minhaQuery.getResultList();
        return listaRetorno;
    }

    public ArrayList<IEntidadeComUmaString> getComunidades(Long idRio) {
        if(idRio==null)
            return new ArrayList<IEntidadeComUmaString>();
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        
        ArrayList<IEntidadeComUmaString> listaRetorno;
        String strQuery = "SELECT e FROM EntidadeComunidade e WHERE(rio = '" + idRio + "')";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (ArrayList<IEntidadeComUmaString>) minhaQuery.getResultList();
        return listaRetorno;
    }


    
}
