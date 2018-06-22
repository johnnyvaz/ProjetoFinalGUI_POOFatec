
package br.fatecfranca.view;

import br.fatecfranca.controller.DisciplinaController;
import br.fatecfranca.model.Disciplina;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaDisciplina extends javax.swing.JFrame {
    private DefaultTableModel modeloTabela;
    private ArrayList<Disciplina> disciplinas;
    /** Creates new form ConsultaDisciplina */
    public ConsultaDisciplina() {
        initComponents();
        // recupera modelo da tabela
        modeloTabela = (DefaultTableModel) tabela.getModel();
        btnRemove.setEnabled(false);
        btnAtualiza.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Consulta Disciplina");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Carga Horária", "Professor"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAtualiza.setText("Atualiza");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
                        .addComponent(btnAtualiza)
                        .addGap(43, 43, 43)
                        .addComponent(btnRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnAtualiza)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void atualizaTabela(){
          btnRemove.setEnabled(false);
          btnAtualiza.setEnabled(false);
    DisciplinaController disciplinaController = new
            DisciplinaController();
    disciplinas = (ArrayList) disciplinaController.consulta();
    // limpa a tabela
    modeloTabela.setRowCount(0);
    // alimenta tabela
    if (disciplinas == null) {
        JOptionPane.showMessageDialog(null, 
                "Problema na consulta");
    }
    else if (disciplinas.isEmpty()){
            JOptionPane.showMessageDialog(null, 
                    "Não foram encontrados disciplinas");
        }
        else {
            Object objetos[] = new Object[3];
            for (Disciplina disciplina: disciplinas){ // para cada disciplina
                objetos[0] = disciplina.getCodigo();
                objetos[1] = disciplina.getNome();
                objetos[2] = disciplina.getCargaHoraria();
                objetos[3] = disciplina.getProfessor();
                modeloTabela.addRow(objetos);
            }
        } 
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
   atualizaTabela();
}//GEN-LAST:event_jButton1ActionPerformed

private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
// TODO add your handling code here:
      btnRemove.setEnabled(true);
      btnAtualiza.setEnabled(true);
}//GEN-LAST:event_tabelaMouseClicked

private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
// TODO add your handling code here:
    int resposta = 
   JOptionPane.showConfirmDialog(null, "Confirma exclusão?");
    
    if (resposta == JOptionPane.YES_OPTION){
        // recupera a linha selecionada
        int linha = tabela.getSelectedRow();
        int codigo = 
Integer.parseInt(modeloTabela.getValueAt(linha, 0).toString());
        Disciplina disciplina = new Disciplina();
        disciplina.setCodigo(codigo);
        DisciplinaController disciplinaController = new DisciplinaController();
        if (disciplinaController.remove(disciplina) == 1){
            JOptionPane.showMessageDialog(null, "Removeu");
            atualizaTabela();
        }
        else 
        JOptionPane.showMessageDialog(null, "Não Removeu");
    }
}//GEN-LAST:event_btnRemoveActionPerformed

private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
// TODO add your handling code here:
    AtualizaDisciplina atualizaDisciplina = new AtualizaDisciplina();
    // recupera linha selecionada
    int linha = tabela.getSelectedRow();
    // recupera disciplina selecionado do ArrayList
    Disciplina disciplinaSelecionado = disciplinas.get(linha); 
    // atribui disciplinaSelecionado para objeto atualizaDisciplina
    atualizaDisciplina.setDisciplinaSelecionado(disciplinaSelecionado);
    atualizaDisciplina.alimentaFormulario();
    atualizaDisciplina.setVisible(true);
}//GEN-LAST:event_btnAtualizaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaDisciplina().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
