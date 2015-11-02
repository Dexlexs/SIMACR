/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IMedicamento;
import java.util.List;

/**
 *
 * @author root
 */
public interface IControllerFormConsultaMedicamentos {

    public List<IMedicamento> pesquisar(String nomeComercial, String principioAtivo, String laboratorio);

    public void abrirFormDadosMedicamento(Long id);

    public void abrirFormNovoMedicamento();

    public void cancelar();
    
}
