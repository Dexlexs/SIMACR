package br.mackenzie.simacr.interfaces;

public interface IReceita_Medicamento {
	public Long getId();
	
	public IReceita getIReceita();
	public IMedicamento getIMedicamento();
	
	public Integer getQuantidade();
	public String getPrescricao();
	
}
