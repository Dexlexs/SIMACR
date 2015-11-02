/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.views;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormReceitaMedicamentos;
import br.mackenzie.simacr.interfaces.IReceita_Medicamento;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class FormReceitaMedicamentos extends javax.swing.JFrame {

    IControllerFormReceitaMedicamentos controller;
    DefaultTableModel modelo;

    /**
     * Creates new form FormReceitaMedicamentos
     */
    public FormReceitaMedicamentos(IControllerFormReceitaMedicamentos var) {
        initComponents();
        controller = var;
        modelo = (DefaultTableModel) tblMedicamentos.getModel();
        popularTabela();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        itmFechar = new javax.swing.JMenu();
        itmAviar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simacr 2.0 - Aviamento de Receita");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "PrincipioAtivo", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMedicamentos);
        tblMedicamentos.getColumnModel().getColumn(0).setResizable(false);
        tblMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblMedicamentos.getColumnModel().getColumn(1).setResizable(false);
        tblMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblMedicamentos.getColumnModel().getColumn(2).setResizable(false);
        tblMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(50);

        itmFechar.setText("Fechar");
        itmFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmFecharMouseClicked(evt);
            }
        });
        jMenuBar1.add(itmFechar);

        itmAviar.setText("Aviar");
        itmAviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmAviarMouseClicked(evt);
            }
        });
        jMenuBar1.add(itmAviar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmFecharMouseClicked
        controller.cancelar();
    }//GEN-LAST:event_itmFecharMouseClicked

    private void itmAviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmAviarMouseClicked
        controller.aviar();
    }//GEN-LAST:event_itmAviarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controller.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void popularTabela() {
        for (IReceita_Medicamento rm : controller.getReceitaMedicamento()) {
            modelo.insertRow(modelo.getRowCount(), new Object[]{rm.getIMedicamento().getNomeComercial(), rm.getIMedicamento().getPrincipioAtivo(), rm.getQuantidade()});
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu itmAviar;
    private javax.swing.JMenu itmFechar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedicamentos;
    // End of variables declaration//GEN-END:variables
}
