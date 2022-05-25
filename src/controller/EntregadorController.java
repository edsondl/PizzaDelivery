/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import beans.EntregadorBeans;
import dao.EntregadorDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Dias
 */
public class EntregadorController {
    
    EntregadorDAO EntregadorD;

    public EntregadorController() {
        
        EntregadorD = new EntregadorDAO();
    }
    
    public String controleDeCodigo() {
        return EntregadorD.proximoEntregador();
    }
    
     public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo) {
        EntregadorD.procurarEntregador(Pesquisa, Modelo);
    }
     
      public EntregadorBeans controlePreenchimento(int Codigo) {
        return EntregadorD.preencherCampos(Codigo);
    }
    
    public boolean verificaDados(EntregadorBeans Entregador) {
        if(Entregador.getEnt_nome().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false;   
        }
              
        EntregadorD.cadastrarEntregador(Entregador);
        
        return true;
    }
    
    public boolean verificaDadosParaEditar(EntregadorBeans Entregador) {
        if(Entregador.getEnt_nome().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode ser vazio!!!", "Erro de preenchimento", 0, new ImageIcon("Imagens/cancelar.png"));
         return false;   
        }
              
        EntregadorD.editarEntregador(Entregador);
        
        return true;
    }
}
