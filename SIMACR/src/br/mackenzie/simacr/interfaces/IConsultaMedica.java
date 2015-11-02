package br.mackenzie.simacr.interfaces;

public interface IConsultaMedica {

    public Long getId();

    public ITriagem getITriagem();

    public String getSintoma();

    public String getAnamnese();

    public String getEvolucaoMedica();

    public String getHipoteseDiagnostica();
    
    public String getDataConsulta();
    
    public ITripulante getResponsavel();
}
