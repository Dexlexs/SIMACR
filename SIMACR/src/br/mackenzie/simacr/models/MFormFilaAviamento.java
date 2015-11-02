/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.interfaces.IFilaAviamento;
import br.mackenzie.simacr.interfaces.IReceita;
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
public class MFormFilaAviamento {

    public ArrayList<IFilaAviamento> carregarFila() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();      
        List<IFilaAviamento> meuRetorno;
        
        String strQuery = "SELECT f FROM EntidadeFilaAviamento f";     
        Query minhaQuery = manager.createQuery(strQuery);
        meuRetorno = minhaQuery.getResultList();
        return (ArrayList)meuRetorno;        
    }
    
}
