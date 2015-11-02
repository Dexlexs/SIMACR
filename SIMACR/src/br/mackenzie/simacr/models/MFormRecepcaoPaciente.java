/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeFilaTriagem;
import br.mackenzie.simacr.entidades.EntidadePaciente;
import br.mackenzie.simacr.entidades.EntidadeRio;
import br.mackenzie.simacr.entidades.EntidadeTriagem;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
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
public class MFormRecepcaoPaciente {

    public ArrayList<IPaciente> buscarPaciente(String nome, String comunidade, String rio) 
    {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();    
        List<IPaciente> meuRetorno;
        
        String strQuery = "SELECT p FROM EntidadePaciente p";
        boolean primeiro = true;
        if(!(nome.trim()).equals(""))
        {
            if(primeiro)
            {
                strQuery = strQuery.concat(" WHERE ( nome LIKE '%" + nome + "%')");
                primeiro = false;
            }
        }
        if(!(comunidade.trim()).equals(""))
        {
            if(primeiro)
            {
                strQuery = strQuery.concat(" WHERE ( comunidade LIKE '%" + comunidade + "%')");
                primeiro = false;
            }
            else
                strQuery = strQuery.concat(" AND ( comunidade LIKE '%" + comunidade + "%')");
        }
        if(!(rio.trim()).equals(""))
        {
            if(primeiro)
            {
                strQuery = strQuery.concat(" WHERE ( rio LIKE '%" + rio + "%')");
                primeiro = false;
            }
            else
                strQuery = strQuery.concat(" AND ( rio LIKE '%" + rio + "%')");
        }
        
        Query minhaQuery = manager.createQuery(strQuery);
        meuRetorno = minhaQuery.getResultList();        
        return (ArrayList)meuRetorno;
        
        
    }

    public IPaciente buscarPaciente(Long var) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        IPaciente paciente = manager.find(EntidadePaciente.class, var);
        return paciente;
    }

    public void adicionarTriagem(IPaciente buscarPaciente) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();     
        EntidadeFilaTriagem triagemFila = new EntidadeFilaTriagem(manager.find(EntidadePaciente.class, buscarPaciente.getId()));
        manager.persist(triagemFila);
        manager.getTransaction().begin();
        manager.getTransaction().commit();           
        
    }

    public ArrayList<IEntidadeComUmaString> getComunidades(String nomeRio) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ArrayList<IEntidadeComUmaString> listaRetorno;
        Query queryRio = manager.createQuery("SELECT e FROM EntidadeRio e WHERE(nomeRio = '" + nomeRio + "')");
        EntidadeRio ER = (EntidadeRio) queryRio.getSingleResult();
        Long idRio = ER.getId();
        String strQuery = "SELECT e FROM EntidadeComunidade e WHERE(rio = '" + idRio + "')";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (ArrayList<IEntidadeComUmaString>) minhaQuery.getResultList();   
        return listaRetorno;
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
    
    
    
}
