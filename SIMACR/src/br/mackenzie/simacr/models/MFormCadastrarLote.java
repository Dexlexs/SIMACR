/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeLote;
import br.mackenzie.simacr.entidades.EntidadeMedicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author root
 */
public class MFormCadastrarLote {

    public void salvarLote(Long idMedicamento, String numeroLote, String validade, Integer unidades,String adquirido) {
        //TODO salvar lote do medicamento recebido


        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeMedicamento medicamento = manager.find(EntidadeMedicamento.class, idMedicamento);
        List<EntidadeLote> alote = medicamento.getLotes();
        int qtde = 0;
        for (EntidadeLote it : alote) {
            if (it.getNumeroLote().equals(numeroLote)) {
                qtde += 1;
            }
        }
        if (qtde == 0) {
            EntidadeLote lote = new EntidadeLote();
            lote.setNumeroLote(numeroLote);
            lote.setValidade(validade);
            lote.setUnidades(unidades);
            lote.setAdquirido(adquirido);
            medicamento.addLote(lote);
            medicamento.setEmEstoque(unidades);
            manager.persist(lote);
            manager.getTransaction().begin();
            manager.getTransaction().commit();
        }
    }
}
