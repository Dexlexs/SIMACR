/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormReceitaMedicamentos;
import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import br.mackenzie.simacr.models.MFormReceitaMedicamentos;
import br.mackenzie.simacr.views.FormReceitaMedicamentos;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ControllerFormReceitaMedicamentos extends ControllerFactory implements IControllerFormReceitaMedicamentos{
    MFormReceitaMedicamentos modeloFormReceitaMedicamentos;
    FormReceitaMedicamentos janelaFormReceitaMedicamentos;
    Long IDFilaAviamento;
    
    public ControllerFormReceitaMedicamentos(Long var)
    {
        super();
        IDFilaAviamento = var;
        modeloFormReceitaMedicamentos = new MFormReceitaMedicamentos();
        janelaFormReceitaMedicamentos = new FormReceitaMedicamentos(this);
    }
    
    @Override
    public void abrirJanela() {
        janelaFormReceitaMedicamentos.setVisible(true);
    }
    
    @Override
    public void fecharJanelaEModel()
    {
        janelaFormReceitaMedicamentos.dispose();
        modeloFormReceitaMedicamentos=null;
        super.fecharJanelaEModel();
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public void aviar() {
        modeloFormReceitaMedicamentos.aviarReceita(IDFilaAviamento);
        super.terminarControllers(1);
    }

    @Override
    public ArrayList<IReceita_Medicamento> getReceitaMedicamento() {
        return modeloFormReceitaMedicamentos.getReceitaMedicamento(IDFilaAviamento);
    }
    
}
