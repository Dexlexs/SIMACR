/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.views;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormFilaTriagem;
import br.mackenzie.simacr.interfaces.IFilaTriagem;
import br.mackenzie.simacr.interfaces.IPaciente;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class FormFilaTriagem extends javax.swing.JFrame {

    IControllerFormFilaTriagem controller;
    DefaultTableModel modelo;

    /**
     * Creates new form FormTriagem
     */
    public FormFilaTriagem(IControllerFormFilaTriagem var) {
        controller = var;
        initComponents();
        modelo = (DefaultTableModel) tblTriagens.getModel();
        tblTriagens.removeColumn(tblTriagens.getColumnModel().getColumn(1));
        this.carregar();
        this.setVisible(true);
        this.startFocus();
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
        tblTriagens = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        itmVoltar = new javax.swing.JMenu();
        itmCarregar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simacr 2.0 - Fila para Triagem");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblTriagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTriagens.getTableHeader().setReorderingAllowed(false);
        tblTriagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTriagensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTriagens);
        tblTriagens.getColumnModel().getColumn(0).setResizable(false);
        tblTriagens.getColumnModel().getColumn(1).setResizable(false);
        tblTriagens.getColumnModel().getColumn(1).setPreferredWidth(10);

        itmVoltar.setText("Voltar");
        itmVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmVoltarMouseClicked(evt);
            }
        });
        jMenuBar1.add(itmVoltar);

        itmCarregar.setText("Carregar Triagens");
        itmCarregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmCarregarMouseClicked(evt);
            }
        });
        jMenuBar1.add(itmCarregar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void startFocus() {
        tblTriagens.requestFocus();
    }

    private void tblTriagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTriagensMouseClicked
        if (evt.getClickCount() > 1) {
            JTable target = (JTable) evt.getSource();
            controller.abrirTriagem((Long) modelo.getValueAt(target.getSelectedRow(), 1));
            limparTabela();
        }

    }//GEN-LAST:event_tblTriagensMouseClicked

    public void carregar() {
        itmCarregarMouseClicked(null);
    }

    private void itmVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmVoltarMouseClicked
        controller.cancelar();
    }//GEN-LAST:event_itmVoltarMouseClicked

    private void itmCarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmCarregarMouseClicked
        limparTabela();
        for (IFilaTriagem fila : controller.CarregarFilaTriagem()) {
            modelo.insertRow(modelo.getRowCount(), new Object[]{fila.getIPaciente().getNome(), fila.getId()});
        }
    }//GEN-LAST:event_itmCarregarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controller.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void limparTabela() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu itmCarregar;
    private javax.swing.JMenu itmVoltar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTriagens;
    // End of variables declaration//GEN-END:variables
}