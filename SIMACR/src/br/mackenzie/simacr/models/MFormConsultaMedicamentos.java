/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeMedicamento;
import br.mackenzie.simacr.interfaces.IMedicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author root
 */
//TODO Good Luck Have Fun
public class MFormConsultaMedicamentos {


    public List<IMedicamento> buscarLista(String nomeComercial, String principioAtivo, String laboratorio) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        Query query;
        String busca = "SELECT e FROM EntidadeMedicamento e ";

        boolean filtro = true;


        if (!nomeComercial.equals("")) {
            if (filtro) {
                busca = busca.concat("WHERE (nomeComercial LIKE '%" + nomeComercial + "%') ");
                filtro = false;
            }
        }

        if (!principioAtivo.equals("")) {
            if (filtro) {
                busca = busca.concat("WHERE (principioAtivo LIKE '%" + principioAtivo + "%') ");
                filtro = false;
            } else {
                busca = busca.concat("AND (principioAtivo LIKE '%" + principioAtivo + "%') ");
            }
        }

        if (!laboratorio.equals("")) {
            if (filtro) {
                busca = busca.concat("WHERE (laboratorio LIKE '%" + laboratorio + "%') ");
            } else {
                busca = busca.concat("AND (laboratorio LIKE '%" + laboratorio + "%') ");
            }
        }


        query = manager.createQuery(busca);
        return query.getResultList();
    }

    public IMedicamento buscarMedicamento(Long id) {
        //TODO fazer consulta em banco
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        IMedicamento retorno = manager.find(EntidadeMedicamento.class, id);
        return retorno;
    }
}
