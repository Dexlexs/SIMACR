/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaMedicamentos;
import br.mackenzie.simacr.interfaces.IMedicamento;
import br.mackenzie.simacr.models.MFormConsultaMedicamentos;
import br.mackenzie.simacr.views.FormConsultaMedicamentos;
import java.util.List;

/**
 *
 * @author root
 */
public class ControllerFormConsultaMedicamentos extends ControllerFactory implements IControllerFormConsultaMedicamentos{
    MFormConsultaMedicamentos modeloFormBuscaMedicamentos;
    FormConsultaMedicamentos janelaFormBuscaMedicamentos;

    public ControllerFormConsultaMedicamentos() {
    
    super();
    modeloFormBuscaMedicamentos =  new MFormConsultaMedicamentos();
    janelaFormBuscaMedicamentos = new FormConsultaMedicamentos(this);
        
    }
    
    
    
    @Override
    public void abrirJanela() {
        janelaFormBuscaMedicamentos.popularTabela();
        janelaFormBuscaMedicamentos.setVisible(true);
        janelaFormBuscaMedicamentos.requestFocus();
        
    }
    
     @Override
    public void fecharJanelaEModel()
    {
        modeloFormBuscaMedicamentos = null;
        janelaFormBuscaMedicamentos.dispose();
        super.fecharJanelaEModel();
    }


    @Override
    public List<IMedicamento> pesquisar(String nomeComercial, String principioAtivo, String laboratorio) {
        
        return modeloFormBuscaMedicamentos.buscarLista(nomeComercial, principioAtivo, laboratorio);
        
    }
    

    @Override
    public void abrirFormDadosMedicamento(Long id) {
        IMedicamento medicamento = modeloFormBuscaMedicamentos.buscarMedicamento(id);
        janelaFormBuscaMedicamentos.setVisible(false);
        super.criarController(new ControllerFormDadosMedicamento(medicamento));
    }

    @Override
    public void abrirFormNovoMedicamento() {
        janelaFormBuscaMedicamentos.setVisible(false);
        super.criarController(new ControllerFormCadastrarMedicamentos());
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }
    
}
