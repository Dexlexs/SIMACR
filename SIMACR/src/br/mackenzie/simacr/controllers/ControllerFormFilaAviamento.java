/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormFilaAviamento;
import br.mackenzie.simacr.interfaces.IFilaAviamento;
import br.mackenzie.simacr.interfaces.IReceita;
import br.mackenzie.simacr.models.MFormFilaAviamento;
import br.mackenzie.simacr.views.FormFilaAviamento;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ControllerFormFilaAviamento extends ControllerFactory implements IControllerFormFilaAviamento {

    private MFormFilaAviamento modeloFormFilaAviamento;
    private FormFilaAviamento janelaFormFilaAviamento;

    public ControllerFormFilaAviamento()
    {
        super();
        modeloFormFilaAviamento = new MFormFilaAviamento();
        janelaFormFilaAviamento = new FormFilaAviamento(this);
    }
    
    @Override
    public void abrirJanela() {
        janelaFormFilaAviamento.refresh();
        janelaFormFilaAviamento.setVisible(true);
    }

    @Override
    public void fecharJanelaEModel()
    {
        janelaFormFilaAviamento.dispose();
        modeloFormFilaAviamento=null;
        super.fecharJanelaEModel();
    }
    
    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public ArrayList<IFilaAviamento> carregarFila() {
        return modeloFormFilaAviamento.carregarFila();
    }

    @Override
    public void abrirManutencaoMedicamento() {
        janelaFormFilaAviamento.setVisible(false);
        super.criarController(new ControllerFormConsultaMedicamentos());
    }

    @Override
    public void abrirReceitaMedicamentos(Long aLong) {
        janelaFormFilaAviamento.setVisible(false);
        super.criarController(new ControllerFormReceitaMedicamentos(aLong));
    }
}
