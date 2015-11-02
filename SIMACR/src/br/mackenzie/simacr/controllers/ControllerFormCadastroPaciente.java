/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormCadastroPaciente;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IPaciente;
import br.mackenzie.simacr.models.MFormCadastroPaciente;
import br.mackenzie.simacr.views.FormCadastroPaciente;
import java.util.ArrayList;
    
/**
 *
 * @author root
 */
public class ControllerFormCadastroPaciente extends ControllerFactory implements IControllerFormCadastroPaciente{

    MFormCadastroPaciente modeloFormCadastroPaciente;
    FormCadastroPaciente janelaFormCadastroPaciente;
    IPaciente paciente;
    int tipoEdit;
    
    
    public ControllerFormCadastroPaciente(IPaciente var)
    {
        super();
        paciente = var;
        modeloFormCadastroPaciente = new MFormCadastroPaciente();
        janelaFormCadastroPaciente = new FormCadastroPaciente(this, paciente);
    }
    
    @Override
    public void fecharJanelaEModel()
    {
        modeloFormCadastroPaciente = null;
        janelaFormCadastroPaciente.dispose();
        super.fecharJanelaEModel();
    }
    
    @Override
    public void abrirJanela() {
        janelaFormCadastroPaciente.startCbox(tipoEdit);
        janelaFormCadastroPaciente.setVisible(true);
        janelaFormCadastroPaciente.startFocus();
    }

    @Override
    public String iniciarcboxcomu()
    {
        if(paciente==null)
            return null;
        else
            return paciente.getComunidade();
    }
    
    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public void salvar(String nome, String profissao, String comunidade, String rio, String dataNascimento, String telefone, String cor, String naturalidade, String nacionalidade, String estadoCivil, String sexo) {
        if(paciente == null)
            modeloFormCadastroPaciente.salvar(nome,profissao,comunidade,rio,dataNascimento,telefone,cor,naturalidade,nacionalidade,estadoCivil,sexo);
        else
            modeloFormCadastroPaciente.atualizar(nome,profissao,comunidade,rio,dataNascimento,telefone,cor,naturalidade,nacionalidade,estadoCivil,sexo,paciente);
        super.terminarControllers(1);
    }

    @Override
    public void excluir() {
        modeloFormCadastroPaciente.excluir(paciente);
        super.terminarControllers(1);
    }

    @Override
    public void editarRios() {
        janelaFormCadastroPaciente.setVisible(false);
        tipoEdit=2;
        super.criarController(new ControllerFormEditarLista(2));
    }

    @Override
    public void editarCorDePeles() {
        janelaFormCadastroPaciente.setVisible(false);
        tipoEdit=1;
        super.criarController(new ControllerFormEditarLista(1));
    }

    @Override
    public void editarComunidades(String nomeRio) {
        janelaFormCadastroPaciente.setVisible(false);
        tipoEdit=3;
        Long idRio = modeloFormCadastroPaciente.getIDRio(nomeRio);
        super.criarController(new ControllerFormEditarLista(idRio));
    }

    @Override
    public ArrayList<IEntidadeComUmaString> carregaRio() {
        return modeloFormCadastroPaciente.getRios();
    }

    @Override
    public ArrayList<IEntidadeComUmaString> carregaCorPele() {
        return modeloFormCadastroPaciente.getPeles();
    }

    @Override
    public ArrayList<IEntidadeComUmaString> carregaComunidade(String nomeRio) {
        return modeloFormCadastroPaciente.getComunidades(modeloFormCadastroPaciente.getIDRio(nomeRio));
    }


    
}
