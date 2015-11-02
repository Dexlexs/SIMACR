/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeItemEstoque;
import br.mackenzie.simacr.entidades.EntidadeLoteItemEstoque;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import br.mackenzie.simacr.interfaces.ILoteItemEstoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author H_W
 */
public class MFormDadosItemEstoque {

    public boolean remover(IEntidadeItemEstoque itemEstoque, Integer quantidade) {
        try
        {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();        
        EntidadeItemEstoque eie = manager.find(EntidadeItemEstoque.class, itemEstoque.getId());
        eie.setQuantidade(0-quantidade);
        manager.getTransaction().begin();
        manager.getTransaction().commit(); 
        return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<ILoteItemEstoque> buscarLote(IEntidadeItemEstoque itemEstoque) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();         
        EntidadeItemEstoque eie = manager.find(EntidadeItemEstoque.class, itemEstoque.getId());
        return eie.getILotes();
    }

    public void excluirLote(IEntidadeItemEstoque itemEstoque, ILoteItemEstoque loteItemEstoque) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();        
        EntidadeItemEstoque eie = manager.find(EntidadeItemEstoque.class, itemEstoque.getId());
        EntidadeLoteItemEstoque remover = null;
        for(EntidadeLoteItemEstoque lote : eie.getLotes())
            if(lote.getId() == loteItemEstoque.getId())
            {
                remover = lote;
                break;
            }
        eie.setQuantidade(0-remover.getQuantidade());
        eie.removeLote(remover);
        manager.remove(remover);
        manager.getTransaction().begin();
        manager.getTransaction().commit();      
    }


    public void excluir(IEntidadeItemEstoque itemEstoque) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();         
        EntidadeItemEstoque eie = manager.find(EntidadeItemEstoque.class, itemEstoque.getId());
        eie.removeTodosLotes();
        manager.remove(eie);
        manager.getTransaction().begin();
        manager.getTransaction().commit();        
    }

    public ILoteItemEstoque buscarLote(Long aLong) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();         
        return  (ILoteItemEstoque)manager.find(EntidadeLoteItemEstoque.class, aLong);
    }

    public IEntidadeItemEstoque buscarItemEstoque(Long id) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager(); 
        return (IEntidadeItemEstoque)manager.find(EntidadeItemEstoque.class, id);
    }
    
}
