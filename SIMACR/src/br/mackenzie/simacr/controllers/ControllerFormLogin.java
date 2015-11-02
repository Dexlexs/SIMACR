/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormLogin;
import br.mackenzie.simacr.interfaces.ITripulante;
import br.mackenzie.simacr.models.MFormLogin;
import br.mackenzie.simacr.views.FormLogin;

/**
 *
 * @author root
 */
public class ControllerFormLogin extends ControllerFactory implements IControllerFormLogin {

    private FormLogin janelaFormLogin;
    private MFormLogin modeloFormLogin;

    public ControllerFormLogin() {
        super();
        modeloFormLogin = new MFormLogin();
        modeloFormLogin.iniciarPrograma();
        janelaFormLogin = new FormLogin(this);

    }

    @Override
    public void abrirJanela() {
        janelaFormLogin.setVisible(true);
        janelaFormLogin.startFocus();
    }

    @Override
    public void fecharJanelaEModel() {
        janelaFormLogin.dispose();
        modeloFormLogin = null;
        super.fecharJanelaEModel();
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public boolean verifica(String user, String pass) {
        ITripulante retorno = modeloFormLogin.verifica(user, pass);
        if (retorno != null) {
            janelaFormLogin.setVisible(false);
            super.voltarBase(retorno);
            return true;
        } else {
            return false;
        }
    }
}
