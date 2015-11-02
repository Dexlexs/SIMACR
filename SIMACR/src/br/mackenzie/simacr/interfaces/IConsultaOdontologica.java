/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.interfaces;

/**
 *
 * @author root
 */
public interface IConsultaOdontologica {

    public Long getId();

    public ITriagem getITriagem();
    
    public String getEvolucao();
    
    public String getObservacao();

    public String getDataConsulta();    
    
    public ITripulante getResponsavel();    
}
