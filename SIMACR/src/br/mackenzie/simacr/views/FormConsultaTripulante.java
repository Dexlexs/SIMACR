/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.views;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaTripulante;
import br.mackenzie.simacr.interfaces.ITripulante;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class FormConsultaTripulante extends javax.swing.JFrame {

    private IControllerFormConsultaTripulante controller;
    private DefaultTableModel modelo;       //objeto do modelo de tabela

    public FormConsultaTripulante(IControllerFormConsultaTripulante var,boolean tipo) {
        controller = var;
        initComponents();
        if(!tipo)
            itmNovo.setVisible(false);
        modelo = (DefaultTableModel) tblPesquisa.getModel();
        this.pesquisar();
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

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisa = new javax.swing.JTable();
        menuOpcoes = new javax.swing.JMenuBar();
        itmVoltar = new javax.swing.JMenu();
        itmNovo = new javax.swing.JMenu();
        itmCriarReceita = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simacr 2.0 - Consulta de Tripulantes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNome.setText("Nome:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sexo", "Naturalidade", "Nascimento", "Profissão", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPesquisa.setColumnSelectionAllowed(true);
        tblPesquisa.getTableHeader().setResizingAllowed(false);
        tblPesquisa.getTableHeader().setReorderingAllowed(false);
        tblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisa);
        tblPesquisa.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPesquisa.getColumnModel().getColumn(0).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblPesquisa.getColumnModel().getColumn(1).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPesquisa.getColumnModel().getColumn(2).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblPesquisa.getColumnModel().getColumn(3).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblPesquisa.getColumnModel().getColumn(4).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblPesquisa.getColumnModel().getColumn(5).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(5).setPreferredWidth(40);

        itmVoltar.setText("Voltar");
        itmVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmVoltarMouseClicked(evt);
            }
        });
        menuOpcoes.add(itmVoltar);

        itmNovo.setText("CadastrarTripulante");
        itmNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmNovoMouseClicked(evt);
            }
        });
        menuOpcoes.add(itmNovo);

        itmCriarReceita.setText("CriarNovaReceita");
        itmCriarReceita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmCriarReceitaMouseClicked(evt);
            }
        });
        menuOpcoes.add(itmCriarReceita);

        setJMenuBar(menuOpcoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void startFocus() {
        txtNome.requestFocus();
    }
    private void tblPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisaMouseClicked
        if (evt.getClickCount() > 1) {
            JTable target = (JTable) evt.getSource();
            if(itmNovo.isVisible())
                controller.abrirJanelaCadastro((Long) modelo.getValueAt(target.getSelectedRow(), 5));
            else
                controller.criarReceita((Long) modelo.getValueAt(tblPesquisa.getSelectedRow(), 5));
        }
    }//GEN-LAST:event_tblPesquisaMouseClicked

    private void itmVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmVoltarMouseClicked
        controller.cancelar();
    }//GEN-LAST:event_itmVoltarMouseClicked

    private void itmNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmNovoMouseClicked
        controller.abrirJanelaCadastro();
    }//GEN-LAST:event_itmNovoMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.pesquisar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controller.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void itmCriarReceitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmCriarReceitaMouseClicked
        if (tblPesquisa.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecionar um tripulante");
        } else {

            controller.criarReceita((Long) modelo.getValueAt(tblPesquisa.getSelectedRow(), 5));
        }
    }//GEN-LAST:event_itmCriarReceitaMouseClicked
    public void limparTabela() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void pesquisar() {
        limparTabela();
        for (ITripulante tri : controller.buscarTripulantes(txtNome.getText().trim())) {
            modelo.insertRow(modelo.getRowCount(), new Object[]{tri.getNome(), tri.getSexo(), tri.getNaturalidade(), tri.getNascimento().toString(), tri.getProfissao(), tri.getId()});
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JMenu itmCriarReceita;
    private javax.swing.JMenu itmNovo;
    private javax.swing.JMenu itmVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JMenuBar menuOpcoes;
    private javax.swing.JTable tblPesquisa;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
