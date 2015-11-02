/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeMedicamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
public class MFormCadastrarMedicamentos {
    
    public void salvarMedicamentos(String nomeComercial, String principioAtivo, String formaFarmaceutico, String laboratorio)
    {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();            
        EntidadeMedicamento medicamento = new EntidadeMedicamento();
        medicamento.setNomeComercial(nomeComercial);
        medicamento.setPrincipioAtivo(principioAtivo);
        medicamento.setFormaFarmaceutica(formaFarmaceutico);
        medicamento.setLaboratorio(laboratorio);
        manager.persist(medicamento);
        manager.getTransaction().begin();
        manager.getTransaction().commit();        
        
    }
}
