/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.entidades;

import br.mackenzie.simacr.interfaces.IConsultaMedica;
import br.mackenzie.simacr.interfaces.ITriagem;
import br.mackenzie.simacr.interfaces.ITripulante;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
public class EntidadeConsultaMedica implements Serializable,IConsultaMedica {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private EntidadeTriagem triagem;
    
    @ManyToOne
    private EntidadeTripulante responsavel;
    
    private String dataConsulta;
    private String sintoma;
    private String anamnese;
    private String evolucaoMedica;
    private String hipoteseDiagnostica;
    


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
        if (!(object instanceof EntidadeConsultaMedica)) {
            return false;
        }
        EntidadeConsultaMedica other = (EntidadeConsultaMedica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mackenzie.simacr.entidades.EntidadeConsultaMedica[ id=" + id + " ]";
    }

    
    public EntidadeTriagem getTriagem() {
        return triagem;
    }
    
    @Override
    public ITriagem getITriagem()
    {
        return (ITriagem)triagem;
    }

    public void setTriagem(EntidadeTriagem var) {
       triagem = var;
    }

    @Override
    public String getSintoma() {
        return sintoma;
    }

    @Override
    public String getAnamnese() {
        return anamnese;
    }

    @Override
    public String getEvolucaoMedica() {
        return evolucaoMedica;
    }

    @Override
    public String getHipoteseDiagnostica() {
        return hipoteseDiagnostica;
    }


    public void setSintoma(String var) {
        sintoma = var;
    }


    public void setAnamnese(String var) {
        anamnese=var;
    }


    public void setEvolucaoMedica(String var) {
        evolucaoMedica=var;
    }


    public void setHipoteseDiagnostica(String var) {
        hipoteseDiagnostica=var;
    }
    
    public String getDataConsulta()
    {
        return dataConsulta;
    }
    
    public void setDataConsulta(String var)
    {
        dataConsulta = var;
    }
    
    public void setResponsavel(EntidadeTripulante var)
    {
        responsavel = var;
    }
    
    @Override
    public ITripulante getResponsavel()
    {
        return responsavel;
    }
    
}
