package br.mackenzie.simacr.interfaces;

public interface IProntuario {
	public Long getId();
	
	public ITriagem getTriagem();
	public IConsultaMedica getConsultaMedica();
	
	public void setTriagem(ITriagem var);
	public void setConsultaMedica(IConsultaMedica var);
	
	public String getNomeMedico();
	
	public void setNomeMedico(String var);

}
