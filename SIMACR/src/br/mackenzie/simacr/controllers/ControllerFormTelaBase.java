/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormTelaBase;
import br.mackenzie.simacr.views.FormTelaBase;

/**
 *
 * @author root
 */
public class ControllerFormTelaBase extends ControllerFactory implements IControllerFormTelaBase {

    private FormTelaBase janelaFormTelaBase;

    public ControllerFormTelaBase() {
        janelaFormTelaBase = new FormTelaBase(this,super.getLogin().getProfissao());
    }
    

    @Override
    public void abrirJanela() {
        janelaFormTelaBase.setVisible(true);
        janelaFormTelaBase.startFocus();
    }

    @Override
    public void cancelar() {
        super.voltarBase(null);
    }

    @Override
    public void fecharJanelaEModel()
    {
        janelaFormTelaBase.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void abrirNovaJanela(String opcao) {
        janelaFormTelaBase.setVisible(false);
        if(opcao.equals("Recepcao"))
            super.criarController(new ControllerFormRecepcaoPaciente());
        else if(opcao.equals("Triagem"))
            super.criarController(new ControllerFormFilaTriagem());
        else if(opcao.equals("ConsultaMedica"))
            super.criarController(new ControllerFormFilaConsulta(true));
        else if(opcao.equals("ConsultaOdontologica"))
            super.criarController(new ControllerFormFilaConsulta(false));
        else if(opcao.equals("Farmacia"))
            super.criarController(new ControllerFormFilaAviamento());
        else if(opcao.equals("ManutencaoTripulante"))
            super.criarController(new ControllerFormConsultaTripulante());
        else if(opcao.equals("ConsultaEstoqueGeral"))
            super.criarController(new ControllerFormConsultaEstoqueGeral());
    }
}
