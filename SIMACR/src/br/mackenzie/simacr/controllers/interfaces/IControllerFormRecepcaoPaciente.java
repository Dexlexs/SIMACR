/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IPaciente;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public interface IControllerFormRecepcaoPaciente {

    public void cancelar();

    public void abrirFormCadastroPaciente();

    public ArrayList<IPaciente> buscarPacientes(String nome, String comunidade, String rio);

    public void abrirFormCadastroPaciente(Long aLong);

    public void enviarTriagem(Long var);

    public ArrayList<IEntidadeComUmaString> getComunidades(String nomeRio);

    public ArrayList<IEntidadeComUmaString> getRios();
    
}
