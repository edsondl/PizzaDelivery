/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import beans.FuncionarioBeans;
import beans.EntregadorBeans;
import beans.PedidoBeans;
import dao.PedidoDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Dias
 */
public class PedidoController {
    
    PedidoDAO PedidoD;

    public PedidoController() {
        PedidoD = new PedidoDAO();
    }
    
    public void controleDeItens(String Pesquisa, List<String> ListaDeItens) {
        PedidoD.pesquisaItens(Pesquisa, ListaDeItens);
    }
    
    public void editarDadosPedidosAEntregar(PedidoBeans pedido) {
        PedidoD.editarPedidosAEntregar(pedido);
    }
    
    public void editarDadosPedidosEntregues(PedidoBeans pedido) {
        PedidoD.editarPedidosEntregues(pedido);
    }
    
    public double controleDeValor(String Pesquisa) {
        return PedidoD.valorDoItem(Pesquisa);
    }
    
    public int controleDeCodigo(String Pesquisa) {
        return PedidoD.codigoDoItem(Pesquisa);
    }
    
    public void controlePesquisa(DefaultTableModel Modelo) {
        PedidoD.procurarPedidos(Modelo);
    }
    
    public void controlePesquisaPedidosAbertos(DefaultTableModel Modelo) {
        PedidoD.procurarPedidosAbertos(Modelo);
    }
    
    public void controlePesquisaPedidosAEntregar(DefaultTableModel Modelo) {
        PedidoD.procurarPedidosAEntregar(Modelo);
    }
    
    public void controlePesquisaPedidosEntregues(DefaultTableModel Modelo) {
        PedidoD.procurarPedidosEntregues(Modelo);
    }
    
    public boolean verificaItens(String Valor, String Quantidade, String Codigo, String Item) {
        
        try {
            int x = Integer.parseInt(Quantidade);
            if(x == 0) {
                JOptionPane.showMessageDialog(null, "O Campo Quantidade não pode ser Zero!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
                return false;
            }
        } catch (NumberFormatException Ex) {
            JOptionPane.showMessageDialog(null, "O Campo Quantidade dever ser um número inteiro!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Quantidade.equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Quanatidade não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Valor.equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Valor não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Código não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Item.equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Item Selecionado não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        return true;
    }
    
    public void controleDePedido(String CodigoCliente, String CodigoFuncionario, String CodigoEntregador, String Total, int TamanhoTabela, FuncionarioBeans funcionarioB, EntregadorBeans entregaddorB, PedidoBeans pedidoB) {
        PedidoD.cadastrarPedido(CodigoCliente, CodigoFuncionario, CodigoEntregador, Total, TamanhoTabela, funcionarioB, entregaddorB, pedidoB);
    }
    
    public PedidoBeans controlePreenchimento(int Codigo) {
        return PedidoD.preencherCampos(Codigo);
    }
    
    public PedidoBeans controlePreenchimentoPedidosAbertos(int Codigo) {
        return PedidoD.preencherCamposPedidosAbertos(Codigo);
    }
    
    public PedidoBeans controlePreenchimentoPedidosAEntregar(int Codigo) {
        return PedidoD.preencherCamposPedidosAEntregar(Codigo);
    }
    
    public PedidoBeans controlePreenchimentoPedidosEntregues(int Codigo) {
        return PedidoD.preencherCamposPedidosEntregues(Codigo);
    }
    
}
