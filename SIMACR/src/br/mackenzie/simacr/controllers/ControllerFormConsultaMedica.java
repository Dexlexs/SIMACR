package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaMedica;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.models.MFormConsultaMedica;
import br.mackenzie.simacr.views.FormConsultaMedica;
import java.util.ArrayList;

public class ControllerFormConsultaMedica extends ControllerFactory implements IControllerFormConsultaMedica {

    FormConsultaMedica janelaFormConsultaMedica;
    MFormConsultaMedica modeloFormConsultaMedica;
    ITriagem objetoTriagem;
    Long idConsultaMedica;
    boolean precisaSalvar;
    boolean tipoJanela;

    public ControllerFormConsultaMedica(ITriagem varTriagem, Long varIDConsulta) {
        super();
        idConsultaMedica = varIDConsulta;
        objetoTriagem = varTriagem;
        precisaSalvar = false;
        if (idConsultaMedica == -1) {
            tipoJanela = false;
        } else {
            tipoJanela = true;
        }
        modeloFormConsultaMedica = new MFormConsultaMedica();
        janelaFormConsultaMedica = new FormConsultaMedica(this, tipoJanela);
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
        modeloFormConsultaMedica = null;
        janelaFormConsultaMedica.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void finalizar() {
        if (tipoJanela == false && precisaSalvar == true) {
            modeloFormConsultaMedica.salvarConsultaMedica(janelaFormConsultaMedica.getCampos(),objetoTriagem,super.getLogin());
        }
        super.finalizar();
    }

    @Override
    public void abrirJanela() {
        precisaSalvar = false;
        janelaFormConsultaMedica.setVisible(true);
    }

    @Override
    public ArrayList<String> buscaDadosPaciente() {
        return modeloFormConsultaMedica.buscaDadosPaciente(objetoTriagem,idConsultaMedica);
    }

    @Override
    public void abrirPrescricao() {
        precisaSalvar = true;
        janelaFormConsultaMedica.setVisible(false);
        super.criarController(new ControllerFormReceita(objetoTriagem,1));
    }
}
