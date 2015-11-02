/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormFilaTriagem;
import br.mackenzie.simacr.interfaces.IFilaTriagem;
import br.mackenzie.simacr.interfaces.IPaciente;
import br.mackenzie.simacr.models.MFormFilaTriagem;
import br.mackenzie.simacr.views.FormFilaTriagem;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ControllerFormFilaTriagem extends ControllerFactory implements IControllerFormFilaTriagem{

    MFormFilaTriagem modeloFormFilaTriagem;
    FormFilaTriagem janelaFormFilaTriagem;
    
    public ControllerFormFilaTriagem()
    {
        super();
        modeloFormFilaTriagem = new MFormFilaTriagem();
        janelaFormFilaTriagem = new FormFilaTriagem(this);
    }
    
    @Override
    public void abrirJanela() {
        janelaFormFilaTriagem.carregar();
        janelaFormFilaTriagem.setVisible(true);
        janelaFormFilaTriagem.startFocus();
    }
    
    public void fecharJanelaEModel()
    {
        modeloFormFilaTriagem = null;
        janelaFormFilaTriagem.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void abrirTriagem(Long idFilaTriagem) {
        janelaFormFilaTriagem.setVisible(false);
        super.criarController(new ControllerFormTriagem(modeloFormFilaTriagem.buscarPaciente(idFilaTriagem),idFilaTriagem));
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public ArrayList<IFilaTriagem> CarregarFilaTriagem() {
        return modeloFormFilaTriagem.buscarFilaTriagem();
    }
    
}
