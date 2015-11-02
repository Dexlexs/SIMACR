/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

/**
 *
 * @author root
 */
public interface IControllerFormTriagem {

    public void cancelar();

    public void salvarTriagem(Double altura, Double diametroCintura, Double IMC, Double peso, String pressao, String sintoma, Double temperatura, boolean filaConsultaMedica,boolean filaConsultaOdontologica);
    
}
