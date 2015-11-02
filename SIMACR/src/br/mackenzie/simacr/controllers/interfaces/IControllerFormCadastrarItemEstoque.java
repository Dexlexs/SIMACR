/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import java.util.List;

/**
 *
 * @author root
 */
public interface IControllerFormCadastrarItemEstoque {
    
    public void cancelar();
    
    public void salvar(String nom, Integer num, String nomeItem);
    
    public void abrirEditarLista();

    public List<IEntidadeItemEstoque> carregaUtensilios();
    
    
}
