/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

/**
 *
 * @author root
 */
public interface IControllerFormCadastrarMedicamentos {

    public void salvarMedicamentos(String nomeComercial, String principioAtivo, String formaFarmaceutica, String laboratorio);

    public void cancelar();
    
}
