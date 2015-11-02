/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormTriagem;
import br.mackenzie.simacr.interfaces.IPaciente;
import br.mackenzie.simacr.models.MFormTriagem;
import br.mackenzie.simacr.views.FormTriagem;

/**
 *
 * @author root
 */
public class ControllerFormTriagem extends ControllerFactory implements IControllerFormTriagem{

    MFormTriagem modeloFormTriagem;
    FormTriagem janelaFormTriagem;
    IPaciente paciente;
    Long fila;
    
    ControllerFormTriagem(IPaciente var,Long idFila)
    {
        super();
        paciente = var;
        fila=idFila;
        modeloFormTriagem = new MFormTriagem();
        janelaFormTriagem = new FormTriagem(this,paciente);
    }
    @Override
    public void abrirJanela() {
        janelaFormTriagem.setVisible(true);
        janelaFormTriagem.startFocus();
    }
    
    public void fecharJanelaEModel()
    {
        modeloFormTriagem = null;
        janelaFormTriagem.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public void salvarTriagem(Double altura, Double diametroCintura, Double IMC, Double peso, String pressao, String sintoma, Double temperatura, boolean filaConsultaMedica, boolean filaConsultaOdontologica) {
        Long idTriagem = modeloFormTriagem.salvarTriagem(altura,diametroCintura,IMC,peso,pressao,sintoma,temperatura,paciente);
        if(filaConsultaMedica)
            modeloFormTriagem.salvarFilaConsultaMedica(idTriagem);
        if(filaConsultaOdontologica)
            modeloFormTriagem.salvarFilaConsultaOdontologica(idTriagem);
        modeloFormTriagem.removerDaFila(fila);
        super.terminarControllers(1);
    }
    
}
