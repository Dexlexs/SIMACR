/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

/**
 *
 * @author root
 */


public interface IControllerFormCadastrarLote {

    public void salvarLote(String numLote, String validade, Integer unidades,String adquirido);

    public void cancelar();
    
}
