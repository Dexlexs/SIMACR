package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.controllers.ControllerFactory;
import br.mackenzie.simacr.interfaces.ITripulante;

public interface IControllerFront {

    public void novoController(ControllerFactory var);

    public void removerController(int var);

    public void voltaBase(ITripulante var);

    public int getTamanhoLista();

    public void terminarNControllers(int var);

    public ITripulante getLogin();
}
