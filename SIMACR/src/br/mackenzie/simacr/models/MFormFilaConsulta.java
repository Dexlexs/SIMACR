package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeFilaConsultaMedica;
import br.mackenzie.simacr.entidades.EntidadeFilaConsultaOdontologica;
import java.util.ArrayList;

import br.mackenzie.simacr.interfaces.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class MFormFilaConsulta {
	
	public ArrayList<IFilaConsulta> buscaTriagens(boolean tipo)
	{
                        ArrayList<IFilaConsulta> retorno;
                        EntityManagerFactory factory;
                        EntityManager manager;
                        factory = Persistence.createEntityManagerFactory("simacrJPA");
                        manager = factory.createEntityManager();     
                        String strQuery;
                        if(tipo)
                        strQuery = "SELECT f FROM EntidadeFilaConsultaMedica f";     
                        else
                            strQuery = "SELECT f FROM EntidadeFilaConsultaOdontologica f";     
                        Query minhaQuery = manager.createQuery(strQuery);
                        retorno = (ArrayList<IFilaConsulta>) minhaQuery.getResultList();
                        return retorno;
	}
        

	
	public ITriagem buscaTriagem(Long var,boolean tipo)
	{
                        EntityManagerFactory factory;
                        EntityManager manager;
                        factory = Persistence.createEntityManagerFactory("simacrJPA");
                        manager = factory.createEntityManager();      
                        if(tipo)
                            return manager.find(EntidadeFilaConsultaMedica.class,var).getTriagem(); 
                        else
                            return manager.find(EntidadeFilaConsultaOdontologica.class,var).getTriagem(); 
	}
	
	
}
