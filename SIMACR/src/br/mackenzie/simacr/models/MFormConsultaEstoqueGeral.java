/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeItemEstoque;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author H_W
 */
public class MFormConsultaEstoqueGeral {

    public List<IEntidadeItemEstoque> buscarLista(String nomeTipo) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        String strquery = ("SELECT t FROM EntidadeItemEstoque t");
        if (!nomeTipo.equals("")) {
            strquery = strquery.concat(" WHERE ( nome LIKE '%" + nomeTipo + "%')");
        }
        Query minhaQuery = manager.createQuery(strquery);
        List<IEntidadeItemEstoque> meuRetorno = minhaQuery.getResultList();
        return meuRetorno;
    }
    
    public IEntidadeItemEstoque buscarIIE(String nomeTipo)
    {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        Query queryEst = manager.createQuery("SELECT e FROM EntidadeItemEstoque e WHERE(nome = '" + nomeTipo + "')");
        try {
            EntidadeItemEstoque eIE = (EntidadeItemEstoque) queryEst.getSingleResult(); 
            return eIE;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public List<IEntidadeItemEstoque> buscarUtensilios() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        List<IEntidadeItemEstoque> listaRetorno;
        String strQuery = "SELECT e FROM EntidadeItemEstoque e";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (List<IEntidadeItemEstoque>) minhaQuery.getResultList();
        return listaRetorno;
    }

    
}
