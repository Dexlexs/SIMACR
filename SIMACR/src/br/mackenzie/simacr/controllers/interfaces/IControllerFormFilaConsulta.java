package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IFilaConsulta;
import br.mackenzie.simacr.interfaces.IFilaTriagem;
import java.util.ArrayList;

public interface IControllerFormFilaConsulta {

    public ArrayList<IFilaConsulta> buscaTriagens();

    public void cancelar();

    public void abrirProntuario(Long var);

    public boolean getTipo();
}
