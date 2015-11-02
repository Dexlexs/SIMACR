/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormRecepcaoPaciente;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IPaciente;
import br.mackenzie.simacr.models.MFormRecepcaoPaciente;
import br.mackenzie.simacr.views.FormRecepcaoPaciente;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ControllerFormRecepcaoPaciente extends ControllerFactory implements IControllerFormRecepcaoPaciente{
    MFormRecepcaoPaciente modeloFormRecepcaoPaciente;
    FormRecepcaoPaciente janelaFormRecepcaoPaciente;
    
    public ControllerFormRecepcaoPaciente()
    {
        super();
        modeloFormRecepcaoPaciente = new MFormRecepcaoPaciente();
        janelaFormRecepcaoPaciente = new FormRecepcaoPaciente(this);
    }
    @Override
    public void abrirJanela() {
        janelaFormRecepcaoPaciente.limparCboxComunidade();
        janelaFormRecepcaoPaciente.carregarCboxRio();
        janelaFormRecepcaoPaciente.setVisible(true);
        janelaFormRecepcaoPaciente.startFocus();
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }
    
    @Override
    public void fecharJanelaEModel()
    {
        modeloFormRecepcaoPaciente=null;
        janelaFormRecepcaoPaciente.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void abrirFormCadastroPaciente() {
        janelaFormRecepcaoPaciente.setVisible(false);
        super.criarController(new ControllerFormCadastroPaciente(null));
    }

    @Override
    public ArrayList<IPaciente> buscarPacientes(String nome, String comunidade, String rio) {
        return modeloFormRecepcaoPaciente.buscarPaciente(nome,comunidade,rio);
    }

    @Override
    public void abrirFormCadastroPaciente(Long var) {
        janelaFormRecepcaoPaciente.setVisible(false);
        super.criarController(new ControllerFormCadastroPaciente(modeloFormRecepcaoPaciente.buscarPaciente(var)));
    }

    @Override
    public void enviarTriagem(Long var) {
        modeloFormRecepcaoPaciente.adicionarTriagem(modeloFormRecepcaoPaciente.buscarPaciente(var));
    }

    @Override
    public ArrayList<IEntidadeComUmaString> getComunidades(String nomeRio) {
        return modeloFormRecepcaoPaciente.getComunidades(nomeRio);
    }

    @Override
    public ArrayList<IEntidadeComUmaString> getRios() {
        return modeloFormRecepcaoPaciente.getRios();
    }
    
}
