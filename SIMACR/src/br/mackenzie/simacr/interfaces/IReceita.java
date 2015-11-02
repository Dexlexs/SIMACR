package br.mackenzie.simacr.interfaces;

import java.util.ArrayList;

public interface IReceita {

    public Long getId();

    public boolean getAviado();
    
    public ITriagem getITriagem();
    
    public ArrayList<IReceita_Medicamento> getIReceita_Medicamento();
}
