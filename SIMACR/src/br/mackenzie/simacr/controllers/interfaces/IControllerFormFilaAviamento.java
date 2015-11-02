/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IFilaAviamento;
import br.mackenzie.simacr.interfaces.IReceita;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface IControllerFormFilaAviamento {

    public void cancelar();

    public ArrayList<IFilaAviamento> carregarFila();

    public void abrirManutencaoMedicamento();

    public void abrirReceitaMedicamentos(Long aLong);
    
}
