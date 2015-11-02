package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeConsultaMedica;
import br.mackenzie.simacr.entidades.EntidadeConsultaOdontologica;
import br.mackenzie.simacr.entidades.EntidadeFilaConsultaMedica;
import br.mackenzie.simacr.entidades.EntidadeFilaConsultaOdontologica;
import java.util.ArrayList;

import br.mackenzie.simacr.interfaces.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MFormProntuario {

    public ArrayList<IConsultaMedica> buscaConsultasMedica(ITriagem var) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        List<IConsultaMedica> meuRetorno;

        String strQuery = "SELECT cm FROM EntidadeConsultaMedica cm WHERE cm.triagem.paciente.id = " + String.valueOf(var.getIPaciente().getId());
        Query minhaQuery = manager.createQuery(strQuery);
        meuRetorno = minhaQuery.getResultList();
        return (ArrayList<IConsultaMedica>) meuRetorno;
    }

    public ArrayList<IConsultaOdontologica> buscaConsultasOdontologica(ITriagem var) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        List<IConsultaOdontologica> meuRetorno;

        String strQuery = "SELECT cm FROM EntidadeConsultaOdontologica cm WHERE cm.triagem.paciente.id = " + String.valueOf(var.getIPaciente().getId());
        Query minhaQuery = manager.createQuery(strQuery);
        meuRetorno = minhaQuery.getResultList();
        return (ArrayList<IConsultaOdontologica>) meuRetorno;
    }    

    public void removerDaFilaConsultaMedica(Long idFila) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        manager.remove(manager.find(EntidadeFilaConsultaMedica.class, idFila));
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();            
    }

    public void removerDaFilaConsultaOdontologica(Long idFila) {
        
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        manager.remove(manager.find(EntidadeFilaConsultaOdontologica.class, idFila));
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();   
    }
    
    public ITriagem buscarTriagem(Long idConsulta,boolean tipo)
    {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        if(tipo)
           return manager.find(EntidadeConsultaMedica.class,idConsulta).getITriagem();
        else
            return manager.find(EntidadeConsultaOdontologica.class,idConsulta).getITriagem();
    }
}
