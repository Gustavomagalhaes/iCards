package visao;

import bean.Cartao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import negocio.GerarRelatorioPDF;
import negocio.GerenciarCartao;
import negocio.GerenciarDB;

/**
 *
 * @author Uguinho
 */
public class JanelaUsuario extends javax.swing.JFrame {
    public String IDcartao;
    public int tipo;
    /**
     * Creates new form JanelaUsuario
     */
    public JanelaUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iCliente = new javax.swing.JLabel();
        SaldoLabel = new javax.swing.JLabel();
        Saldo = new javax.swing.JLabel();
        AlterarSenha = new javax.swing.JButton();
        ImprimirExtrato = new javax.swing.JButton();
        BloquearCartao = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BotaoRecarregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        AlterarSenhaCartao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iCards - iCliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iCliente.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        iCliente.setText("iCliente");
        getContentPane().add(iCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 11, -1, -1));

        SaldoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SaldoLabel.setText("Saldo atual:");
        getContentPane().add(SaldoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 90, -1));

        Saldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Saldo.setText("$ 00,00");
        getContentPane().add(Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 160, 30));

        AlterarSenha.setText("Alterar senha online");
        AlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(AlterarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 140, 35));

        ImprimirExtrato.setText("Imprimir extrato");
        ImprimirExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirExtratoActionPerformed(evt);
            }
        });
        getContentPane().add(ImprimirExtrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 140, 35));

        BloquearCartao.setText("Bloquear cartão");
        BloquearCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloquearCartaoActionPerformed(evt);
            }
        });
        getContentPane().add(BloquearCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 140, 35));

        Sair.setText("Sair do sistema");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 170, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Estabelecimento", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 540, 170));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 440, 20));

        BotaoRecarregar.setText("Recarregar");
        BotaoRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRecarregarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoRecarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 170, 35));

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 440, 20));

        AlterarSenhaCartao.setText("Alterar senha cartão");
        AlterarSenhaCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarSenhaCartaoActionPerformed(evt);
            }
        });
        getContentPane().add(AlterarSenhaCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 140, 35));

        setSize(new java.awt.Dimension(728, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void enableBloqueioCard() {
        try {
            GerenciarDB banco = new GerenciarDB();
            if (tipo==1) {
                if (banco.checkStatusCartaoBloqueadoDB(IDcartao)==true) {
                BloquearCartao.setText("Desbloquear cartão");
            } else if (banco.checkStatusCartaoBloqueadoDB(IDcartao)==false) {
                BloquearCartao.setText("Bloquear cartão");
            }
            
            }else{
                BloquearCartao.setEnabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startJanelaUsuario(String numCartao){
     try {
            GerenciarDB banco = new GerenciarDB();
            System.out.println(IDcartao+"TESTE");
            String[][] mtx = banco.getExtratoUsuario(IDcartao);
            int i;
            for (i=0;i<mtx[0].length;i++){
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{mtx[0][i], mtx[1][i], mtx[2][i]});
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DEU ERRO PORQUE?");
        }   
    }
    
    private void AlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarSenhaActionPerformed

        JanelaAlterarSenha frame = new JanelaAlterarSenha();
        frame.IDcartao = IDcartao;
        frame.tipo = tipo;
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AlterarSenhaActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        //jTable2.setValueAt(VALOR, LINHA, COLUNA);
        this.dispose();
        JanelaInicioUsuario frame = new JanelaInicioUsuario();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_SairActionPerformed

    private void ImprimirExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirExtratoActionPerformed
        GerarRelatorioPDF file = new GerarRelatorioPDF();
        try {
            file.PDF(IDcartao, 0);
        } catch (Exception ex) {
            Logger.getLogger(JanelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImprimirExtratoActionPerformed

    private void BotaoRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRecarregarActionPerformed
        this.dispose();
        JanelaRecarga frame = new JanelaRecarga();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_BotaoRecarregarActionPerformed

    private void BloquearCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloquearCartaoActionPerformed
        // TODO add your handling code here:
        try {
            Cartao cartao = new Cartao(IDcartao);
            GerenciarCartao gerenciarCartao = new GerenciarCartao(cartao);
            GerenciarDB banco = new GerenciarDB();
            if (tipo==1) {
                if (banco.checkStatusCartaoBloqueadoDB(IDcartao)==true) {
                gerenciarCartao.desbloquearCartao();
                BloquearCartao.setText("Bloquear cartão");
            } else if (banco.checkStatusCartaoBloqueadoDB(IDcartao)==false) {
                gerenciarCartao.bloquearCartao();
                BloquearCartao.setText("Desbloquear cartão");
            }
            
            }else{
                BloquearCartao.setEnabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BloquearCartaoActionPerformed

    private void AlterarSenhaCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarSenhaCartaoActionPerformed
        // TODO add your handling code here:
        JanelaAlterarSenhaCartao frame = new JanelaAlterarSenhaCartao();
        frame.IDcartao = IDcartao;
        //frame.tipo = tipo;
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_AlterarSenhaCartaoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarSenha;
    private javax.swing.JButton AlterarSenhaCartao;
    private javax.swing.JButton BloquearCartao;
    private javax.swing.JButton BotaoRecarregar;
    private javax.swing.JButton ImprimirExtrato;
    private javax.swing.JButton Sair;
    protected javax.swing.JLabel Saldo;
    private javax.swing.JLabel SaldoLabel;
    private javax.swing.JLabel iCliente;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
