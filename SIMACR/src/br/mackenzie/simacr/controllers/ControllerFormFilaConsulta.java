package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormFilaConsulta;
import br.mackenzie.simacr.interfaces.IFilaConsulta;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.models.MFormFilaConsulta;
import br.mackenzie.simacr.views.FormFilaConsulta;
import java.util.ArrayList;

public class ControllerFormFilaConsulta extends ControllerFactory implements IControllerFormFilaConsulta {

    FormFilaConsulta janelaFormFilaConsultaMedica;
    MFormFilaConsulta modeloFormFilaConsultaMedica;
    boolean tipo;

    public ControllerFormFilaConsulta(boolean varTipo) {
        super();
        tipo = varTipo;
        modeloFormFilaConsultaMedica = new MFormFilaConsulta();
        janelaFormFilaConsultaMedica = new FormFilaConsulta(this, tipo);
    }

    @Override
    public void abrirJanela() {
        //  janelaFormFilaConsultaMedica.mnuCarregarMouseClicked(null);
        janelaFormFilaConsultaMedica.setVisible(true);
    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormFilaConsultaMedica.dispose();
        modeloFormFilaConsultaMedica = null;
        super.fecharJanelaEModel();
    }

    @Override
    public ArrayList<IFilaConsulta> buscaTriagens() {
        return modeloFormFilaConsultaMedica.buscaTriagens(tipo);
    }
    


    @Override
    public boolean getTipo() {
        return tipo;
    }

    @Override
    public void abrirProntuario(Long var) {
        janelaFormFilaConsultaMedica.setVisible(false);
        ITriagem triagem = modeloFormFilaConsultaMedica.buscaTriagem(var,tipo);
        super.criarController(new ControllerFormProntuario(triagem, var, tipo));
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }
}
