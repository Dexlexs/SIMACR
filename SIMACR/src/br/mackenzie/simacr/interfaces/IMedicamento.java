package br.mackenzie.simacr.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IMedicamento {

    public Long getId();

    public ArrayList<ILote> getILotes();

    public String getNomeComercial();

    public String getPrincipioAtivo();

    public String getLaboratorio();

    public String getFormaFarmaceutica();

    public Integer getEmEstoque();

    public Integer getEmReserva();
    
    public Integer getQtdMedicamento();
}