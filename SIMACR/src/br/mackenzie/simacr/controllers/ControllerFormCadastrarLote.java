/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormCadastrarLote;
import br.mackenzie.simacr.interfaces.IMedicamento;
import br.mackenzie.simacr.models.MFormCadastrarLote;
import br.mackenzie.simacr.views.FormCadastrarLote;

/**
 *
 * @author root
 */
public class ControllerFormCadastrarLote extends ControllerFactory implements IControllerFormCadastrarLote {

    private FormCadastrarLote janelaFormCadastrarLote;
    private MFormCadastrarLote modeloFormCadastrarLote;
    IMedicamento medicamento;

    public ControllerFormCadastrarLote(IMedicamento var) {
        super();
        medicamento = var;
        modeloFormCadastrarLote = new MFormCadastrarLote();
        janelaFormCadastrarLote = new FormCadastrarLote(this);
    }

    @Override
    public void abrirJanela() {
        janelaFormCadastrarLote.setVisible(true);
        janelaFormCadastrarLote.requestFocus();
    }

    @Override
    public void fecharJanelaEModel() {
        modeloFormCadastrarLote = null;
        janelaFormCadastrarLote.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void salvarLote(String numeroLote, String validade, Integer unidades, String adquirido) {
        modeloFormCadastrarLote.salvarLote(medicamento.getId(), numeroLote, validade, unidades, adquirido);
        super.terminarControllers(1);
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }
}
