/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IFilaTriagem;
import br.mackenzie.simacr.interfaces.IPaciente;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface IControllerFormFilaTriagem {

    public void abrirTriagem(Long idPaciente);

    public void cancelar();

    public ArrayList<IFilaTriagem> CarregarFilaTriagem();
    
}
