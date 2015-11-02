package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormReceita;
import br.mackenzie.simacr.interfaces.IMedicamento;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.interfaces.ITripulante;
import br.mackenzie.simacr.models.MFormReceita;
import br.mackenzie.simacr.views.FormReceita;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerFormReceita extends ControllerFactory implements IControllerFormReceita {

    FormReceita janelaFormReceita;
    MFormReceita modeloFormReceita;
    ITriagem objetoTriagem;
    ITripulante objetoTripulante;
    boolean precisaSalvar;
    int tipoReceita;

    public ControllerFormReceita(ITriagem varTriagem, int tipo) {
        super();
        objetoTriagem = varTriagem;
        objetoTripulante = null;
        precisaSalvar = false;
        tipoReceita = tipo;
        janelaFormReceita = new FormReceita(this);
        modeloFormReceita = new MFormReceita();
    }

    public ControllerFormReceita(ITripulante varTripulante, int tipo) {
        super();
        objetoTriagem = null;
        objetoTripulante = varTripulante;
        precisaSalvar = false;
        tipoReceita = tipo;
        janelaFormReceita = new FormReceita(this);
        modeloFormReceita = new MFormReceita();
    }

    @Override
    public ArrayList<IMedicamento> buscarMedicamentos(String var) {
        return modeloFormReceita.buscaMedicamentos(var);
    }

    @Override
    public void terminar() {
        precisaSalvar = true;
        if (tipoReceita != 2) {
            super.terminarControllers(3);
        }
        else
            super.terminarControllers(2);

    }

    @Override
    public void fecharJanelaEModel() {
        modeloFormReceita = null;
        janelaFormReceita.dispose();
        super.fecharJanelaEModel();
    }

    @Override
    public void abrirJanela() {
        precisaSalvar = false;
        janelaFormReceita.setVisible(true);
    }

    @Override
    public void cancelar() {
        precisaSalvar = false;
        super.terminarControllers(1);
    }

    @Override
    public void finalizar() {
        if (precisaSalvar == true) {
            String retorno;
            if (tipoReceita != 2) {
                retorno = modeloFormReceita.salvarReceita(objetoTriagem, janelaFormReceita.getListaReceita(), tipoReceita, super.getLogin());
            } else {
                retorno = modeloFormReceita.salvarReceita(objetoTripulante, janelaFormReceita.getListaReceita(), tipoReceita, super.getLogin());
            }
            int caso = Integer.valueOf(retorno.charAt(0));
            switch (caso) {
                case (0):
                    JOptionPane.showMessageDialog(janelaFormReceita, "Receita já existente");
                    return;
                case (1):
                    JOptionPane.showMessageDialog(janelaFormReceita, "Medicamento insuficiente: " + retorno.substring(1, retorno.length() - 1));
                    return;
            }

        }
        super.finalizar();
    }

    @Override
    public String buscarNomePaciente() {
        if (tipoReceita != 2) {
            return objetoTriagem.getIPaciente().getNome();
        } else {
            return objetoTripulante.getNome();
        }
    }
}
