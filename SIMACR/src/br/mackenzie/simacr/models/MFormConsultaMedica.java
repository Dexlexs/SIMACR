package br.mackenzie.simacr.models;

import br.mackenzie.simacr.entidades.EntidadeConsultaMedica;
import br.mackenzie.simacr.entidades.EntidadeTriagem;
import br.mackenzie.simacr.entidades.EntidadeTripulante;
import java.util.ArrayList;
import java.util.Calendar;

import br.mackenzie.simacr.interfaces.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MFormConsultaMedica {
    //public ITriagem get

    public ArrayList<String> buscaDadosPaciente(ITriagem varTriagem, Long idCM) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        IPaciente pac = manager.find(EntidadeTriagem.class, varTriagem.getId()).getPaciente();
        ArrayList<String> retorno = new ArrayList<String>();
        retorno.add(pac.getNome());
        retorno.add(pac.getDataNascimento());
        retorno.add(varTriagem.getPressao());
        retorno.add(String.valueOf(varTriagem.getTemperatura()));
        retorno.add(String.valueOf(varTriagem.getPeso()));
        retorno.add(String.valueOf(varTriagem.getAltura()));
        retorno.add(String.valueOf(varTriagem.getDiametroCintura()));
        retorno.add(String.valueOf(varTriagem.getIMC()));
        retorno.add(varTriagem.getSintoma());
        if (idCM != -1L) {
            IConsultaMedica queryConsultaMedica;
            queryConsultaMedica = manager.find(EntidadeConsultaMedica.class, idCM);
            retorno.add(queryConsultaMedica.getSintoma());
            retorno.add(queryConsultaMedica.getAnamnese());
            retorno.add(queryConsultaMedica.getEvolucaoMedica());
            retorno.add(queryConsultaMedica.getHipoteseDiagnostica());
        }

        return retorno;
    }

    public void salvarConsultaMedica(ArrayList<String> var,ITriagem varTriagem,ITripulante responsavel) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeConsultaMedica cm = new EntidadeConsultaMedica();
        cm.setResponsavel(manager.find(EntidadeTripulante.class, responsavel.getId()));
        cm.setSintoma(var.get(0));
        cm.setAnamnese(var.get(1));
        cm.setEvolucaoMedica(var.get(2));
        cm.setHipoteseDiagnostica(var.get(3));
        Calendar cal = Calendar.getInstance();  
        int day = cal.get(Calendar.DATE);  
        int month = cal.get(Calendar.MONTH) + 1;  
        int year = cal.get(Calendar.YEAR);  
        cm.setDataConsulta(String.valueOf(day + "/" + month + "/" + year));
        cm.setTriagem(manager.find(EntidadeTriagem.class, varTriagem.getId()));
        manager.persist(cm);
        manager.getTransaction().begin();
        manager.getTransaction().commit();   
        manager.close();
        factory.close();
    }
}
