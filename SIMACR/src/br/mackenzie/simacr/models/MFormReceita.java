package br.mackenzie.simacr.models;

import br.mackenzie.simacr.controllers.ControllerFront;
import br.mackenzie.simacr.entidades.*;
import java.util.ArrayList;

import br.mackenzie.simacr.interfaces.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MFormReceita {

    public ArrayList<IMedicamento> buscaMedicamentos(String var) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        Query query;
        String busca = "SELECT e FROM EntidadeMedicamento e WHERE (nomeComercial LIKE '%" + var + "%')  ";
        query = manager.createQuery(busca);
        ArrayList<IMedicamento> retorno = (ArrayList<IMedicamento>) query.getResultList();
        return retorno;
    }

    public String salvarReceita(ITriagem varTriagem, ArrayList<String[]> varListaMedicamento, int tipoReceita, ITripulante varTripulante) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        boolean salva = true;
        if (tipoReceita == 0 || tipoReceita == 1) {
            for (EntidadeReceita it : (List<EntidadeReceita>) manager.createQuery("SELECT r FROM EntidadeReceita r WHERE (triagem = " + varTriagem.getId() + ")").getResultList()) {
                if (it.getTipo() == 1) {
                    if (tipoReceita == 1) {
                        salva = false;
                    }
                } else if (it.getTipo() == 0) {
                    if (tipoReceita == 0) {
                        salva = false;
                    }
                }
            }
        }
        if (salva) {
            EntidadeReceita er = new EntidadeReceita();
            ArrayList<EntidadeReceita_Medicamento> lerm = new ArrayList<EntidadeReceita_Medicamento>();
            for (String[] linha : varListaMedicamento) {
                EntidadeMedicamento emfor = manager.find(EntidadeMedicamento.class, Long.valueOf(linha[0]));
                EntidadeReceita_Medicamento erm = new EntidadeReceita_Medicamento();
                if (Integer.valueOf(linha[1]) > emfor.getEmEstoque()) {
                    return ("1" + emfor.getNomeComercial());
                }
                erm.setReceita(er);
                erm.setQuantidade(Integer.valueOf(linha[1]));
                emfor.setReservado(Integer.valueOf(linha[1]));
                erm.setPrescricao(linha[2]);
                erm.setMedicamento(emfor);
                manager.persist(erm);
                lerm.add(erm);
            }
            EntidadeTriagem et;
            et = manager.find(EntidadeTriagem.class, varTriagem.getId());
            EntidadeTripulante etripu = manager.find(EntidadeTripulante.class, varTripulante.getId());
            er.setTriagem(et);
            EntidadeFilaAviamento fa = new EntidadeFilaAviamento();
            fa.setTipoAviamento(tipoReceita);
            er.setReceita_Medicamento(lerm);
            er.setTripulante(etripu);
            er.setTipo(tipoReceita);
            fa.setReceita(er);
            fa.setNome(et.getPaciente().getNome());
            manager.persist(er);
            manager.persist(fa);
            manager.getTransaction().begin();
            manager.getTransaction().commit();
            imprimirReceita(varTriagem, tipoReceita);
            return "2";
        }
        return "0";

        //returns
        //0 = receita já existente
        //
        //
        //
        //
        //
    }

    public String salvarReceita(ITripulante varReceitado, ArrayList<String[]> varListaMedicamento, int tipoReceita, ITripulante varTripulante) {
        EntityManagerFactory factory;
        EntityManager manager;
        factory = Persistence.createEntityManagerFactory("simacrJPA");
        manager = factory.createEntityManager();
        EntidadeReceita er = new EntidadeReceita();
        ArrayList<EntidadeReceita_Medicamento> lerm = new ArrayList<EntidadeReceita_Medicamento>();
        for (String[] linha : varListaMedicamento) {
            EntidadeMedicamento emfor = manager.find(EntidadeMedicamento.class, Long.valueOf(linha[0]));
            EntidadeReceita_Medicamento erm = new EntidadeReceita_Medicamento();
            if (Integer.valueOf(linha[1]) > emfor.getEmEstoque()) {
                return ("1" + emfor.getNomeComercial());
            }
            erm.setReceita(er);
            erm.setQuantidade(Integer.valueOf(linha[1]));
            emfor.setReservado(Integer.valueOf(linha[1]));
            erm.setPrescricao(linha[2]);
            erm.setMedicamento(emfor);
            manager.persist(erm);
            lerm.add(erm);
        }
        EntidadeTripulante etripu = manager.find(EntidadeTripulante.class, varTripulante.getId());
        EntidadeFilaAviamento fa = new EntidadeFilaAviamento();
        fa.setTipoAviamento(tipoReceita);
        er.setReceita_Medicamento(lerm);
        er.setTripulante(etripu);
        er.setTipo(tipoReceita);
        fa.setReceita(er);
        fa.setNome(varReceitado.getNome());
        manager.persist(er);
        manager.persist(fa);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        return "2";

    }

    private boolean imprimirReceita(ITriagem varTriagem, int tipoReceita) {
        if (tipoReceita != 2) {
            EntityManagerFactory factory;
            EntityManager manager;
            factory = Persistence.createEntityManagerFactory("simacrJPA");
            manager = factory.createEntityManager();
            Query minhaQuery;
            EntidadeTriagem et;

            et = manager.find(EntidadeTriagem.class, varTriagem.getId());


            EntidadePaciente ep = et.getPaciente();
            EntidadeTripulante etripulante;
            minhaQuery = manager.createQuery("SELECT r FROM EntidadeReceita r WHERE (triagem = " + et.getId() + ") AND (tipo = " + tipoReceita + ")");

            EntidadeReceita er = (EntidadeReceita) minhaQuery.getSingleResult();
            List<EntidadeReceita_Medicamento> medicamentos;
            try {
                String tipo;
                if (tipoReceita == 1) {
                    tipo = "Receita Medica";
                } else if (tipoReceita == 0) {
                    tipo = "Receita Odontologica";
                } else {
                    tipo = "";
                }
                medicamentos = er.getReceita_Medicamento();
                etripulante = er.getTripulante();
                File diretorio = new File(System.getProperty("user.dir") + "/Receitas");
                diretorio.mkdir();
                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Receitas/" + et.getId() + "-" + ep.getNome() + ": " + tipo + ".txt"));

                writer.write(tipo);
                writer.newLine();
                writer.newLine();
                writer.write("Paciente: " + et.getIPaciente().getNome());
                writer.newLine();
                writer.newLine();
                writer.write("Medico responsável: " + etripulante.getNome());
                writer.newLine();
                writer.write("Data da triagem: " + et.getDataConsulta());
                writer.newLine();
                writer.newLine();
                writer.write("==Lista de remédios==");
                writer.newLine();
                writer.newLine();
                for (EntidadeReceita_Medicamento erm : medicamentos) {
                    writer.write("Nome Comercial: " + erm.getIMedicamento().getNomeComercial());
                    writer.newLine();
                    writer.write("Quantidade: " + erm.getQuantidade());
                    writer.newLine();
                    writer.write("Prescrição(Como se deve tomar o remédio):");
                    writer.newLine();
                    writer.write(erm.getPrescricao());
                    System.out.println(erm.getPrescricao());
                    writer.newLine();
                    writer.newLine();
                }
                writer.newLine();
                writer.newLine();
                writer.newLine();
                writer.newLine();
                writer.write("Assinatura do médico: _____________________");

                writer.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }
}