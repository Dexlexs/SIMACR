/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;


import br.mackenzie.simacr.controllers.interfaces.IControllerFormCadastrarMedicamentos;
import br.mackenzie.simacr.models.MFormCadastrarMedicamentos;
import br.mackenzie.simacr.views.FormCadastrarMedicamentos;

/**
 *
 * @author root
 */
public class ControllerFormCadastrarMedicamentos extends ControllerFactory implements IControllerFormCadastrarMedicamentos {
  
    private FormCadastrarMedicamentos janelaFormCadastrarMedicamentos;
    private MFormCadastrarMedicamentos modeloFormCadastrarMedicamentos;
    
    public ControllerFormCadastrarMedicamentos()
    {
        super();
        modeloFormCadastrarMedicamentos =  new MFormCadastrarMedicamentos();
        janelaFormCadastrarMedicamentos = new FormCadastrarMedicamentos(this);
    }
    
    @Override
    public void abrirJanela() {
        janelaFormCadastrarMedicamentos.setVisible(true);
        janelaFormCadastrarMedicamentos.requestFocus();
    }
    
    @Override
    public void fecharJanelaEModel()
    {
        modeloFormCadastrarMedicamentos = null;
        janelaFormCadastrarMedicamentos.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void salvarMedicamentos(String nomeComercial, String principioAtivo, String formaFarmaceutica, String laboratorio) {
        modeloFormCadastrarMedicamentos.salvarMedicamentos(nomeComercial, principioAtivo, formaFarmaceutica, laboratorio);
        super.terminarControllers(1);
    }

    @Override
    public void cancelar() {
         super.terminarControllers(1);
        
    }
    
}
