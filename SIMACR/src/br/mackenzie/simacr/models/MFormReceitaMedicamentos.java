/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.*;
import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
public class MFormReceitaMedicamentos {

    public void aviarReceita(Long IDFilaAviamento) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeFilaAviamento fa = manager.find(EntidadeFilaAviamento.class, IDFilaAviamento);
        List<EntidadeReceita_Medicamento> lista;

        EntidadeReceita rec = fa.getReceita();
        lista = rec.getReceita_Medicamento();
        rec.setAviado();



        for (EntidadeReceita_Medicamento erm : lista) {
            erm.getMedicamento().setQuantidadeEntregue(erm.getQuantidade());
        }
        manager.remove(fa);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public ArrayList<IReceita_Medicamento> getReceitaMedicamento(Long IDFilaAviamento) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeFilaAviamento var = manager.find(EntidadeFilaAviamento.class, IDFilaAviamento);
        return var.getReceita().getIReceita_Medicamento();
    }
}
