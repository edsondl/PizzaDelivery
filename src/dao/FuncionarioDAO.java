/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.FuncionarioBeans;
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

/**
 *
 * @author Edson Dias
 */
public class FuncionarioDAO {

    public FuncionarioDAO() {
    }
    
    public void cadastrarFuncionario(FuncionarioBeans Funcionario) {
        try {
            String SQLInsertion = "INSERT INTO funcionario(fun_nome, fun_cargo, fun_permissao, fun_dataCad)"
                    + "VALUES(?, ?, ?, ?);";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Funcionario.getFun_Nome());
            stm.setString(2, Funcionario.getFun_Cargo());
            stm.setString(3, Funcionario.getFun_Permissao());
            stm.setString(4, VerificadoresECorretores.converteParaSql(Funcionario.getFun_DataCad()));
            
            stm.execute();
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!","Cadastramento executado!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public String proximoFuncionario() {
        try {
            String SQLSelection = "SELECT * FROM funcionario ORDER BY fun_cod DESC LIMIT 1;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return Integer.parseInt(rs.getString("fun_cod")) + 1 + ""; //retorna o maior valor próximo cadastrado
            }
            else {
                String SQLResetIncrement = "ALTER TABLE funcionario AUTO_INCREMENT = 1;";
                PreparedStatement stmIncrement = Conexao.getConnection().prepareStatement(SQLResetIncrement);
                stmIncrement.execute();
                Conexao.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível cadastrar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    } 
   
   public void procurarFuncionario(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM funcionario WHERE fun_nome like '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("fun_cod"),
                rs.getString("fun_nome"),
                rs.getString("fun_cargo"),
                rs.getString("fun_permissao"),
                rs.getString("fun_dataCad")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public FuncionarioBeans preencherCampos(int Codigo) {
        
         FuncionarioBeans Funcionario = new FuncionarioBeans();
        
        try {
            String SQLSelection = "SELECT * FROM funcionario WHERE fun_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Funcionario.setFun_Codigo(rs.getInt("fun_cod"));
               Funcionario.setFun_Nome(rs.getString("fun_nome"));
               Funcionario.setFun_Cargo(rs.getString("fun_cargo"));
               Funcionario.setFun_Permissao(rs.getString("fun_permissao"));
               Funcionario.setFun_DataCad(VerificadoresECorretores.converteParaJava(rs.getString("fun_dataCad")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
        }
        
        return Funcionario;
    }
    
    public void editarFuncionario (FuncionarioBeans Funcionario) {
        try {
            String SQLInsertion = "UPDATE funcionario SET "
                    + "fun_nome = ?, "
                    + "fun_cargo = ?, "
                    + "fun_permissao = ? "
                    + "WHERE fun_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Funcionario.getFun_Nome());
            stm.setString(2, Funcionario.getFun_Cargo());
            stm.setString(3, Funcionario.getFun_Permissao());
            stm.setInt(4, Funcionario.getFun_Codigo());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
}
