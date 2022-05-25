/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edson Dias
 */
public class VerificadoresECorretores {
    
    public static String converteParaSql(String Data) {
        return
        Data.substring(6, 10) + "-" + Data.substring(3, 5) + "-" + Data.substring(0, 2);
    }
    
    public static String converteParaJava(String Data) {
        return
        Data.substring(8, 10) + "/" + Data.substring(5, 7) + "/" + Data.substring(0, 4);
    }
    
    public static String retornoDeDataAtual() {
        SimpleDateFormat FormatoData = new SimpleDateFormat("dd/MM/yyyy");
         //Formatar data
        Date DataAtual = new Date();
        
        return FormatoData.format(DataAtual);
    }
}
