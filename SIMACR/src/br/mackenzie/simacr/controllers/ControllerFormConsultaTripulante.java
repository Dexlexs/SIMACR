package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaTripulante;
import br.mackenzie.simacr.interfaces.ITripulante;
import br.mackenzie.simacr.models.MFormConsultaTripulante;
import br.mackenzie.simacr.views.FormConsultaTripulante;
import java.util.List;

public class ControllerFormConsultaTripulante extends ControllerFactory implements IControllerFormConsultaTripulante {

    FormConsultaTripulante janelaFormConsultaTripulante;
    MFormConsultaTripulante modeloFormConsultaTripulante;

    public ControllerFormConsultaTripulante() {
        super();
        modeloFormConsultaTripulante = new MFormConsultaTripulante();
        janelaFormConsultaTripulante = new FormConsultaTripulante(this,(super.getLogin().getProfissao().equals("Administrador")));
        
    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormConsultaTripulante.dispose();
        modeloFormConsultaTripulante = null;
        super.fecharJanelaEModel();
        //fecha a janela e remove o modelo e a funcao super.fecharJanelaEModel() remove o controlador da lista de controladores do controlador frontal
    }

    @Override
    public List<ITripulante> buscarTripulantes(String var) {
        //retorna a busca do tripulante
        return modeloFormConsultaTripulante.buscarTripulantes(var);
    }

    @Override
    public void cancelar() {
        //fechar o controller atual
        this.terminarControllers(1);

    }

    @Override
    public void abrirJanela() {
        //apenas mostra a tela
        janelaFormConsultaTripulante.pesquisar();
        janelaFormConsultaTripulante.setVisible(true);
        janelaFormConsultaTripulante.startFocus();

    }

    @Override
    public void abrirJanelaCadastro(Long var) {
        janelaFormConsultaTripulante.setVisible(false);
        super.criarController(new ControllerFormCadastroTripulante(var));
    }

    @Override
    public void abrirJanelaCadastro() {
        janelaFormConsultaTripulante.setVisible(false);
        super.criarController(new ControllerFormCadastroTripulante());
    }

    @Override
    public void criarReceita(Long idReceitado) {
        janelaFormConsultaTripulante.setVisible(false);
        
        super.criarController(new ControllerFormReceita(modeloFormConsultaTripulante.buscarTripulante(idReceitado),2));
    }
}
