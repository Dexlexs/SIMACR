/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface IControllerFormReceitaMedicamentos {

    public void cancelar();

    public void aviar();

    public ArrayList<IReceita_Medicamento> getReceitaMedicamento();
    
}
