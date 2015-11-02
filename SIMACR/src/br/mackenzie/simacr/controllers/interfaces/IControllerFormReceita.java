package br.mackenzie.simacr.controllers.interfaces;


import java.util.ArrayList;

import br.mackenzie.simacr.interfaces.IMedicamento;

public interface IControllerFormReceita{
	public ArrayList<IMedicamento> buscarMedicamentos(String var);
	public void terminar();
	public void cancelar();
                 public String buscarNomePaciente();
}
