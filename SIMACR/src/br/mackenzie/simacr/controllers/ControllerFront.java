package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFront;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.util.ArrayList;

public class ControllerFront implements IControllerFront {

    private ArrayList<ControllerFactory> listaController;
    private static ControllerFront controlador = null;
    private ITripulante idLogin = null;

    private ControllerFront() {
        listaController = new ArrayList<ControllerFactory>();
    }

    protected static ControllerFront getInstance() {
        if (controlador == null) {
            controlador = new ControllerFront();
            return controlador;
        } else {
            return controlador;
        }
    }

    @Override
    public ITripulante getLogin() {
        return idLogin;
    }

    public void setLogin(ITripulante var) {
        idLogin = var;
    }

    @Override
    public void novoController(ControllerFactory var) {
        listaController.add(var);
    }

    @Override
    public void removerController(int var) {
        listaController.remove(var);
        int aux;
        for (aux = var; aux < listaController.size(); aux++) {
            listaController.get(aux).setPosicao(aux);
        }
    }

    @Override
    public void voltaBase(ITripulante var) {
        listaController.get(0).fecharJanelaEModel();
        if (idLogin == null) {
            idLogin = var;
            novoController(new ControllerFormTelaBase());
        } else
        {
            idLogin = null;
            novoController(new ControllerFormLogin());
        }
    }

    @Override
    public int getTamanhoLista() {
        try {
            return listaController.size();
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    @Override
    public void terminarNControllers(int var) {
        int aux;
        for (aux = (listaController.size() - 1); aux >= 0 && var > 0; aux--) {
            listaController.get(aux).finalizar();
            var--;
        }
        if (listaController.size() > 0) {
            listaController.get(aux).abrirJanela();
        }

    }
}
