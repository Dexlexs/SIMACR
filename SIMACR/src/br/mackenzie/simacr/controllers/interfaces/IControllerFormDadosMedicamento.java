/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.ILote;
import br.mackenzie.simacr.interfaces.IMedicamento;
import java.util.List;

/**
 *
 * @author root
 */
public interface IControllerFormDadosMedicamento {

    public void abrirFormCadastrarLote();

    public void excluirLote(Long idMedicamento, String numeroLote);

    public void excluirMedicamento(Long id);

    public void cancelar();

    public List<ILote> getLotes(Long id);
    
}
