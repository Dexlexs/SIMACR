/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormDadosItemEstoque;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import br.mackenzie.simacr.interfaces.ILoteItemEstoque;
import br.mackenzie.simacr.models.MFormDadosItemEstoque;
import br.mackenzie.simacr.views.FormDadosItemEstoque;
import java.util.List;

/**
 *
 * @author H_W
 */
public class ControllerFormDadosItemEstoque extends ControllerFactory implements IControllerFormDadosItemEstoque {

    MFormDadosItemEstoque modelo;
    FormDadosItemEstoque janela;
    IEntidadeItemEstoque itemEstoque;

    public ControllerFormDadosItemEstoque(Long id) {
        super();
        modelo = new MFormDadosItemEstoque();
        itemEstoque = modelo.buscarItemEstoque(id);
        janela = new FormDadosItemEstoque(this);
    }

    @Override
    public void abrirJanela() {
        janela.update();
        janela.setVisible(true);
    }

    @Override
    public String buscarNome() {
        return itemEstoque.getNome();
    }

    @Override
    public String buscarTotal() {
        return String.valueOf(itemEstoque.getTotal());
    }

    @Override
    public String buscarParcial() {
        return String.valueOf(itemEstoque.getQuantidade());
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public void remover(Integer quantidade) {
        modelo.remover(itemEstoque, quantidade);
        janela.update();
    }

    @Override
    public void excluirLote(Long aLong) {
        ILoteItemEstoque loteItemEstoque = modelo.buscarLote(aLong);
        modelo.excluirLote(itemEstoque, loteItemEstoque);
        janela.update();
    }

    @Override
    public List<ILoteItemEstoque> buscarLotes() {
        return modelo.buscarLote(itemEstoque);
    }

    @Override
    public void excluir() {
        modelo.excluir(itemEstoque);
    }
    
    @Override
    public void fecharJanelaEModel()
    {
        modelo = null;
        janela.dispose();
        super.fecharJanelaEModel();
    }
}
