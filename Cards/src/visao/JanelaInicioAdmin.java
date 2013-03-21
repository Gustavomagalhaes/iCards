package visao;

/**
 *
 * @author Uguinho
 */
public class JanelaInicioAdmin extends javax.swing.JFrame {

    /**
     * Creates new form JanelaAdmin
     */
    public JanelaInicioAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LoginUs = new javax.swing.JButton();
        cadastrarUs = new javax.swing.JButton();
        excluirUs = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cadastrarCartao = new javax.swing.JButton();
        excluirCartao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LoginEst = new javax.swing.JButton();
        cadastrarEst = new javax.swing.JButton();
        excluirEst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iCards - iAdmin");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginUs.setText("Login");
        LoginUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginUsActionPerformed(evt);
            }
        });
        jPanel1.add(LoginUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 68, 90, 36));

        cadastrarUs.setText("Cadastrar");
        cadastrarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarUsActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrarUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 166, 90, 36));

        excluirUs.setText("Excluir");
        excluirUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirUsActionPerformed(evt);
            }
        });
        jPanel1.add(excluirUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 276, 90, 36));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 360));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        cadastrarCartao.setText("Cadastrar");
        cadastrarCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCartaoActionPerformed(evt);
            }
        });

        excluirCartao.setText("Excluir");
        excluirCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirCartaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excluirCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cadastrarCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(excluirCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 190, 360));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estabelecimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

        LoginEst.setText("Login");
        LoginEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginEstActionPerformed(evt);
            }
        });

        cadastrarEst.setText("Cadastrar");
        cadastrarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEstActionPerformed(evt);
            }
        });

        excluirEst.setText("Excluir");
        excluirEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirEstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excluirEst, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginEst, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(LoginEst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(cadastrarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(excluirEst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 190, 360));

        setSize(new java.awt.Dimension(728, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarUsActionPerformed
        // Encaminha para a janela de CadastrarUsuario
        JanelaCadastrarUsuario frame = new JanelaCadastrarUsuario();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cadastrarUsActionPerformed

    private void excluirUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirUsActionPerformed
        this.dispose();
        JanelaDeletarUsuario frame = new JanelaDeletarUsuario();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }//GEN-LAST:event_excluirUsActionPerformed

    private void LoginEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginEstActionPerformed
        this.dispose();
        JanelaInicioEst frame = new JanelaInicioEst();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        

    }//GEN-LAST:event_LoginEstActionPerformed

    private void LoginUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginUsActionPerformed
        
        JanelaInicioUsuario frame = new JanelaInicioUsuario();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LoginUsActionPerformed

    private void cadastrarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEstActionPerformed
        // Encaminha para a janela de CadastrarEstabelecimento
        JanelaCadastrarEst frame = new JanelaCadastrarEst();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cadastrarEstActionPerformed

    private void cadastrarCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarCartaoActionPerformed
        // Encaminha para a janela de CadastrarCartao
        JanelaCadastrarCartao frame = new JanelaCadastrarCartao();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cadastrarCartaoActionPerformed

    private void excluirCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirCartaoActionPerformed
        this.dispose();
        JanelaDeletarCartao frame = new JanelaDeletarCartao();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_excluirCartaoActionPerformed

    private void excluirEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirEstActionPerformed
        this.dispose();
        JanelaDeletarEst frame = new JanelaDeletarEst();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_excluirEstActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaInicioAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginEst;
    private javax.swing.JButton LoginUs;
    private javax.swing.JButton cadastrarCartao;
    private javax.swing.JButton cadastrarEst;
    private javax.swing.JButton cadastrarUs;
    private javax.swing.JButton excluirCartao;
    private javax.swing.JButton excluirEst;
    private javax.swing.JButton excluirUs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
