/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import beans.CardapioBeans;
import dao.CardapioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Dias
 */
public class CardapioController {

    CardapioDAO CardapioD;
    
    public CardapioController() {
        CardapioD = new CardapioDAO();
        
    }
    
    public String controleDeCodigo() {
        return CardapioD.proximoCardapio();
    }
    
    public boolean verificaDados(CardapioBeans Cardapio, String Valor) {
        if(Cardapio.getCar_Descricao().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Permissão não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false;   
        }
        if(Valor.equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Valor não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false; 
        }
        
        CardapioD.cadastrarCardapio(Cardapio);
        
        return true;
    }
    
     public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        CardapioD.procurarCardapio(Pesquisa, Modelo);
    }
     
     public CardapioBeans controlePreenchimento(int Codigo) {
        return CardapioD.preencherCampos(Codigo);
    }
     
     public boolean verificaDadosParaEditar(CardapioBeans Cardapio, String Valor) {
        if(Cardapio.getCar_Descricao().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Permissão não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false;   
        }
        if(Valor.equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Valor não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false; 
        }
        
        CardapioD.editarCardapio(Cardapio);
        
        return true;
    }
}
