/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import beans.ClienteBeans;
import beans.PedidoBeans;
import beans.FuncionarioBeans;
import beans.EntregadorBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PedidoDAO {

    public PedidoDAO() {
    }
    
    public void pesquisaItens(String Pesquisa, List<String> ListaDeItens) {
        try {
            String SQLPesquisa = "SELECT * FROM cardapio WHERE car_descricao LIKE '%"
                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ListaDeItens.add(rs.getString("car_descricao"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void procurarPedidos(DefaultTableModel Modelo) {
        try {
            
            String SQLSelection = "SELECT * FROM pedido WHERE ped_cod like '%';";
              
//            String SQLSelection = "SELECT * FROM pedido WHERE ped_cod like '%"
//                    + Pesquisa + "%';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("ped_cod"),
                rs.getString("ped_data"),
                rs.getString("ped_hora"),
                rs.getString("ped_status"),
                rs.getString("ped_total"),
                rs.getString("ped_cli_cod"),
                rs.getString("ped_fun_cod"),
                rs.getString("ped_ent_cod")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public void procurarPedidosAbertos(DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_status LIKE 'Pedido Aberto';"; //AND ped_status = 'Pedido Aberto';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("ped_cod"),
                rs.getString("ped_data"),
                rs.getString("ped_hora"),
                rs.getString("ped_status"),
                rs.getString("ped_total"),
                rs.getString("ped_cli_cod"),
                rs.getString("ped_fun_cod"),
                rs.getString("ped_ent_cod")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public void procurarPedidosAEntregar(DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_status LIKE 'Pedido a Entregar';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("ped_cod"),
                rs.getString("ped_data"),
                rs.getString("ped_hora"),
                rs.getString("ped_status"),
                rs.getString("ped_total"),
                rs.getString("ped_cli_cod"),
                rs.getString("ped_fun_cod"),
                rs.getString("ped_ent_cod")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public void procurarPedidosEntregues(DefaultTableModel Modelo) {
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_status LIKE 'Pedido Entregue';";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Modelo.addRow(new Object[] {rs.getString("ped_cod"),
                rs.getString("ped_data"),
                rs.getString("ped_hora"),
                rs.getString("ped_status"),
                rs.getString("ped_total"),
                rs.getString("ped_cli_cod"),
                rs.getString("ped_fun_cod"),
                rs.getString("ped_ent_cod")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
           }
    }
    
    public double valorDoItem(String Pesquisa) {
        try {
            String SQLPesquisa = "SELECT * FROM cardapio WHERE car_descricao = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLPesquisa);
            stm.setString(1, Pesquisa);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()) {
                return rs.getDouble("car_valor");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
     public int codigoDoItem(String Pesquisa) {
        try {
            String SQLPesquisa = "SELECT * FROM cardapio WHERE car_descricao = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLPesquisa);
            stm.setString(1, Pesquisa);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()) {
                return rs.getInt("car_cod");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     
      public PedidoBeans preencherCampos(int Codigo) {
        
         PedidoBeans Pedido = new PedidoBeans();
        
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Pedido.setCodigoPedido(rs.getInt("ped_cod"));
               Pedido.setData(VerificadoresECorretores.converteParaJava(rs.getString("ped_data")));
               Pedido.setHora(rs.getString("ped_hora"));
               Pedido.setStatus(rs.getString("ped_status"));
               Pedido.setTotal(Double.parseDouble(rs.getString("ped_total")));
               Pedido.setCodigoCliente(Integer.parseInt(rs.getString("ped_cli_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_fun_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_ent_cod")));
             }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
        }
        
        return Pedido;
    }
      
      public PedidoBeans preencherCamposPedidosAbertos(int Codigo) {
        
         PedidoBeans Pedido = new PedidoBeans();
        
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Pedido.setCodigoPedido(rs.getInt("ped_cod"));
               Pedido.setData(VerificadoresECorretores.converteParaJava(rs.getString("ped_data")));
               Pedido.setHora(rs.getString("ped_hora"));
               Pedido.setStatus(rs.getString("ped_status"));
               Pedido.setTotal(Double.parseDouble(rs.getString("ped_total")));
               Pedido.setCodigoCliente(Integer.parseInt(rs.getString("ped_cli_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_fun_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_ent_cod")));
             }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
        }
        
        return Pedido;
    }
      
      public PedidoBeans preencherCamposPedidosAEntregar(int Codigo) {
        
         PedidoBeans Pedido = new PedidoBeans();
        
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Pedido.setCodigoPedido(rs.getInt("ped_cod"));
               Pedido.setData(VerificadoresECorretores.converteParaJava(rs.getString("ped_data")));
               Pedido.setHora(rs.getString("ped_hora"));
               Pedido.setStatus(rs.getString("ped_status"));
               Pedido.setTotal(Double.parseDouble(rs.getString("ped_total")));
               Pedido.setCodigoCliente(Integer.parseInt(rs.getString("ped_cli_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_fun_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_ent_cod")));
             }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
        }
        
        return Pedido;
    }
      
      public PedidoBeans preencherCamposPedidosEntregues(int Codigo) {
        
         PedidoBeans Pedido = new PedidoBeans();
        
        try {
            String SQLSelection = "SELECT * FROM pedido WHERE ped_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               Pedido.setCodigoPedido(rs.getInt("ped_cod"));
               Pedido.setData(VerificadoresECorretores.converteParaJava(rs.getString("ped_data")));
               Pedido.setHora(rs.getString("ped_hora"));
               Pedido.setStatus(rs.getString("ped_status"));
               Pedido.setTotal(Double.parseDouble(rs.getString("ped_total")));
               Pedido.setCodigoCliente(Integer.parseInt(rs.getString("ped_cli_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_fun_cod")));
               Pedido.setCodigoFuncionario(Integer.parseInt(rs.getString("ped_ent_cod")));
             }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Preencher os campos","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
        }
        
        return Pedido;
    }
     
     public void cadastrarPedido(String CodigoCliente, String CodigoFuncionario, String CodigoEntregador, String Total, int TamanhoTabela, FuncionarioBeans funcionarioB, EntregadorBeans entregadorB, PedidoBeans pedidoB) {
         Date Data = new Date();
         SimpleDateFormat FormatoData = new SimpleDateFormat("yyyy-MM-dd");
         SimpleDateFormat FormatoHora = new SimpleDateFormat("HH:mm:ss");
         try {
            String SQLInsertPedido = "INSERT INTO pedido(ped_cli_cod, "
                    + "ped_fun_cod, ped_ent_cod, ped_data, "
                    + "ped_hora, ped_total, ped_status) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertPedido);
            stm.setString(1, CodigoCliente);
            stm.setString(2, codigoDoFuncionario()); //CodigoFuncionario
            stm.setString(3, codigoDoEntregador()); //"0"
            stm.setString(4, FormatoData.format(Data));
            stm.setString(5, FormatoHora.format(Data));
            stm.setString(6, Total);
            stm.setString(7, "Pedido Aberto");
            
            stm.execute();
                                            //CodigoFuncionario
            cadastrarItens(CodigoCliente, codigoDoFuncionario(), codigoDoEntregador(), codigoDoPedido(), TamanhoTabela, funcionarioB, entregadorB, pedidoB);
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!","Cadastramento executado!!!", 1, new ImageIcon("Imagens/ok.png"));
            
                
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
             try {
                 Conexao.getConnection().rollback();
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
     }
     
     public String codigoDoPedido() {
         String Cod = "0";
         try {
             String SQLSelection = "SELECT ped_cod FROM pedido "
                     + "ORDER BY ped_cod DESC LIMIT 1;";
             PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
             ResultSet rs = stm.executeQuery();
             if(rs.next()) {
                 Cod = rs.getString("ped_cod");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return Cod;
     }
     
     public String codigoDoFuncionario() {
         String Cod = "1";
         try {
             String SQLSelection = "SELECT fun_cod FROM funcionario "
                     + "ORDER BY fun_cod DESC LIMIT 1;";
             PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
             ResultSet rs = stm.executeQuery();
             if(rs.next()) {
                 Cod = rs.getString("fun_cod");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return Cod;
     }
     
      public String codigoDoEntregador() {
         String Cod = "1";
         try {
             String SQLSelection = "SELECT ent_cod FROM entregador "
                     + "ORDER BY ent_cod DESC LIMIT 1;";
             PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLSelection);
             ResultSet rs = stm.executeQuery();
             if(rs.next()) {
                 Cod = rs.getString("ent_cod");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return Cod;
     }
      
    public void editarPedidosAEntregar(PedidoBeans Pedido) {
        try {
            
            editarEntregadorOcupado();
            
            String SQLInsertion = "UPDATE pedido SET "
                    + "ped_status = ? "
                    + "WHERE ped_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, "Pedido a Entregar");
            stm.setInt(2, Pedido.getCodigoPedido());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
           
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
    
     public void editarPedidosEntregues(PedidoBeans Pedido) {
        try {
            String SQLInsertion = "UPDATE pedido SET "
                    + "ped_status = ? "
                    + "WHERE ped_cod = ?;";
                    
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, "Pedido Entregue");
            stm.setInt(2, Pedido.getCodigoPedido());
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }
     
     public void editarEntregadorOcupado() {
        try {
            String SQLInsertion = "UPDATE entregador SET "
                    + "ent_status = ?"
                    + "WHERE ent_cod = ?;";
            PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInsertion);
            stm.setString(1, "Ocupado");
            stm.setInt(2, Integer.parseInt(codigoDoEntregador()));
            
            stm.execute();
            
            Conexao.getConnection().commit();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!","Alteração executada!!!", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "Impossível Editar","Erro de SQL!!!", 0, new ImageIcon("Imagens/cancelar.png"));
            
        }
    }

      public void cadastrarItens(String CodigoCliente, String CodigoFuncionario, String CodigoEntregador, String CodigoPedido, int TamanhoTabela, FuncionarioBeans funcionarioB, EntregadorBeans entregadorB, PedidoBeans pedidoB) {
         for(int i = 0; i < TamanhoTabela; i++) {
             try {
                 String SQLInserItens = "INSERT INTO item (item_ent_cod, "
                         + "item_fun_cod, item_cli_cod, item_ped_cod, "
                         + "item_car_cod, item_quantidade) VALUES(?, ?, ?, ?, ?, ?);";
                 PreparedStatement stm = Conexao.getConnection().prepareStatement(SQLInserItens);
                 stm.setString(1, codigoDoEntregador()); //"0"
                 stm.setString(2, codigoDoFuncionario());//CodigoFuncionario
                 stm.setString(3, CodigoCliente); 
                 stm.setString(4, codigoDoPedido());
                 stm.setInt(5, pedidoB.getCodCardapio(i));
                 stm.setInt(6, pedidoB.getQuantidade(i));
                 
                 stm.execute();
                 
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex);
                 Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }    
     }
}