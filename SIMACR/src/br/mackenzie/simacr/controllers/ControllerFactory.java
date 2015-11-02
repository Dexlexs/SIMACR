package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFront;
import br.mackenzie.simacr.interfaces.ITripulante;

public abstract class ControllerFactory {

    private int posicao;
    private IControllerFront controllerFront;

    ControllerFactory() {

        controllerFront = ControllerFront.getInstance();
        posicao = controllerFront.getTamanhoLista();
    }

    public IControllerFront getControllerFront() {
        return controllerFront;
    }

    ControllerFactory(ControllerFactory varControllerFactory) {
        controllerFront = ControllerFront.getInstance();
        posicao = controllerFront.getTamanhoLista();
    }

    public void setPosicao(int var) {
        posicao = var;
    }

    public void criarController(ControllerFactory var) {
        controllerFront.novoController(var);
    }

    public void fecharJanelaEModel() {
        controllerFront.removerController(this.posicao);
        controllerFront = null;
    }

    public void finalizar() {
        this.fecharJanelaEModel();
    }

    public abstract void abrirJanela();

    public void terminarControllers(int var) {
        controllerFront.terminarNControllers(var);
    }
    
    public ITripulante getLogin()
    {
        return controllerFront.getLogin();
    }
    
    public void voltarBase(ITripulante var)
    {
        controllerFront.voltaBase(var);
    }
}
