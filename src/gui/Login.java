/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.UsuarioBeans;
import controller.UsuarioController;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.sql.SQLException;
/**
 *
 * @author linux
 */
public class Login extends javax.swing.JFrame {
    
    UsuarioController UsuarioC;
    UsuarioDAO UsuarioD;
    UsuarioBeans UsuarioB;
 
    /**
     * Creates new form LoginGUI
     */
    public Login() {
        initComponents();
        
        UsuarioB = new UsuarioBeans();
        UsuarioD = new UsuarioDAO();
        UsuarioC = new UsuarioController();
        
       }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLimpar = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonSair = new javax.swing.JButton();
        jButtonEntrar = new javax.swing.JButton();
        jLabelFundoTelaLogotipo = new javax.swing.JLabel();
        jLabelFundoTelaLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButtonLimpar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonLimpar.setForeground(new java.awt.Color(0, 51, 204));
        jButtonLimpar.setText("LImpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar);
        jButtonLimpar.setBounds(400, 170, 80, 30);

        jLabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(340, 110, 50, 20);

        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuário: ");
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(340, 80, 52, 20);

        jTextFieldUsuario.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldUsuario.setForeground(new java.awt.Color(0, 51, 204));
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(400, 80, 140, 30);

        jPasswordFieldSenha.setBackground(new java.awt.Color(204, 204, 255));
        jPasswordFieldSenha.setForeground(new java.awt.Color(0, 51, 204));
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(400, 110, 140, 30);

        jButtonSair.setBackground(new java.awt.Color(204, 204, 255));
        jButtonSair.setForeground(new java.awt.Color(0, 51, 204));
        jButtonSair.setText("Sair");
        jButtonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSairMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(490, 170, 60, 30);

        jButtonEntrar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonEntrar.setForeground(new java.awt.Color(0, 51, 204));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseClicked(evt);
            }
        });
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar);
        jButtonEntrar.setBounds(320, 170, 69, 30);

        jLabelFundoTelaLogotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/loginLogotipo.jpeg"))); // NOI18N
        getContentPane().add(jLabelFundoTelaLogotipo);
        jLabelFundoTelaLogotipo.setBounds(20, 50, 290, 180);

        jLabelFundoTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoTelaLogin.jpeg"))); // NOI18N
        getContentPane().add(jLabelFundoTelaLogin);
        jLabelFundoTelaLogin.setBounds(10, 10, 550, 260);

        setSize(new java.awt.Dimension(571, 284));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
       
       try {
             if (UsuarioC.validarLoginUsuario(jTextFieldUsuario.getText(), jPasswordFieldSenha.getText()))
             {
             
             Principal telaPrincipal = new Principal(jTextFieldUsuario.getText());
             telaPrincipal.setVisible(true);
             dispose(); 
                
        } else {
                 
            JOptionPane.showMessageDialog(null, "Acesso negado!!!");
             
             } 
        } catch (SQLException | HeadlessException e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseClicked
         
    }//GEN-LAST:event_jButtonEntrarMouseClicked

    private void jButtonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButtonSairMouseClicked

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparTudo();
    }//GEN-LAST:event_jButtonLimparActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelFundoTelaLogin;
    private javax.swing.JLabel jLabelFundoTelaLogotipo;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    final void limparTudo() {
    jTextFieldUsuario.setText("");
    jPasswordFieldSenha.setText("");
    }
    
}
