/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IPaciente;
import br.mackenzie.simacr.interfaces.ITriagem;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeTriagem implements Serializable,ITriagem {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private EntidadePaciente paciente;
    
    private Double diametroCintura;
    private Double peso;
    private Double IMC;
    private Double altura;
    private String pressao;
    private String sintoma;
    private Double temperatura;
    private String dataConsulta;

    public EntidadeTriagem()
    {
         Calendar cal = Calendar.getInstance();  
        int day = cal.get(Calendar.DATE);  
        int month = cal.get(Calendar.MONTH) + 1;  
        int year = cal.get(Calendar.YEAR);  
        dataConsulta = String.valueOf(day + "/" + month + "/" + year);
    }
    
    public String getDataConsulta()
    {
        return dataConsulta;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadeTriagem)) {
            return false;
        }
        EntidadeTriagem other = (EntidadeTriagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeTriagem[ id=" + id + " ]";
    }

    public EntidadePaciente getPaciente() {
        return paciente;
    }
    
    public IPaciente getIPaciente()
    {
        return (IPaciente)paciente;
    }
    



    public void setPaciente(EntidadePaciente var) {
        paciente = var;
    }



    @Override
    public String getSintoma() {
        return sintoma;
    }



    @Override
    public Double getPeso() {
        return peso;
    }

    @Override
    public Double getAltura() {
        return altura;
    }

    @Override
    public String getPressao() {
        return pressao;
    }

    @Override
    public Double getDiametroCintura() {
        return diametroCintura;
    }

    @Override
    public Double getTemperatura() {
        return temperatura;
    }

    @Override
    public Double getIMC() {
        return IMC;
    }

    @Override
    public void setSintoma(String var) {
        sintoma = var;
    }



    @Override
    public void setPeso(Double var) {
        peso = var;
    }

    @Override
    public void setAltura(Double var) {
        altura = var;
    }

    @Override
    public void setPressao(String var) {
        pressao = var;
    }

    @Override
    public void setDiametroCintura(Double var) {
        diametroCintura = var;
    }

    @Override
    public void setTemperatura(Double var) {
        temperatura = var;
    }

    @Override
    public void setIMC(Double var) {
        IMC = var;
    }
    
}
