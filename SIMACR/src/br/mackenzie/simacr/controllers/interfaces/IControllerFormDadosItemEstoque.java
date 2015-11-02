/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.ILoteItemEstoque;
import java.util.List;

/**
 *
 * @author H_W
 */
public interface IControllerFormDadosItemEstoque {

    public String buscarNome();

    public String buscarTotal();

    public String buscarParcial();

    public void cancelar();

    public void remover(Integer quantidade);

    public void excluirLote(Long aLong);
    
    public void excluir();
    
    public List<ILoteItemEstoque> buscarLotes();
    
}
