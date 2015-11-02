/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.*;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author root
 */
public class MFormLogin {

    public ITripulante verifica(String user, String pass) {

        EntityManagerFactory factory;
        EntityManager manager;

        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        Query minhaQuery = manager.createQuery("SELECT l FROM EntidadeLogin l WHERE (nome = '" + user + "') AND (senha = '" + pass + "')");
        try {
            EntidadeLogin el = (EntidadeLogin) minhaQuery.getSingleResult();
            return el.getITripulante();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void iniciarPrograma() {
        EntityManagerFactory factory;
        EntityManager manager;

        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        Query minhaQuery = manager.createQuery("SELECT l FROM EntidadeTripulante l WHERE (profissao = 'Administrador')");
        if (minhaQuery.getResultList().isEmpty()) {
            EntidadeTripulante et = new EntidadeTripulante("Administrador", "00/00/0000", "", "", "Administrador", "Masculino");
            EntidadeLogin el = new EntidadeLogin("Admin", et, "Simacr");
            et.setLogin(el);
            manager.persist(et);
            manager.persist(el);
            manager.getTransaction().begin();
            manager.getTransaction().commit();
        }
    }
}
