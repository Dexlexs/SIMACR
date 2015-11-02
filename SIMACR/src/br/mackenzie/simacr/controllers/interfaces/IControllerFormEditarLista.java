/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import java.util.ArrayList;

/**
 *
 * @author H_W
 */
public interface IControllerFormEditarLista {

    public boolean adicionarNovo();

    public void remover(Long varId);

    public void salvar(ArrayList<String> nomes, ArrayList<Long> ids);

    public void cancelar();

    public ArrayList<IEntidadeComUmaString> getLista();
    
}
