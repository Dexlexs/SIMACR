package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormProntuario;
import br.mackenzie.simacr.interfaces.IConsultaMedica;
import br.mackenzie.simacr.interfaces.IConsultaOdontologica;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.models.MFormProntuario;
import br.mackenzie.simacr.views.FormProntuario;
import java.util.ArrayList;

public class ControllerFormProntuario extends ControllerFactory implements IControllerFormProntuario {

    MFormProntuario modeloFormProntuario;
    FormProntuario janelaFormProntuario;
    ITriagem triagem;
    boolean tipoConsulta; // true = consulta medica, false = consulta odontologica
    boolean terminou;
    Long idFila; //id do objeto filaconsultamedica para remover da lista apos realizacao de consulta medica

    public ControllerFormProntuario(ITriagem varTriagem, Long varIDFilaCM, boolean varTipo) {
        super();
        triagem = varTriagem;
        idFila = varIDFilaCM;
        tipoConsulta = varTipo;
        terminou = false;
        modeloFormProntuario = new MFormProntuario();
        janelaFormProntuario = new FormProntuario(this, triagem.getIPaciente(), tipoConsulta);
    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormProntuario.dispose();
        modeloFormProntuario = null;
        super.fecharJanelaEModel();
    }

    @Override
    public ArrayList<IConsultaMedica> buscarConsultasMedica() {
        return modeloFormProntuario.buscaConsultasMedica(triagem);
    }

    @Override
    public void abrirJanela() {
        terminou = false;
        janelaFormProntuario.setVisible(true);
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public void finalizar() {
        if (terminou) {
            if (tipoConsulta) {
                modeloFormProntuario.removerDaFilaConsultaMedica(idFila);
            } else {
                modeloFormProntuario.removerDaFilaConsultaOdontologica(idFila);
            }
        }
        super.finalizar();
    }

    @Override
    public void abrirConsultaMedica(Long var) {
        janelaFormProntuario.setVisible(false);
        terminou = true;
        ITriagem triagemPar;
        if (var == -1L) {
            triagemPar = triagem;
        } else {
            triagemPar = modeloFormProntuario.buscarTriagem(var, tipoConsulta);
        }
        if (tipoConsulta) {
            super.criarController(new ControllerFormConsultaMedica(triagemPar, var));
        } else {
            super.criarController(new ControllerFormConsultaOdontologica(triagemPar, var));
        }
    }

    @Override
    public ArrayList<IConsultaOdontologica> buscarConsultasOdontologicas() {
        return modeloFormProntuario.buscaConsultasOdontologica(triagem);
    }
}
