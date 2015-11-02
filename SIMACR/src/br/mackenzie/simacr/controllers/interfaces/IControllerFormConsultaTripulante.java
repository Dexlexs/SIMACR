package br.mackenzie.simacr.controllers.interfaces;


import br.mackenzie.simacr.interfaces.ITripulante;
import java.util.List;

public interface IControllerFormConsultaTripulante {

    public void abrirJanelaCadastro();

    public List<ITripulante> buscarTripulantes(String var);    //busca do tripulante apartir do seu nome

    public void cancelar();

    public void abrirJanelaCadastro(Long var); //var = ID do tripulante
    
    public void criarReceita(Long idReceitado);
}
