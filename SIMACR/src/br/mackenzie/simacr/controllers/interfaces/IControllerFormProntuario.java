package br.mackenzie.simacr.controllers.interfaces;

import java.util.ArrayList;

import br.mackenzie.simacr.interfaces.IConsultaMedica;
import br.mackenzie.simacr.interfaces.IConsultaOdontologica;
import br.mackenzie.simacr.interfaces.IPaciente;


public interface IControllerFormProntuario {
	public void cancelar();
	public ArrayList<IConsultaMedica> buscarConsultasMedica();
	public void abrirConsultaMedica(Long var);

    public ArrayList<IConsultaOdontologica> buscarConsultasOdontologicas();

}
