package visao;

import bean.Cartao;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.GerenciarCartao;
import negocio.GerenciarDB;


/**
 *
 * @author Uguinho
 */
public class JanelaInicioUsuario extends javax.swing.JFrame {

    /**
     * Creates new form JanelaInicio
     */
    public JanelaInicioUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iCards = new javax.swing.JLabel();
        NumeroCartao = new javax.swing.JLabel();
        NumCartaoUsuario = new javax.swing.JTextField();
        SenhadeAcesso = new javax.swing.JLabel();
        SenhaAcessoUsuario = new javax.swing.JPasswordField();
        BotaoEntrarUsuario = new javax.swing.JButton();
        BotaoRecarregar = new javax.swing.JButton();
        TipoUsuario = new javax.swing.JComboBox();
        ErroAcessoUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        IrHome = new javax.swing.JMenu();
        IrparaHome = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iCards - Inicial");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iCards.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        iCards.setText("iCards");
        getContentPane().add(iCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        NumeroCartao.setText("Número do cartão:");
        getContentPane().add(NumeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, 30));

        NumCartaoUsuario.setToolTipText("Digite o número do cartão");
        try{  
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####-####");  
            NumCartaoUsuario = new javax.swing.JFormattedTextField(data);  
        }  
        catch (Exception e){  
        }
        getContentPane().add(NumCartaoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 110, 30));

        SenhadeAcesso.setText("Senha de acesso:");
        getContentPane().add(SenhadeAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 120, 30));

        SenhaAcessoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaAcessoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(SenhaAcessoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 110, 30));

        BotaoEntrarUsuario.setText("Entrar");
        BotaoEntrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoEntrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 80, 30));

        BotaoRecarregar.setText("Recarregar");
        BotaoRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRecarregarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoRecarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 130, 35));

        TipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Titular", "Dependente" }));
        getContentPane().add(TipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 110, 30));

        ErroAcessoUsuario.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(ErroAcessoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        IrHome.setText("Home");

        IrparaHome.setText("Ir para Home");
        IrparaHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrparaHomeActionPerformed(evt);
            }
        });
        IrHome.add(IrparaHome);

        jMenuBar1.add(IrHome);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(736, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEntrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarUsuarioActionPerformed
        try {
            String numCartao = NumCartaoUsuario.getText();
            String senha = SenhaAcessoUsuario.getText();
            double saldo;
            int tipo;
            numCartao = numCartao.replaceAll("[-]","");
            
            String tipousuario = TipoUsuario.getSelectedItem().toString(); 
            if ("Titular".equals(tipousuario)){
                tipo = 1;
            }
            else{
                tipo = 2;
            }
            
            GerenciarDB banco = new GerenciarDB();
            Cartao cartao = new Cartao(numCartao);
            GerenciarCartao gerCartao = new GerenciarCartao(cartao);
            saldo=gerCartao.verificarSaldo();
            boolean acesso = banco.checkSenhaCartaoDB(numCartao, senha, tipo);
            
            if (acesso){
                JanelaUsuario frame = new JanelaUsuario();
                frame.IDcartao = numCartao;
                frame.tipo = tipo;
                if (saldo<=50) {
                    frame.Saldo.setForeground(new java.awt.Color(255, 0, 0));
                    frame.jLabel1.setText("AVISO: Seu saldo atual é inferior a R$ 50.00. Quel tal fazer uma nova recarga?");
                    frame.jLabel2.setText("Lembrando que sua conta será desconectada ao clicar em 'Recarregar'.");
                    }
                    frame.Saldo.setText("R$ "+saldo+"0");
                frame.startJanelaUsuario(numCartao);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                this.dispose();
            }
            else{
                ErroAcessoUsuario.setText("Número do Cartão ou senha incorreta.");
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaInicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }//GEN-LAST:event_BotaoEntrarUsuarioActionPerformed

    private void BotaoRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRecarregarActionPerformed
        this.dispose();
        JanelaRecarga frame = new JanelaRecarga();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_BotaoRecarregarActionPerformed

    private void IrparaHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrparaHomeActionPerformed
        this.dispose();
        JanelaInicioAdmin frame = new JanelaInicioAdmin();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_IrparaHomeActionPerformed

    private void SenhaAcessoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaAcessoUsuarioActionPerformed
       Cartao c = new Cartao();
       SenhaAcessoUsuario.setText(c.getSenhaCartao()); 
       String senha = SenhaAcessoUsuario.getText();  
    }//GEN-LAST:event_SenhaAcessoUsuarioActionPerformed

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
            @Override
            public void run() {
                new JanelaInicioUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrarUsuario;
    private javax.swing.JButton BotaoRecarregar;
    private javax.swing.JLabel ErroAcessoUsuario;
    private javax.swing.JMenu IrHome;
    private javax.swing.JMenuItem IrparaHome;
    private javax.swing.JTextField NumCartaoUsuario;
    private javax.swing.JLabel NumeroCartao;
    private javax.swing.JPasswordField SenhaAcessoUsuario;
    private javax.swing.JLabel SenhadeAcesso;
    private javax.swing.JComboBox TipoUsuario;
    private javax.swing.JLabel iCards;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

}
