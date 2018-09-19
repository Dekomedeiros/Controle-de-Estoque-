
package almoxarifado;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class JDialogSolicitacoes extends javax.swing.JDialog {
//Classe que gerencia a TELA de Solicitações EFETUADAS.

    public JDialogSolicitacoes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init() {
        setTitle("Solicitações Registradas");
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListSolicitacoesReg = new javax.swing.JList<>();
        jButtonConsultar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonDataEntrega = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jListSolicitacoesReg.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = GerenciadorSolicitacoes.GerenciadorSolicitacoesArray();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListSolicitacoesReg);

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonDataEntrega.setText("Informar Data de Entrega");
        jButtonDataEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDataEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(jButtonRemover)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonDataEntrega))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        JOptionPane.showMessageDialog(null, GerenciadorSolicitacoes.listaSolicitacoes.get(jListSolicitacoesReg.getSelectedIndex()).toString());
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if (jListSolicitacoesReg.getSelectedIndex() > -1) {
            GerenciadorSolicitacoes.removeSolicitacao(jListSolicitacoesReg.getSelectedIndex());
            refazLista();
        }        
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonDataEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDataEntregaActionPerformed
        JFormattedTextField dataEntrega = new JFormattedTextField();    //Informa a data de entrega da Solicitação.
        UtilMascaras.maskOnlyDate(dataEntrega);
        
        JOptionPane.showMessageDialog(null,dataEntrega, "Insira a Data de Entrega.",JOptionPane.PLAIN_MESSAGE);       
        String dataEntregaString = dataEntrega.getText().replace(" ", "");
        
        int index = jListSolicitacoesReg.getSelectedIndex();
        Solicitacao solicitacao = GerenciadorSolicitacoes.listaSolicitacoes.get(index);
        solicitacao.setDataEntrega(dataEntregaString);

        refazLista();
    }//GEN-LAST:event_jButtonDataEntregaActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDialogSolicitacoes dialog = new JDialogSolicitacoes(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonDataEntrega;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JList<String> jListSolicitacoesReg;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void refazLista() { //Refaz lista da tela para atualizar informações.

        jListSolicitacoesReg.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = GerenciadorSolicitacoes.GerenciadorSolicitacoesArray();

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });

        jScrollPane1.setViewportView(jListSolicitacoesReg);

    }
}
