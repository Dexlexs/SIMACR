/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.views;



import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaMedica;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class FormConsultaMedica extends javax.swing.JFrame {

  
  private IControllerFormConsultaMedica controller;

    public FormConsultaMedica(IControllerFormConsultaMedica varController, boolean varTipo) {
         controller = varController;
        initComponents();        
        popularDados();
        if (varTipo) {
            janelaVisualizacao();
        }
        this.setVisible(true);
    }

       private void popularDados() {
        ArrayList<String> var = controller.buscaDadosPaciente();
        int aux = 0;
        txtPaciente.setText(var.get(aux++));
        txtDtNasciento.setText(String.valueOf(var.get(aux++)));
        txtPressao.setText(String.valueOf(var.get(aux++)));
        txtTemperatura.setText(String.valueOf(var.get(aux++)));
        txtPeso.setText(String.valueOf(var.get(aux++)));
        txtAltura.setText(String.valueOf(var.get(aux++)));
        txtDiametro_Cintura.setText(String.valueOf(var.get(aux++)));
        txtIMC.setText(String.valueOf(var.get(aux++)));
        txtSintoma_Principal.setText(String.valueOf(var.get(aux++)));
        if (var.size() > aux) {
            txtSintoma_Principal.setText(var.get(aux++));
            txtAnamnese.setText(var.get(aux++));
            txtEvolucao_Clinica.setText(var.get(aux++));
            txtHipotese_Diagnostico.setText(var.get(aux++));
        }

    }
       
      private void janelaVisualizacao() {
        txtSintoma_Principal.setEnabled(false);
        txtAnamnese.setEnabled(false);
        txtEvolucao_Clinica.setEnabled(false);
        txtHipotese_Diagnostico.setEnabled(false);
        mnuPrescricao.setEnabled(false);
        mnuFinalizar.setEnabled(false);
    }


    public ArrayList<String> getCampos() {
        ArrayList<String> retorno = new ArrayList<String>();
        retorno.add(txtSintoma_Principal.getText());
        retorno.add(txtAnamnese.getText());
        retorno.add(txtEvolucao_Clinica.getText());
        retorno.add(txtHipotese_Diagnostico.getText());
        return retorno;
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPaciente = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        txtDtNasciento = new javax.swing.JTextField();
        lblPressao = new javax.swing.JLabel();
        txtPressao = new javax.swing.JTextField();
        lblTemperatura = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblAltura = new javax.swing.JLabel();
        lblDiameto_Cintura = new javax.swing.JLabel();
        lblIMC = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtDiametro_Cintura = new javax.swing.JTextField();
        txtIMC = new javax.swing.JTextField();
        lblSintomas = new javax.swing.JLabel();
        lblAnamnese = new javax.swing.JLabel();
        lblEvolução_Clinica = new javax.swing.JLabel();
        lblHipotese_Diagnóstico = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSintoma_Principal = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAnamnese = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtEvolucao_Clinica = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtHipotese_Diagnostico = new javax.swing.JTextPane();
        txtTemperatura = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCancelar = new javax.swing.JMenu();
        mnuFinalizar = new javax.swing.JMenu();
        mnuPrescricao = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simacr 2.0 - Nova Consulta");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblPaciente.setText("Paciente");

        txtPaciente.setEnabled(false);

        lblNascimento.setText("Data de Nascimento");

        txtDtNasciento.setEnabled(false);

        lblPressao.setText("Pressão");

        txtPressao.setEnabled(false);

        lblTemperatura.setText("Temperatura");

        lblPeso.setText("Peso");

        lblAltura.setText("Altura");

        lblDiameto_Cintura.setText("Diametro da Cintura");

        lblIMC.setText("IMC");

        txtPeso.setEnabled(false);

        txtAltura.setEnabled(false);

        txtDiametro_Cintura.setEnabled(false);

        txtIMC.setEnabled(false);

        lblSintomas.setText("Sintoma Principal(Oque o paciente diz)");

        lblAnamnese.setText("Anamnese");

        lblEvolução_Clinica.setText("Evolução Clinica");

        lblHipotese_Diagnóstico.setText("Hipótese Diagnóstica ");

        txtSintoma_Principal.setEnabled(false);
        txtSintoma_Principal.setFocusCycleRoot(false);
        jScrollPane5.setViewportView(txtSintoma_Principal);

        jScrollPane6.setViewportView(txtAnamnese);

        jScrollPane7.setViewportView(txtEvolucao_Clinica);

        jScrollPane8.setViewportView(txtHipotese_Diagnostico);

        txtTemperatura.setEnabled(false);

        mnuCancelar.setText("Voltar");
        mnuCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCancelarMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuCancelar);

        mnuFinalizar.setText("Finalizar");
        mnuFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuFinalizarMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuFinalizar);

        mnuPrescricao.setText("Prescrição");
        mnuPrescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuPrescricaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuPrescricao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane8)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                        .addComponent(jScrollPane6)
                        .addComponent(jScrollPane5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaciente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTemperatura)
                                .addGap(18, 18, 18)
                                .addComponent(lblPeso)
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAltura)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSintomas)
                            .addComponent(lblAnamnese)
                            .addComponent(lblEvolução_Clinica)
                            .addComponent(lblHipotese_Diagnóstico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDtNasciento))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPressao)
                                    .addComponent(txtPressao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDiametro_Cintura)
                                    .addComponent(lblDiameto_Cintura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIMC)
                                    .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(lblNascimento)
                    .addComponent(lblPressao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDtNasciento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPressao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTemperatura)
                    .addComponent(lblPeso)
                    .addComponent(lblAltura)
                    .addComponent(lblDiameto_Cintura)
                    .addComponent(lblIMC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtDiametro_Cintura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(lblSintomas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblAnamnese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEvolução_Clinica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHipotese_Diagnóstico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuFinalizarMouseClicked
        controller.terminar();
    }//GEN-LAST:event_mnuFinalizarMouseClicked

    private void mnuCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCancelarMouseClicked
        controller.cancelar();
    }//GEN-LAST:event_mnuCancelarMouseClicked

    private void mnuPrescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuPrescricaoMouseClicked
        controller.abrirPrescricao();
    }//GEN-LAST:event_mnuPrescricaoMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controller.cancelar();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblAnamnese;
    private javax.swing.JLabel lblDiameto_Cintura;
    private javax.swing.JLabel lblEvolução_Clinica;
    private javax.swing.JLabel lblHipotese_Diagnóstico;
    private javax.swing.JLabel lblIMC;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPressao;
    private javax.swing.JLabel lblSintomas;
    private javax.swing.JLabel lblTemperatura;
    private javax.swing.JMenu mnuCancelar;
    private javax.swing.JMenu mnuFinalizar;
    private javax.swing.JMenu mnuPrescricao;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextPane txtAnamnese;
    private javax.swing.JTextField txtDiametro_Cintura;
    private javax.swing.JTextField txtDtNasciento;
    private javax.swing.JTextPane txtEvolucao_Clinica;
    private javax.swing.JTextPane txtHipotese_Diagnostico;
    private javax.swing.JTextField txtIMC;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPressao;
    private javax.swing.JTextPane txtSintoma_Principal;
    private javax.swing.JTextField txtTemperatura;
    // End of variables declaration//GEN-END:variables
}
