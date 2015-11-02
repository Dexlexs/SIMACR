/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeReceitaTripulante extends EntidadeReceita {

    @ManyToOne
    private EntidadeTripulante receitado;
    private String dataReceita;

    public EntidadeReceitaTripulante() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        dataReceita = String.valueOf(day + "/" + month + "/" + year);
        super.setTriagem(null);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }





    public void setTripulante(EntidadeTripulante var) {
        receitado = var;
    }

    public EntidadeTripulante getTripulante() {
        return receitado;
    }
    
    public String getDataReceita()
    {
        return dataReceita;
    }
}
