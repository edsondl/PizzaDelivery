/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.ClienteBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
public class ClienteDAO {
    
    public ClienteDAO() {
       
    }
    
    public String proximoCliente() {
        try {
            String SQLSelection = "SELECT * FROM cliente ORDER BY cli_cod DESC LIMIT 1;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return Integer.parseInt(rs.getString("cli_Cod")) + 1 + ""; //retorna o maior valor próximo cadastrado
            }
            else {
                String SQLResetIncrement = "ALTER TABLE cliente AUTO_INCREMENT = 1;";
                PreparedStatement stmIncrement = Conexao.getConnection().prepareStatement(SQLResetIncrement);
                stmIncrement.execute();
                Conexao.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível cadastrar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            return "0";
        }
    }
    
    public void cadastrarCliente(ClienteBeans Cliente) {
        try {
            String SQLInsertion = "INSERT INTO cliente(cli_nome, cli_rua, cli_bairro, cli_telefone, cli_dataCad)"
                    + "VALUES(?, ?, ?, ?, ?);";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Cliente.getCli_Nome());
            stm.setString(2, Cliente.getCli_Rua());
            stm.setString(3, Cliente.getCli_Bairro());
            stm.setString(4, Cliente.getCli_Telefone());
            stm.setString(5, VerificadoresECorretores.converteParaSql(Cliente.getCli_DataCad()));
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!","Cadastramento executado!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível cadastrar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
    
    public void procurarCliente(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM cliente WHERE cli_nome like '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("cli_cod"),
                rs.getString("cli_nome"),
                rs.getString("cli_rua"),
                rs.getString("cli_bairro"),
                rs.getString("cli_telefone"),
                rs.getString("cli_dataCad")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public void procurarCliente(String Pesquisa, List<String> Lista) {
        try {
            String SQLSelection = "SELECT * FROM cliente WHERE cli_nome like '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Lista.add(rs.getString("cli_cod") + " - " +
                rs.getString("cli_nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public ClienteBeans preencherCampos(int Codigo) {
        
         ClienteBeans Cliente = new ClienteBeans();
        
        try {
            String SQLSelection = "SELECT * FROM cliente WHERE cli_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Cliente.setCli_Codigo(rs.getInt("cli_cod"));
               Cliente.setCli_Nome(rs.getString("cli_nome"));
               Cliente.setCli_Rua(rs.getString("cli_rua"));
               Cliente.setCli_Bairro(rs.getString("cli_bairro"));
               Cliente.setCli_Telefone(rs.getString("cli_telefone"));
               Cliente.setCli_DataCad(VerificadoresECorretores.converteParaJava(rs.getString("cli_dataCad")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
        
        return Cliente;
    }
    
    
    public void editarCliente (ClienteBeans Cliente) {
        try {
            String SQLInsertion = "UPDATE cliente SET "
                    + "cli_nome = ?, "
                    + "cli_rua = ?, "
                    + "cli_bairro = ?, "
                    + "cli_telefone = ? "
                    + "WHERE cli_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Cliente.getCli_Nome());
            stm.setString(2, Cliente.getCli_Rua());
            stm.setString(3, Cliente.getCli_Bairro());
            stm.setString(4, Cliente.getCli_Telefone());
            stm.setInt(5, Cliente.getCli_Codigo());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
}
