/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaOdontologica;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.models.MFormConsultaOdontologica;
import br.mackenzie.simacr.views.FormConsultaOdontologica;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ControllerFormConsultaOdontologica extends ControllerFactory implements IControllerFormConsultaOdontologica{


    FormConsultaOdontologica janelaFormConsultaOdontologica;
    MFormConsultaOdontologica modeloFormConsultaOdontologica;
    ITriagem objetoTriagem;
    Long idConsultaOdontologica;
    boolean precisaSalvar;
    boolean tipoJanela;

    public ControllerFormConsultaOdontologica(ITriagem varTriagem, Long varIDConsulta) {
        super();
        modeloFormConsultaOdontologica = new MFormConsultaOdontologica();
        idConsultaOdontologica = varIDConsulta;
        objetoTriagem = varTriagem;
        precisaSalvar = false;
        if (idConsultaOdontologica == -1) {
            
            tipoJanela = false; 
        } else {
            tipoJanela = true;
        }
        janelaFormConsultaOdontologica = new FormConsultaOdontologica(this, tipoJanela);
    }

    @Override
    public void terminar() {
        precisaSalvar = true;
        super.terminarControllers(2);
    }

    @Override
    public void cancelar() {
        precisaSalvar = false;
        super.terminarControllers(1);

    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormConsultaOdontologica.dispose();
        modeloFormConsultaOdontologica = null;
        super.fecharJanelaEModel();
    }

    @Override
    public void finalizar() {
        if (tipoJanela == false && precisaSalvar == true) {
            modeloFormConsultaOdontologica.salvarConsultaOdontologica(janelaFormConsultaOdontologica.getCampos(),objetoTriagem,super.getLogin());
        }
        super.finalizar();
    }

    @Override
    public void abrirJanela() {
        precisaSalvar = false;
        janelaFormConsultaOdontologica.setVisible(true);
    }

    @Override
    public ArrayList<String> buscaDadosPaciente() {
        return modeloFormConsultaOdontologica.buscaDadosPaciente(objetoTriagem,idConsultaOdontologica);
    }

    @Override
    public void abrirPrescricao() {
        precisaSalvar = true;
        janelaFormConsultaOdontologica.setVisible(false);
        super.criarController(new ControllerFormReceita(objetoTriagem,0));
    }
}
