/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.FuncionarioDAO;
import beans.FuncionarioBeans;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Dias
 */
public class FuncionarioController {
    
    FuncionarioDAO FuncionarioD;

    public FuncionarioController() {
        FuncionarioD = new FuncionarioDAO();
    }
    
    public String controleDeCodigo() {
        return FuncionarioD.proximoFuncionario();
    }

     public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        FuncionarioD.procurarFuncionario(Pesquisa, Modelo);
    }
     
     public FuncionarioBeans controlePreenchimento(int Codigo) {
        return FuncionarioD.preencherCampos(Codigo);
    }
            
    public boolean verificaDados(FuncionarioBeans Funcionario, int Cargo, int Permissao) {
        if(Funcionario.getFun_Nome().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false;   
        }
        if(Cargo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Cargo!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false; 
        }
        
        if(Permissao == 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma Permissão!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false; 
        }
        
        FuncionarioD.cadastrarFuncionario(Funcionario);
        
        return true;
    }
    
    public boolean verificaDadosParaEditar(FuncionarioBeans Funcionario, int Cargo, int Permissao) {
        if(Funcionario.getFun_Nome().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false;   
        }
        if(Cargo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Cargo!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false; 
        }
        
        if(Permissao == 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma Permissão!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false; 
        }
        
        FuncionarioD.editarFuncionario(Funcionario);
        
        return true;
    }
 }
