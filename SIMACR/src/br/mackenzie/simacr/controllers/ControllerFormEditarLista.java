/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormEditarLista;
import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.models.MFormEditarLista;
import br.mackenzie.simacr.views.FormEditarLista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author H_W
 */
public class ControllerFormEditarLista extends ControllerFactory implements IControllerFormEditarLista {

    MFormEditarLista modelo;
    FormEditarLista janela;
    int varTipo;
    long idRio;

    public ControllerFormEditarLista(int tipo) {
        modelo = new MFormEditarLista();
        varTipo = tipo;
        String titulo = "Simacr 2.0 - ";
        switch (varTipo) {
            case (1):
                titulo = titulo.concat("Editar Lista de cor de pele");
                break;
            case (2):
                titulo = titulo.concat("Editar Lista de rios");
                break;
                case(3):
                    titulo = titulo.concat("Editar Lista de Utensilios");
                    break;
        }
        janela = new FormEditarLista(this, titulo);
    }

    public ControllerFormEditarLista(long id) {
        idRio = id;
        modelo = new MFormEditarLista();
        varTipo = 0;
        String titulo = "Simacr 2.0 - Comunidades(Rio - ";
        titulo = titulo.concat(modelo.getNomeRio(idRio));
        titulo = titulo.concat(")");
        janela = new FormEditarLista(this, titulo);
    }

    @Override
    public void abrirJanela() {
        janela.setVisible(true);
        janela.startFocus();
    }

    @Override
    public boolean adicionarNovo() {
        String auxiliar = "Adicionar ";
        switch (varTipo) {
            case (0):
                auxiliar = "nova comunidade";
                break;
            case (1):
                auxiliar = "nova cor de pele";
                break;
            case (2):
                auxiliar = "novo rio";
                break;
               case(3):
                   auxiliar = "novo utensílio";
                   break;
        }
        String novoItem = JOptionPane.showInputDialog(janela, "Nome do item a ser adicionado", auxiliar);
        if (novoItem != null) {
            switch (varTipo) {
                case (0):
                    modelo.salvarUmaComunidade(novoItem, idRio);
                    break;
                case (1):
                    modelo.salvarUmaCorDePele(novoItem);
                    break;
                case (2):
                    modelo.salvarUmaRio(novoItem);
                    break;
                    case(3):
                        modelo.salvarUmUtensilio(novoItem);
            }
            return true;
        }
        return false;
    }

    @Override
    public void fecharJanelaEModel()
    {
        modelo = null;
        janela.dispose();
        super.fecharJanelaEModel();
    }
    
    @Override
    public void remover(Long varId) {
        modelo.remover(varId,varTipo);
    }

    @Override
    public void salvar(ArrayList<String> nomes, ArrayList<Long> ids) {
        modelo.salvarTodaLista(nomes, ids,varTipo);
        super.terminarControllers(1);
    }

    @Override
    public void cancelar() {
        super.terminarControllers(1);
    }

    @Override
    public ArrayList<IEntidadeComUmaString> getLista() {
        switch (varTipo) {
            case (0):
                return modelo.getComunidades(idRio);
            case (1):
                return modelo.getCorDePeles();
            case (2):
                return modelo.getRios();
                case(3):
                    return modelo.getUtensilios();
            default: 
                return null;
        }
    }
}
