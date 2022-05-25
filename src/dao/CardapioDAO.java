/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.CardapioBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.Conexao;

/**
 *
 * @author Edson Dias
 */
public class CardapioDAO {

    public CardapioDAO() {
    }
    
    public String proximoCardapio() {
        try {
            String SQLSelection = "SELECT * FROM cardapio ORDER BY car_cod DESC LIMIT 1;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return Integer.parseInt(rs.getString("car_cod")) + 1 + ""; //retorna o maior valor próximo cadastrado
            }
            else {
                String SQLResetIncrement = "ALTER TABLE cardapio AUTO_INCREMENT = 1;";
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
    
    public void cadastrarCardapio(CardapioBeans Cardapio) {
        try {
            String SQLInsertion = "INSERT INTO cardapio(car_descricao, car_tipo, car_valor)"
                    + "VALUES(?, ?, ?);";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Cardapio.getCar_Descricao());
            stm.setString(2, Cardapio.getCar_Tipo());
            stm.setDouble(3, Cardapio.getCar_Valor());
            
            stm.execute();
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!","Cadastramento executado!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public void procurarCardapio(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM cardapio WHERE car_descricao like '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("car_cod"),
                rs.getString("car_descricao"),
                rs.getString("car_tipo"),
                rs.getString("car_valor")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public CardapioBeans preencherCampos(int Codigo) {
        
         CardapioBeans Cardapio = new CardapioBeans();
        
        try {
            String SQLSelection = "SELECT * FROM cardapio WHERE car_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Cardapio.setCar_Cod(rs.getInt("car_cod"));
               Cardapio.setCar_Descricao(rs.getString("car_descricao"));
               Cardapio.setCar_Tipo(rs.getString("car_tipo"));
               Cardapio.setCar_Valor(rs.getDouble("car_valor"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            }
        
        return Cardapio;
    }
    
    public void editarCardapio (CardapioBeans Cardapio) {
        try {
            String SQLInsertion = "UPDATE cardapio SET "
                    + "car_descricao = ?, "
                    + "car_tipo = ?, "
                    + "car_valor = ? "
                    + "WHERE car_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Cardapio.getCar_Descricao());
            stm.setString(2, Cardapio.getCar_Tipo());
            stm.setDouble(3, Cardapio.getCar_Valor());
            stm.setInt(4, Cardapio.getCar_Cod());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
  }

