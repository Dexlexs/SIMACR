/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeItemEstoque;
import br.mackenzie.simacr.entidades.EntidadeLoteItemEstoque;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
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
public class MFormCadastrarItemEstoque {

    public boolean salvar(String nom, Integer quant, String nomeItem) {

        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        Query queryEst = manager.createQuery("SELECT e FROM EntidadeItemEstoque e WHERE(nome = '" + nomeItem + "')");
        try {
            EntidadeItemEstoque eIE = (EntidadeItemEstoque) queryEst.getSingleResult();
            if (nom == null) {
                eIE.setQuantidade(quant);
                manager.getTransaction().begin();
                manager.getTransaction().commit();
                return true;
            }
            List<EntidadeLoteItemEstoque> alote = eIE.getLotes();
            int qtde = 0;
            for (EntidadeLoteItemEstoque it : alote) {
                if (it.getNumeroLote().equals(nom)) {
                    qtde++;
                }
            }
            if (qtde > 0) {
                return false;
            } else {
                EntidadeLoteItemEstoque salvar = new EntidadeLoteItemEstoque(nom, quant);
                eIE.addLote(salvar);
                manager.persist(salvar);
                manager.getTransaction().begin();
                manager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            return false;
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
