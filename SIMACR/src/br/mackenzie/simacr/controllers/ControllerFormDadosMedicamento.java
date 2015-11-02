/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormDadosMedicamento;
import br.mackenzie.simacr.interfaces.ILote;
import br.mackenzie.simacr.interfaces.IMedicamento;
import br.mackenzie.simacr.models.MFormDadosMedicamento;
import br.mackenzie.simacr.views.FormDadosMedicamento;
import java.util.List;

/**
 *
 * @author root
 */
public class ControllerFormDadosMedicamento extends ControllerFactory implements IControllerFormDadosMedicamento {

    MFormDadosMedicamento modeloFormDadosMedicamento;
    FormDadosMedicamento janelaFormDadosMedicamento;
    IMedicamento medicamento;
    

    public ControllerFormDadosMedicamento(IMedicamento var) {
        super();
        medicamento = var;
        modeloFormDadosMedicamento = new MFormDadosMedicamento();
        janelaFormDadosMedicamento = new FormDadosMedicamento(this,var);
        
    }
    
   @Override
    public void fecharJanelaEModel()
    {
        modeloFormDadosMedicamento = null;
        janelaFormDadosMedicamento.dispose();
        super.fecharJanelaEModel();        
    }    
    
    
    @Override
    public void abrirJanela() {
        medicamento = modeloFormDadosMedicamento.buscarMedicamento(medicamento);
        janelaFormDadosMedicamento.popularTabela();
        janelaFormDadosMedicamento.updateQtde(medicamento);
        janelaFormDadosMedicamento.setVisible(true);
        janelaFormDadosMedicamento.requestFocus();
    }

    @Override
    public void abrirFormCadastrarLote() {
        janelaFormDadosMedicamento.setVisible(false);
        super.criarController(new ControllerFormCadastrarLote(medicamento));
    }

    @Override
    public void excluirLote(Long idMedicamento, String numeroLote) {
        modeloFormDadosMedicamento.excluirLote(idMedicamento, numeroLote);
        janelaFormDadosMedicamento.popularTabela();
    }

    @Override
    public void excluirMedicamento(Long id) {
        modeloFormDadosMedicamento.excluirMedicamento(medicamento.getId());
        super.terminarControllers(1);
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public List<ILote> getLotes(Long id ) {
        return modeloFormDadosMedicamento.buscarLotes(medicamento.getId());
    }
    
}
