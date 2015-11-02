/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public interface IControllerFormCadastroPaciente {

    public void cancelar();

    public void salvar(String nome, String profissao, String comunidade, String rio, String dataNascimento, String telefone, String cor, String naturalidade, String nacionalidade, String estadoCivil, String sexo);

    public void excluir();

    public void editarRios();

    public void editarCorDePeles();

    public void editarComunidades(String nomeRio);

    public ArrayList<IEntidadeComUmaString> carregaRio();

    public ArrayList<IEntidadeComUmaString> carregaCorPele();

    public ArrayList<IEntidadeComUmaString> carregaComunidade(String nomeRio);
    
    public String iniciarcboxcomu();
    
}