/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeLote;
import br.mackenzie.simacr.entidades.EntidadeMedicamento;
import br.mackenzie.simacr.interfaces.ILote;
import br.mackenzie.simacr.interfaces.IMedicamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */

//TODO Good Luck Have Fun
public class MFormDadosMedicamento {



    public void excluirLote(Long id, String numeroLote) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();        
        EntidadeMedicamento medicamento = manager.find(EntidadeMedicamento.class, id);
        EntidadeLote remover = null;
        for(EntidadeLote lote : medicamento.getLotes())
            if(lote.getNumeroLote().equals(numeroLote))
            {
                remover = lote;
                break;
            }
        medicamento.setEmEstoque(remover.getUnidades());
        medicamento.removeLote(remover);
        manager.remove(remover);
        manager.getTransaction().begin();
        manager.getTransaction().commit();        
 
    }

    public void excluirMedicamento(Long id) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        EntidadeMedicamento medicamento = manager.find(EntidadeMedicamento.class, id);
        List<EntidadeLote> lotes = medicamento.getLotes();
        for(EntidadeLote it: lotes)
            manager.remove(it);
        medicamento.removeTodosLotes();
        manager.remove(medicamento);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
    }

    public ArrayList<ILote> buscarLotes(Long id) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        EntidadeMedicamento medicamento = manager.find(EntidadeMedicamento.class, id);
         return medicamento.getILotes();
    }

    public IMedicamento buscarMedicamento(IMedicamento medicamento) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        return (IMedicamento)manager.find(EntidadeMedicamento.class,medicamento.getId());
    }

}
