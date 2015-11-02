/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormCadastroTripulante;
import br.mackenzie.simacr.models.MFormCadastroTripulante;
import br.mackenzie.simacr.views.FormCadastroTripulante;
import br.mackenzie.simacr.views.FormCadastroTripulante;

/**
 *
 * @author root
 */
public class ControllerFormCadastroTripulante extends ControllerFactory implements IControllerFormCadastroTripulante {

    private FormCadastroTripulante janelaFormCadastroTripulante;
    private MFormCadastroTripulante modeloFormCadastroTripulante;
    private Long idTripulante;

    public ControllerFormCadastroTripulante(Long var) {
        super();
        modeloFormCadastroTripulante = new MFormCadastroTripulante();
        //vou para a janela e o tripulante para a FormCadastroTripulante
        janelaFormCadastroTripulante = new FormCadastroTripulante(this, modeloFormCadastroTripulante.buscaTripulante(var));
        idTripulante = var;

    }

    public ControllerFormCadastroTripulante() {
        super();
        System.out.println("ABC2");
        modeloFormCadastroTripulante = new MFormCadastroTripulante();
        //vou para a janela e o tripulante para a FormCadastroTripulante
        janelaFormCadastroTripulante = new FormCadastroTripulante(this, null);
        idTripulante = null;
    }

    @Override
    public void abrirJanela() {
        janelaFormCadastroTripulante.setVisible(true);
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormCadastroTripulante.dispose();
        modeloFormCadastroTripulante = null;
        super.fecharJanelaEModel();
    }

    @Override
    public void excluir() {
        modeloFormCadastroTripulante.excluir(idTripulante);
        super.terminarControllers(1);
    }

    @Override
    public void salvar(String varNome, String varNascimento, String varNaturalidade, String varTelefone, String varProfissao, String varSexo,String varLogin, String varSenha) {
        if (idTripulante == null) {
            modeloFormCadastroTripulante.salvar(varNome, varNascimento, varNaturalidade, varTelefone, varProfissao, varSexo,varLogin,varSenha);
            super.terminarControllers(1);
        } else {
            modeloFormCadastroTripulante.atualizar(varNome, varNascimento, varNaturalidade, varTelefone, varProfissao, varSexo,varLogin,varSenha,idTripulante);
            super.terminarControllers(1);
        }

    }
}
