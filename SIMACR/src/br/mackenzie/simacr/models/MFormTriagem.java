/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.*;
import br.mackenzie.simacr.interfaces.IPaciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
public class MFormTriagem {

    public void salvarFilaConsultaMedica(Long idTriagem) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();  
        EntidadeFilaConsultaMedica cmedicafila = new EntidadeFilaConsultaMedica(manager.find(EntidadeTriagem.class, idTriagem));
        manager.persist(cmedicafila);
        manager.getTransaction().begin();
        manager.getTransaction().commit();                
    }

    public void salvarFilaConsultaOdontologica(Long idTriagem) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();  
        EntidadeFilaConsultaOdontologica codontologicafila = new EntidadeFilaConsultaOdontologica(manager.find(EntidadeTriagem.class, idTriagem));
        manager.persist(codontologicafila);
        manager.getTransaction().begin();
        manager.getTransaction().commit();              
    }

    public Long salvarTriagem(Double altura, Double diametroCintura, Double IMC, Double peso, String pressao, String sintoma, Double temperatura, IPaciente paciente) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();  
        EntidadeTriagem entiTriagem = new EntidadeTriagem();
        entiTriagem.setAltura(altura);
        entiTriagem.setDiametroCintura(diametroCintura);
        entiTriagem.setIMC(IMC);
        entiTriagem.setPeso(peso);
        entiTriagem.setPressao(pressao);
        entiTriagem.setSintoma(sintoma);
        entiTriagem.setTemperatura(temperatura);
        entiTriagem.setPaciente(manager.find(EntidadePaciente.class, paciente.getId()));
        
        manager.persist(entiTriagem);

        manager.getTransaction().begin();
        manager.getTransaction().commit();           
        return entiTriagem.getId();
        
    }

    public void removerDaFila(Long idFila)
    {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();    
        manager.remove(manager.find(EntidadeFilaTriagem.class, idFila)); 
        manager.getTransaction().begin();
        manager.getTransaction().commit();        
    }
    
}
