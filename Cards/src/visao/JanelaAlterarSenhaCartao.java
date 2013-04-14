package visao;
import bean.Cartao;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.GerenciarCartao;
import negocio.GerenciarDB;

/**
 *
 * @author Rafaella
 */
public class JanelaAlterarSenhaCartao extends javax.swing.JFrame {
    public String IDcartao;
    //public int tipo;
    /**
     * Creates new form JanelaAlterarSenha
     */
    public JanelaAlterarSenhaCartao() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AlterarSenha = new javax.swing.JLabel();
        SenhaAtualLabel = new javax.swing.JLabel();
        SenhaAtual = new javax.swing.JPasswordField();
        RepitaSenhaLabel = new javax.swing.JLabel();
        RepitaSenha = new javax.swing.JPasswordField();
        ConfirmarAlterarSenha = new javax.swing.JButton();
        NovaSenhaLabel = new javax.swing.JLabel();
        NovaSenha = new javax.swing.JPasswordField();
        todosCampos = new javax.swing.JLabel();
        conferirSenha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Senha");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AlterarSenha.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        AlterarSenha.setText("Alterar Senha");
        getContentPane().add(AlterarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        SenhaAtualLabel.setText("Digite sua senha atual:");
        getContentPane().add(SenhaAtualLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        SenhaAtual.setColumns(4);
        SenhaAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaAtualActionPerformed(evt);
            }
        });
        getContentPane().add(SenhaAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 130, 30));

        RepitaSenhaLabel.setText("Digite sua nova senha:");
        getContentPane().add(RepitaSenhaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        RepitaSenha.setColumns(4);
        RepitaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepitaSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(RepitaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 130, 30));

        ConfirmarAlterarSenha.setText("Confirmar");
        ConfirmarAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarAlterarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(ConfirmarAlterarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 100, 30));

        NovaSenhaLabel.setText("Repita sua nova senha:");
        getContentPane().add(NovaSenhaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        NovaSenha.setColumns(4);
        NovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovaSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(NovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 130, 30));

        todosCampos.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(todosCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 280, 30));

        conferirSenha.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(conferirSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 210, 30));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 300, 30));

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, 30));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 100, 30));

        setSize(new java.awt.Dimension(728, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmarAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarAlterarSenhaActionPerformed
        // TODO add your handling code here:
        String senhaatual = SenhaAtual.getText();
        String novasenha = RepitaSenha.getText();
        String repitasenha = NovaSenha.getText();
        
        System.out.println(senhaatual+" "+novasenha);
        System.out.println(IDcartao);
//        System.out.println(tipo);
        
        boolean confereSenha = (novasenha.equals(repitasenha));
        GerenciarDB cartao = new GerenciarDB();

        boolean CheckedPassword = false;
        try {
            CheckedPassword = cartao.checkSenhaCartaoDB(IDcartao, senhaatual, 0);
        } catch (Exception ex) {
            Logger.getLogger(JanelaAlterarSenhaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (senhaatual.isEmpty()|| ("".equals(senhaatual)) || ("".equals(repitasenha)) || ("".equals(novasenha)) || repitasenha.isEmpty()||novasenha.isEmpty()){
            todosCampos.setText("Você deve preencher todos os campos.");

            
        } else if (confereSenha==false){
            conferirSenha.setText("Senhas inválidas. Digite novamente.");
            
        } else {
            try {
                System.out.println("Teste");  
                Cartao cartao2 = new Cartao(IDcartao);
                GerenciarCartao gerCartao = new GerenciarCartao(cartao2);
                double saldo=gerCartao.verificarSaldo();
                if (CheckedPassword) {
                    cartao.updateSenhaCartaoDB(IDcartao, novasenha, 0);
                    JanelaUsuario frame = new JanelaUsuario();
                    frame.IDcartao = IDcartao;
                    //frame.tipo = tipo;
                    if (saldo<=50) {
                    frame.Saldo.setForeground(new java.awt.Color(255, 0, 0));
                    frame.jLabel1.setText("AVISO: Seu saldo atual é inferior a R$ 50.00. Quel tal fazer uma nova recarga?");
                    frame.jLabel2.setText("Lembrando que sua conta será desconectada ao clicar em 'Recarregar'.");
                    }
                    frame.Saldo.setText("R$ "+saldo+"0");
                    frame.startJanelaUsuario(IDcartao);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    this.dispose();  
                } else {
                    conferirSenha.setText("Senha atual errada. Digite novamente."); 
                }
            } catch (Exception ex) {
                Logger.getLogger(JanelaAlterarSenhaCartao.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
            
    }//GEN-LAST:event_ConfirmarAlterarSenhaActionPerformed

    private void SenhaAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenhaAtualActionPerformed

    private void RepitaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepitaSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RepitaSenhaActionPerformed

    private void NovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovaSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NovaSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Limpar
        SenhaAtual.setText("");
        RepitaSenha.setText("");
        NovaSenha.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JanelaUsuario frame = new JanelaUsuario();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaAlterarSenhaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaAlterarSenhaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaAlterarSenhaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaAlterarSenhaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaAlterarSenhaCartao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlterarSenha;
    private javax.swing.JButton ConfirmarAlterarSenha;
    private javax.swing.JPasswordField NovaSenha;
    private javax.swing.JLabel NovaSenhaLabel;
    private javax.swing.JPasswordField RepitaSenha;
    private javax.swing.JLabel RepitaSenhaLabel;
    private javax.swing.JPasswordField SenhaAtual;
    private javax.swing.JLabel SenhaAtualLabel;
    private javax.swing.JLabel conferirSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel todosCampos;
    // End of variables declaration//GEN-END:variables

}
