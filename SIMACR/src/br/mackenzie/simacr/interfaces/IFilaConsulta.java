/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.interfaces;

import br.mackenzie.simacr.entidades.EntidadeTriagem;

/**
 *
 * @author root
 */
public interface IFilaConsulta {
    public Long getId();
    public ITriagem getITriagem();
    public String getNome();
    public Double getTemperatura();
}
