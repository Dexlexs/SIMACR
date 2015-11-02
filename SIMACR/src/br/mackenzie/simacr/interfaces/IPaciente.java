package br.mackenzie.simacr.interfaces;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public interface IPaciente {
	public Long getId();
	public String getNome();
	public String getDataNascimento();
	public String getProfissao();
	public String getCor();
	public String getNacionalidade();
	public String getNaturalidade();
	public String getComunidade();
	public String getRio();
	public String getEstadoCivil();
	public String getSexo();
	public String getTelefone();

	
	
	public void setNome(String var);
	public void setDataNascimento(String var);
	public void setProfissao(String var);
	public void setCor(String var);
	public void setNacionalidade(String var);
	public void setNaturalidade(String var);
	public void setComunidade(String var);
	public void setRio(String var);
	public void setEstadoCivil(String var);
	public void setSexo(String var);
	public void setTelefone(String var);
	
	


}
