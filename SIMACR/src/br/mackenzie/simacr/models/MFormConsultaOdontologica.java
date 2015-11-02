/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeConsultaOdontologica;
import br.mackenzie.simacr.entidades.EntidadeTriagem;
import br.mackenzie.simacr.entidades.EntidadeTripulante;
import br.mackenzie.simacr.interfaces.IConsultaOdontologica;
import br.mackenzie.simacr.interfaces.IPaciente;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
public class MFormConsultaOdontologica {

    public ArrayList<String> buscaDadosPaciente(ITriagem varTriagem, Long idConsultaOdontologica) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        IPaciente pac = manager.find(EntidadeTriagem.class, varTriagem.getId()).getPaciente();
        ArrayList<String> retorno = new ArrayList<String>();
        retorno.add(pac.getNome());
        retorno.add(varTriagem.getPressao());
        retorno.add(String.valueOf(varTriagem.getTemperatura()));
        retorno.add(String.valueOf(varTriagem.getPeso()));
        retorno.add(String.valueOf(varTriagem.getAltura()));
        if (idConsultaOdontologica != -1L) {
            IConsultaOdontologica queryConsultaODontologica;
            queryConsultaODontologica = manager.find(EntidadeConsultaOdontologica.class, idConsultaOdontologica);
            retorno.add(queryConsultaODontologica.getEvolucao());
            retorno.add(queryConsultaODontologica.getObservacao());
        }
        return retorno;


    }

    public void salvarConsultaOdontologica(ArrayList<String> var, ITriagem varTriagem,ITripulante responsavel) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeConsultaOdontologica co = new EntidadeConsultaOdontologica();
        co.setResponsavel(manager.find(EntidadeTripulante.class, responsavel.getId()));
        co.setEvolucao(var.get(0));
        co.setObservacoes(var.get(1));        
        Calendar cal = Calendar.getInstance();  
        int day = cal.get(Calendar.DATE);  
        int month = cal.get(Calendar.MONTH) + 1;  
        int year = cal.get(Calendar.YEAR);  
        co.setDataConsulta(String.valueOf(day + "/" + month + "/" + year));
        co.setTriagem(manager.find(EntidadeTriagem.class, varTriagem.getId()));     
        manager.persist(co);
        manager.getTransaction().begin();
        manager.getTransaction().commit();   
        manager.close();
        factory.close();        
    }
}
