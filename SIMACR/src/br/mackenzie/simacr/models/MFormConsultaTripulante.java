package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeTripulante;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MFormConsultaTripulante {

    public List<ITripulante> buscarTripulantes(String var) {
        List<ITripulante> meuRetorno;
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        String strquery = ("SELECT t FROM EntidadeTripulante t");
        if (!var.equals("")) {
            strquery = strquery.concat(" WHERE ( nome LIKE '%" + var + "%')");
        }
        Query minhaQuery = manager.createQuery(strquery);
        meuRetorno = minhaQuery.getResultList();
        return meuRetorno;
    }

    public ITripulante buscarTripulante(Long id) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        return (ITripulante)manager.find(EntidadeTripulante.class,id);
    }
}
