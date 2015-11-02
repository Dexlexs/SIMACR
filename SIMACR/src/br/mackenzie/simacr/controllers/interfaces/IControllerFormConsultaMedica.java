package br.mackenzie.simacr.controllers.interfaces;

import java.util.ArrayList;

public interface IControllerFormConsultaMedica {
	public void terminar();
	public void cancelar();
	public ArrayList<String> buscaDadosPaciente();
	public void abrirPrescricao();
}
