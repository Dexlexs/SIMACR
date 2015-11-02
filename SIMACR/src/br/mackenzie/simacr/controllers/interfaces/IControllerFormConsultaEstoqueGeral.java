/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.controllers.interfaces;

import br.mackenzie.simacr.interfaces.IEntidadeComUmaString;
import br.mackenzie.simacr.interfaces.IEntidadeItemEstoque;
import java.util.List;

/**
 *
 * @author root
 */
public interface IControllerFormConsultaEstoqueGeral {

    public void cancelar();

    public void abrirFormCadastrarItemEstoque();

    public List<IEntidadeItemEstoque> pesquisar(String nomeTipo);

    public void abrirTipoUtensilio(Long id);
    
    public List<IEntidadeItemEstoque> carregaUtensilios();

    public long getIdUtensilio(String nomeUtensilio);
}
