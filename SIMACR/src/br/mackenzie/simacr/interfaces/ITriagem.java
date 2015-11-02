package br.mackenzie.simacr.interfaces;

public interface ITriagem {
                public Long getId();

                public IPaciente getIPaciente();

                public String getSintoma();


                public Double getPeso();
                public Double getAltura();
                public String getPressao();
                public Double getDiametroCintura();
                public Double getTemperatura();
                public Double getIMC();


                public void setSintoma(String var);



                public void setPeso(Double var);
                public void setAltura(Double var);
                public void setPressao(String var);
                public void setDiametroCintura(Double var);
                public void setTemperatura(Double var);
                public void setIMC(Double var);


	
}
