/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import beans.ClienteBeans;
import dao.ClienteDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Dias
 */
public class ClienteController {
    
    ClienteDAO ClienteD;

    public ClienteController() {
        ClienteD = new ClienteDAO();
    }
   
    public boolean verificarDados(ClienteBeans Cliente) {
        if(Cliente.getCli_Nome().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Cliente.getCli_Rua().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Rua não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Cliente.getCli_Bairro().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Bairro não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Cliente.getCli_Telefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "O Campo Telefone não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        ClienteD.cadastrarCliente(Cliente);
        return true;
    }
    
    public String controleDeCodigo() {
        return ClienteD.proximoCliente();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        ClienteD.procurarCliente(Pesquisa, Modelo);
    }
    
    public void controlePesquisa(String Pesquisa, List<String> Lista) {
        ClienteD.procurarCliente(Pesquisa, Lista);
    }
    
    public ClienteBeans controlePreenchimento(int Codigo) {
        return ClienteD.preencherCampos(Codigo);
    }
    
    public boolean verificarDadosParaEditar(ClienteBeans Cliente) {
        if(Cliente.getCli_Nome().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Cliente.getCli_Rua().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Rua não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Cliente.getCli_Bairro().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Bairro não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Cliente.getCli_Telefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "O Campo Telefone não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        ClienteD.editarCliente(Cliente);
        return true;
    }
}





