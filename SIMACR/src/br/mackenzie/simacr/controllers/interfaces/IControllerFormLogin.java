/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.entidades.EntidadeTripulante;

/**
 *
 * @author root
 */
public interface IControllerFormLogin {

   
    public void cancelar();

    public boolean verifica(String user, String pass);
    
}
