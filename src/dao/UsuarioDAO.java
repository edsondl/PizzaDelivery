/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import antlr.collections.List;
import beans.UsuarioBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.Conexao;
import utilitarios.VerificadoresECorretores;
import java.util.ArrayList;

/**
 *
 * @author Edson Dias
 */
public class UsuarioDAO {
    
  public UsuarioDAO() {
    }
    
    public void cadastrarUsuario(UsuarioBeans Usuario) {
        try {
            String SQLInsertion = "INSERT INTO login(log_usuario, log_senha, log_tipo, log_email, log_dataCad) VALUES(?, ?, ?, ?, ?);";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Usuario.getUsuario());
            stm.setString(2, Usuario.getSenha());
            stm.setString(3, Usuario.getTipo());
            stm.setString(4, Usuario.getEmail());
            stm.setString(5, VerificadoresECorretores.converteParaSql(Usuario.getDataCad()));
            
            stm.execute();
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!","Cadastramento executado!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "Impossível cadastrar3","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public String proximoUsuario() {
        try {
            String SQLSelection = "SELECT * FROM login ORDER BY log_cod DESC LIMIT 1;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return Integer.parseInt(rs.getString("log_cod")) + 1 + ""; //retorna o maior valor próximo cadastrado
            }
            else {
                String SQLResetIncrement = "ALTER TABLE login AUTO_INCREMENT = 1;";
                PreparedStatement stmIncrement = Conexao.getConnection().prepareStatement(SQLResetIncrement);
                stmIncrement.execute();
                Conexao.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível encontrar o próximo!!!","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
            return "0";
        }
    } 
   
   public void procurarUsuario(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM login WHERE log_usuario like '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("log_cod"),
                rs.getString("log_usuario"),
                rs.getString("log_senha"),
                rs.getString("log_tipo"),
                rs.getString("log_email"),
                rs.getString("log_dataCad")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           
        }
    }
   
      public boolean ligarLoginUsuario(String Usuario, String Senha) throws SQLException {
        
        String SQLSelection = "SELECT * FROM login WHERE log_usuario = ? AND log_senha = ?;";
        PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
        
        boolean encontrado = false;
        try {
            stm.setString(1, Usuario);
            stm.setString(2, Senha);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()) {
                encontrado = true;
            }
                                   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return encontrado;
    }
      
      public boolean ligarUsuarioLogado(String Usuario) throws SQLException {
        
        String SQLSelection = "SELECT * FROM login WHERE log_usuario = ? AND log_tipo = 'SUPER';";
        PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
        
        boolean encontrado = false;
        try {
            stm.setString(1, Usuario);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.first()) {
                encontrado = true;
            }
                                   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return encontrado;
    }
   
   public UsuarioBeans preencherCampos(int Codigo) {
        
         UsuarioBeans Usuario = new UsuarioBeans();
        
        try {
            String SQLSelection = "SELECT * FROM login WHERE log_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Usuario.setId(rs.getInt("log_cod"));
               Usuario.setUsuario(rs.getString("log_usuario"));
               Usuario.setSenha(rs.getString("log_senha"));
               Usuario.setTipo(rs.getString("log_tipo"));
               Usuario.setEmail(rs.getString("log_email"));
               Usuario.setDataCad(VerificadoresECorretores.converteParaJava(rs.getString("log_dataCad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Usuario;
    }
   
   public UsuarioBeans excluirUsuario(UsuarioBeans Usuario) {
       
       try {
           String SQLInsertion = "DELETE FROM login WHERE log_cod = ?;";
           
           PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setInt(1, Usuario.getId());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!!!","Exclusão executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Impossível Excluir","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
        return Usuario; 
  }
    
    public void editarUsuario (UsuarioBeans Usuario) {
        try {
            String SQLInsertion = "UPDATE login SET "
                    + "log_usuario = ?, "
                    + "log_senha = ?, "
                    + "log_tipo = ?, "
                    + "log_email = ? "
//                    + "log_dataCad = ? "
                    + "WHERE log_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Usuario.getUsuario());
            stm.setString(2, Usuario.getSenha());
            stm.setString(3, Usuario.getTipo());
            stm.setString(4, Usuario.getEmail());
            //stm.setString(5, Usuario.getDataCad());
            stm.setInt(5, Usuario.getId());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
}
