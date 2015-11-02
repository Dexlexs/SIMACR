/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeFilaTriagem;
import br.mackenzie.simacr.interfaces.IFilaTriagem;
import br.mackenzie.simacr.interfaces.IPaciente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author root
 */
public class MFormFilaTriagem {

    public IPaciente buscarPaciente(Long idFilaTriagem) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();          
        return manager.find(EntidadeFilaTriagem.class,idFilaTriagem).getPaciente(); 
    }
    


    public ArrayList<IFilaTriagem> buscarFilaTriagem() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();          
        List<IFilaTriagem> meuRetorno;
        
        String strQuery = "SELECT f FROM EntidadeFilaTriagem f";     
        Query minhaQuery = manager.createQuery(strQuery);
        meuRetorno = minhaQuery.getResultList();
        return (ArrayList)meuRetorno;
        }
            
    }
