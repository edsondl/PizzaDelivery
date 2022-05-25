/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.EntregadorBeans;
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
public class EntregadorDAO {

    public EntregadorDAO() {
    }
    
    public String proximoEntregador() {
        try {
            String SQLSelection = "SELECT * FROM entregador ORDER BY ent_cod DESC LIMIT 1;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return Integer.parseInt(rs.getString("ent_cod")) + 1 + ""; //retorna o maior valor próximo cadastrado
            }
            else {
                String SQLResetIncrement = "ALTER TABLE entregador AUTO_INCREMENT = 1;";
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
    
    public void procurarEntregador(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM entregador WHERE ent_nome like '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("ent_cod"),
                rs.getString("ent_nome")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            }
    }
    
    public EntregadorBeans preencherCampos(int Codigo) {
        
         EntregadorBeans Entregador = new EntregadorBeans();
        
        try {
            String SQLSelection = "SELECT * FROM entregador WHERE ent_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Entregador.setEnt_cod(rs.getInt("ent_cod"));
               Entregador.setEnt_nome(rs.getString("ent_nome"));
               Entregador.setEnt_permissao(rs.getString("ent_permissao"));
               Entregador.setEnt_dataCad(VerificadoresECorretores.converteParaJava(rs.getString("ent_dataCad")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
        
        return Entregador;
    }
    
    public void editarEntregador (EntregadorBeans Entregador) {
        try {
            String SQLInsertion = "UPDATE entregador SET "
                    + "ent_nome = ? "
                    + "WHERE ent_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Entregador.getEnt_nome());
            stm.setInt(2, Entregador.getEnt_cod());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
    
    public void cadastrarEntregador(EntregadorBeans Entregador) {
        try {
            String SQLInsertion = "INSERT INTO entregador (ent_nome, ent_permissao, ent_dataCad, ent_status) VALUES (?, ?, ?, ?);";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, Entregador.getEnt_nome());
            stm.setString(2, "ENT");
            stm.setString(3, VerificadoresECorretores.converteParaSql(Entregador.getEnt_dataCad()));
            stm.setString(4, "Livre");
            
            stm.execute();
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!","Cadastramento executado!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
           Logger.getLogger(EntregadorDAO.class.getName()).log(Level.SEVERE, null, ex);
JOptionPane.showMessageDialog(null, "Impossível Cadastrar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));            

        }
        
    }
}
