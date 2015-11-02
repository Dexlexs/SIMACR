/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormCadastrarItemEstoque;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import br.mackenzie.simacr.models.MFormCadastrarItemEstoque;
import br.mackenzie.simacr.views.FormCadastrarItemEstoque;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
class ControllerFormCadastrarItemEstoque extends ControllerFactory implements IControllerFormCadastrarItemEstoque{

    private FormCadastrarItemEstoque janelaFormCadastrarItemEstoque;
    private MFormCadastrarItemEstoque modeloCadastroItemEstoque;
    
    public ControllerFormCadastrarItemEstoque() {
        super();
        modeloCadastroItemEstoque = new MFormCadastrarItemEstoque();
        janelaFormCadastrarItemEstoque = new FormCadastrarItemEstoque(this);
        
    }

    @Override
    public void abrirJanela() {
        janelaFormCadastrarItemEstoque.startcbox();
        janelaFormCadastrarItemEstoque.setVisible(true);
    }
    
    @Override
    public void fecharJanelaEModel(){
        janelaFormCadastrarItemEstoque.dispose();
        modeloCadastroItemEstoque = null;
        super.fecharJanelaEModel();
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }
    
    @Override
    public void salvar(String nom, Integer quant,String nomeItem){
        if(modeloCadastroItemEstoque.salvar(nom,quant,nomeItem))
            JOptionPane.showMessageDialog(janelaFormCadastrarItemEstoque, "Salvo com sucesso!");
        else
            JOptionPane.showMessageDialog(janelaFormCadastrarItemEstoque, "Não foi possível salvar, verificar os dados inseridos");
    }
    
    @Override
    public void abrirEditarLista()
    {
        janelaFormCadastrarItemEstoque.setVisible(false);
        super.criarController(new ControllerFormEditarLista(3));
    }

    @Override
    public List<IEntidadeItemEstoque> carregaUtensilios() {
        return modeloCadastroItemEstoque.buscarUtensilios();
    }
}
