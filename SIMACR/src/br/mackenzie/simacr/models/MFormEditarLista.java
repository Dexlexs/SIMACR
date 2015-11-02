/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeComunidade;
import br.mackenzie.simacr.entidades.EntidadeCorDePele;
import br.mackenzie.simacr.entidades.EntidadeItemEstoque;
import br.mackenzie.simacr.entidades.EntidadeRio;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author H_W
 */
public class MFormEditarLista {

    public String getNomeRio(long idRio) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        return manager.find(EntidadeRio.class, idRio).getNome();
    }

    public void remover(Long varId, int varTipo) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        switch (varTipo) {
            case (0):
                manager.remove(manager.find(EntidadeComunidade.class, varId));
                break;
            case (1):
                EntidadeRio ER = manager.find(EntidadeRio.class, varId);
                String strQuery = "SELECT e FROM EntidadeComunidade e WHERE(rio = '" + ER.getId() + "')";
                Query minhaQuery = manager.createQuery(strQuery);
                ArrayList<EntidadeComunidade> listaRemover = (ArrayList<EntidadeComunidade>) minhaQuery.getResultList();
                for (EntidadeComunidade it : listaRemover) {
                    manager.remove(it);
                }
                break;
            case (2):
                manager.remove(manager.find(EntidadeCorDePele.class, varId));
                break;
            case (3):
                manager.remove(manager.find(EntidadeItemEstoque.class, varId));
                break;
        }
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public void salvarTodaLista(ArrayList<String> nomes, ArrayList<Long> ids, int varTipo) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        int aux;
        int aux2 = nomes.size();
        switch (varTipo) {
            case (0):
                for (aux = 0; aux < aux2; aux++) {
                    EntidadeComunidade varEC = manager.find(EntidadeComunidade.class, ids.get(aux));
                    varEC.setNomeComunidade(nomes.get(aux));
                }
                break;

            case (1):
                for (aux = 0; aux < aux2; aux++) {
                    EntidadeCorDePele varECP = manager.find(EntidadeCorDePele.class, ids.get(aux));
                    varECP.setCor(nomes.get(aux));
                }
                break;

            case (2):
                for (aux = 0; aux < aux2; aux++) {
                    EntidadeRio varR = manager.find(EntidadeRio.class, ids.get(aux));
                    varR.setNomeRio(nomes.get(aux));
                }
                break;
        }
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public void salvarUmaComunidade(String novoItem, long idRio) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeComunidade eC = new EntidadeComunidade();
        eC.setNomeComunidade(novoItem);
        eC.setRio(manager.find(EntidadeRio.class, idRio));
        manager.persist(eC);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public void salvarUmaRio(String novoItem) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeRio eR = new EntidadeRio();
        eR.setNomeRio(novoItem);
        manager.persist(eR);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public void salvarUmaCorDePele(String novoItem) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeCorDePele eCP = new EntidadeCorDePele();
        eCP.setCor(novoItem);
        manager.persist(eCP);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
    
    public void salvarUmUtensilio(String novoItem)
    {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeItemEstoque eIE = new EntidadeItemEstoque();
        eIE.setNome(novoItem);
        manager.persist(eIE);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        factory.close();        
    }

    public ArrayList<IEntidadeComUmaString> getComunidades(long idRio) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ArrayList<IEntidadeComUmaString> listaRetorno;
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

    public ArrayList<IEntidadeComUmaString> getCorDePeles() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ArrayList<IEntidadeComUmaString> listaRetorno;
        String strQuery = "SELECT e FROM EntidadeCorDePele e";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (ArrayList<IEntidadeComUmaString>) minhaQuery.getResultList();
        return listaRetorno;
    }
    
    public ArrayList<IEntidadeComUmaString> getUtensilios() {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        ArrayList<IEntidadeComUmaString> listaRetorno;
        String strQuery = "SELECT e FROM EntidadeItemEstoque e";
        Query minhaQuery = manager.createQuery(strQuery);
        listaRetorno = (ArrayList<IEntidadeComUmaString>) minhaQuery.getResultList();
        return listaRetorno;
    }    
    
    
}
