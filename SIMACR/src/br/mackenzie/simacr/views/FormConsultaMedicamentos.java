/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.simacr.views;

import br.mackenzie.simacr.controllers.interfaces.IControllerFormConsultaMedicamentos;
import br.mackenzie.simacr.interfaces.IMedicamento;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class FormConsultaMedicamentos extends javax.swing.JFrame {

    private IControllerFormConsultaMedicamentos controller;
    private DefaultTableModel model;

    /**
     * Creates new form FormBuscaMedicamentos
     */
    public FormConsultaMedicamentos(IControllerFormConsultaMedicamentos var) {
        initComponents();
        initTable();
        this.setVisible(true);
        this.requestFocus();
        controller = var;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomeComercial = new javax.swing.JLabel();
        lblPrincipioAtivo = new javax.swing.JLabel();
        lblLaboratorio = new javax.swing.JLabel();
        txtNomeComercial = new javax.swing.JTextField();
        txtPrincipioAtivo = new javax.swing.JTextField();
        txtLaboratorio = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisarMedicamento = new javax.swing.JTable();
        menuOpcoes = new javax.swing.JMenuBar();
        menuCancelar = new javax.swing.JMenu();
        menuNovoMedicamento = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simacr 2.0 - Consulta de Medicamentos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNomeComercial.setText("Nome Comercial");

        lblPrincipioAtivo.setText("Principio Ativo");

        lblLaboratorio.setText("Laboratório");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblPesquisarMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Comercial", "Principio Ativo", "Laboratorio", "Quantidade Em Estoque", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPesquisarMedicamento.getTableHeader().setReorderingAllowed(false);
        tblPesquisarMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisarMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisarMedicamento);
        tblPesquisarMedicamento.getColumnModel().getColumn(0).setResizable(false);
        tblPesquisarMedicamento.getColumnModel().getColumn(0).setPreferredWidth(1);
        tblPesquisarMedicamento.getColumnModel().getColumn(1).setResizable(false);
        tblPesquisarMedicamento.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPesquisarMedicamento.getColumnModel().getColumn(2).setResizable(false);
        tblPesquisarMedicamento.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblPesquisarMedicamento.getColumnModel().getColumn(3).setResizable(false);
        tblPesquisarMedicamento.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblPesquisarMedicamento.getColumnModel().getColumn(4).setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeComercial)
                    .addComponent(txtNomeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrincipioAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrincipioAtivo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLaboratorio)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeComercial)
                    .addComponent(lblPrincipioAtivo)
                    .addComponent(lblLaboratorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrincipioAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(txtLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        menuCancelar.setText("Voltar");
        menuCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCancelarMouseClicked(evt);
            }
        });
        menuOpcoes.add(menuCancelar);

        menuNovoMedicamento.setText("Cadastrar Medicamento");
        menuNovoMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNovoMedicamentoMouseClicked(evt);
            }
        });
        menuOpcoes.add(menuNovoMedicamento);

        setJMenuBar(menuOpcoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        popularTabela();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblPesquisarMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisarMedicamentoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() > 1) {
            JTable target = (JTable) evt.getSource();
            controller.abrirFormDadosMedicamento((Long) model.getValueAt(target.getSelectedRow(), 0));
            initTable();
        }
    }//GEN-LAST:event_tblPesquisarMedicamentoMouseClicked

    private void menuNovoMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNovoMedicamentoMouseClicked
        // TODO add your handling code here:
        controller.abrirFormNovoMedicamento();
        initTable();
    }//GEN-LAST:event_menuNovoMedicamentoMouseClicked

    private void menuCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCancelarMouseClicked
        // TODO add your handling code here:
        controller.cancelar();
    }//GEN-LAST:event_menuCancelarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controller.cancelar();
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLaboratorio;
    private javax.swing.JLabel lblNomeComercial;
    private javax.swing.JLabel lblPrincipioAtivo;
    private javax.swing.JMenu menuCancelar;
    private javax.swing.JMenu menuNovoMedicamento;
    private javax.swing.JMenuBar menuOpcoes;
    private javax.swing.JTable tblPesquisarMedicamento;
    private javax.swing.JTextField txtLaboratorio;
    private javax.swing.JTextField txtNomeComercial;
    private javax.swing.JTextField txtPrincipioAtivo;
    // End of variables declaration//GEN-END:variables

    //FIXME tirar referencia do modelo Medicamento
    public void popularTabela() {
        initTable();
        for (IMedicamento m : controller.pesquisar(txtNomeComercial.getText(), txtPrincipioAtivo.getText(), txtLaboratorio.getText())) {
            model.insertRow(model.getRowCount(), new Object[]{m.getId(), m.getNomeComercial(), m.getPrincipioAtivo(), m.getLaboratorio(), m.getQtdMedicamento()});
        }
    }

    private void initTable() {

        model = (DefaultTableModel) tblPesquisarMedicamento.getModel();
        model.setDataVector(new Object[][]{}, new Object[]{"Id", "Nome Comercial", "Princípio Ativo", "Laboratório", "Quantidade de medicamentos"});
        tblPesquisarMedicamento.removeColumn(tblPesquisarMedicamento.getColumnModel().getColumn(0));

    }
}
