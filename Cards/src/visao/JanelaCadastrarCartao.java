/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.GerenciarDB;

/**
 *
 * @author Leandro
 */
public class JanelaCadastrarCartao extends javax.swing.JFrame {

    /**
     * Creates new form JanelaCadastrarUsuario
     */
    public JanelaCadastrarCartao() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NumCartaoLabel = new javax.swing.JLabel();
        CadastrarUsuario = new javax.swing.JButton();
        LimparCadastroUsuario = new javax.swing.JButton();
        CPF = new javax.swing.JLabel();
        todosCampos = new javax.swing.JLabel();
        CPFUsuario = new javax.swing.JFormattedTextField();
        NumeroCartao = new javax.swing.JTextField();
        CancelarCadastroUsuario = new javax.swing.JButton();
        iCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Usuário");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumCartaoLabel.setText("Número do Cartão:");
        getContentPane().add(NumCartaoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 110, -1));

        CadastrarUsuario.setText("Cadastrar");
        CadastrarUsuario.setToolTipText("Cadastrar Usuário");
        CadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(CadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 100, 30));

        LimparCadastroUsuario.setText("Limpar");
        LimparCadastroUsuario.setToolTipText("Limpar Campos");
        LimparCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparCadastroUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(LimparCadastroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 100, 30));

        CPF.setText("CPF:");
        getContentPane().add(CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 30, -1));

        todosCampos.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(todosCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 270, 30));

        CPFUsuario.setToolTipText("CPF do Usuário");
        try{  
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("###.###.###-##");  
            CPFUsuario = new javax.swing.JFormattedTextField(data);  
        }  
        catch (Exception e){  
        }
        getContentPane().add(CPFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 130, 30));

        NumeroCartao.setToolTipText("Nome");
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####-####");
            NumeroCartao = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        getContentPane().add(NumeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 130, 30));

        CancelarCadastroUsuario.setText("Cancelar");
        CancelarCadastroUsuario.setToolTipText("Cancelar Operação");
        CancelarCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarCadastroUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(CancelarCadastroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 100, 30));

        iCadastro.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        iCadastro.setText("Cadastrar Cartão");
        getContentPane().add(iCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-728)/2, (screenSize.height-514)/2, 728, 514);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarCadastroUsuarioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JanelaInicialiCards frame = new JanelaInicialiCards();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_CancelarCadastroUsuarioActionPerformed

    private void LimparCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparCadastroUsuarioActionPerformed
        // TODO add your handling code here:
        NumeroCartao.setText("");
        CPFUsuario.setText("");
    }//GEN-LAST:event_LimparCadastroUsuarioActionPerformed

    private void CadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        String numeroCartao = NumeroCartao.getText().replaceAll("-", "");
        String cpfUsuario = CPFUsuario.getText().replaceAll("[.]", "").replaceAll("-", "");

        if ((numeroCartao.isEmpty()) || (cpfUsuario.isEmpty())) {
            todosCampos.setText("* Todos os campos devem ser preenchidos");
        } else {
            try {
                 GerenciarDB cartao = new GerenciarDB();
                 cartao.addCartao(numeroCartao,cpfUsuario);
                 JanelaInicialiCards frame = new JanelaInicialiCards();
                 frame.setLocationRelativeTo(null);
                 frame.setVisible(true);
                 this.dispose();

            } catch (Exception ex) {
                Logger.getLogger(JanelaCadastrarCartao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_CadastrarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadastrarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaCadastrarCartao().setVisible(true);
            }
              
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPF;
    private javax.swing.JFormattedTextField CPFUsuario;
    private javax.swing.JButton CadastrarUsuario;
    private javax.swing.JButton CancelarCadastroUsuario;
    private javax.swing.JButton LimparCadastroUsuario;
    private javax.swing.JLabel NumCartaoLabel;
    private javax.swing.JTextField NumeroCartao;
    private javax.swing.JLabel iCadastro;
    private javax.swing.JLabel todosCampos;
    // End of variables declaration//GEN-END:variables

}
