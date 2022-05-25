/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import beans.UsuarioBeans;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Dias
 */
public class UsuarioController {
    
    UsuarioDAO UsuarioD;

    public UsuarioController() {
        UsuarioD = new UsuarioDAO();
    }
   
    public boolean verificarDados(UsuarioBeans Usuario, int Tipo) {
        if(Usuario.getUsuario().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Usuário não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Usuario.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Senha não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
         if(Tipo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Usuario.getEmail().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo E-mail não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        UsuarioD.cadastrarUsuario(Usuario);
        return true;
    }
    
    public String controleDeCodigo() {
        return UsuarioD.proximoUsuario();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        UsuarioD.procurarUsuario(Pesquisa, Modelo);
    }
    
    public boolean validarLoginUsuario(String Usuario, String Senha) throws SQLException {
        return UsuarioD.ligarLoginUsuario(Usuario, Senha);
        
    }
    
    public boolean validarUsuarioLogado(String Usuario) throws SQLException {
        return UsuarioD.ligarUsuarioLogado(Usuario);
        
    }
    
    public void controlePesquisa(String Pesquisa, List<String> Lista) {
        UsuarioD.procurarUsuario(Pesquisa, (DefaultTableModel) Lista);
    }
    
    public UsuarioBeans controlePreenchimento(int Codigo) {
        return UsuarioD.preencherCampos(Codigo);
    }
    
    public boolean verificarDadosParaEditar(UsuarioBeans Usuario) {
        if(Usuario.getUsuario().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Usuário não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Usuario.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Senha não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        if(Usuario.getEmail().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo E-mail não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
            return false;
        }
        
        UsuarioD.editarUsuario(Usuario);
        return true;
    }
}





