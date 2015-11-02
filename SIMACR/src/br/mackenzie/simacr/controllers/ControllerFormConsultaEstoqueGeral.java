/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaEstoqueGeral;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import br.mackenzie.simacr.models.MFormConsultaEstoqueGeral;
import br.mackenzie.simacr.views.FormConsultaEstoqueGeral;
import java.util.List;

/**
 *
 * @author root
 */
class ControllerFormConsultaEstoqueGeral extends ControllerFactory implements IControllerFormConsultaEstoqueGeral {

    private FormConsultaEstoqueGeral janelaFormConsultaEstoqueGeral;
    private MFormConsultaEstoqueGeral modeloFormConsultaEstoqueGeral;

    public ControllerFormConsultaEstoqueGeral() {
        super();
        modeloFormConsultaEstoqueGeral = new MFormConsultaEstoqueGeral();
        janelaFormConsultaEstoqueGeral = new FormConsultaEstoqueGeral(this);
    }

    @Override
    public void abrirJanela() {
        janelaFormConsultaEstoqueGeral.startcbox();
        janelaFormConsultaEstoqueGeral.setVisible(true);

    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);

    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormConsultaEstoqueGeral.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void abrirFormCadastrarItemEstoque() {
        janelaFormConsultaEstoqueGeral.setVisible(false);
        super.criarController(new ControllerFormCadastrarItemEstoque());
    }

    @Override
    public List<IEntidadeItemEstoque> pesquisar(String nomeTipo) {
        return modeloFormConsultaEstoqueGeral.buscarLista(nomeTipo);
    }

    @Override
    public void abrirTipoUtensilio(Long id) {
        janelaFormConsultaEstoqueGeral.setVisible(false);
        super.criarController(new ControllerFormDadosItemEstoque(id));
    }

    @Override
    public List<IEntidadeItemEstoque> carregaUtensilios() {
        return modeloFormConsultaEstoqueGeral.buscarUtensilios();
    }

    @Override
    public long getIdUtensilio(String nomeUtensilio)
    {
        return modeloFormConsultaEstoqueGeral.buscarIIE(nomeUtensilio).getId();
    }
}
