/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface IControllerFormConsultaOdontologica {
	public void terminar();
	public void cancelar();
	public ArrayList<String> buscaDadosPaciente();
	public void abrirPrescricao();
}
