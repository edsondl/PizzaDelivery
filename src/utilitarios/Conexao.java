/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

/**
 *
 * @author Edson Dias
 */
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Conexao {
   private final String Driver = "org.gjt.mm.mysql.Driver";
    private final String url = "jdbc:mysql://localhost:3306/pizza"; // "jdbc:mysql://127.0.0.1:3306/pizza"
    private final String usuario = "root";
    private final String senha = "9mysql$";
    private static Connection Con;
    private static PreparedStatement rs;
    
    public Conexao() {
    try {
            Class.forName(Driver);
            Con = DriverManager.getConnection(url, usuario, senha);
            Con.setAutoCommit(false);
            
    } 
    catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco!!!","Erro com o banco!!!", 0, new ImageIcon("Imagens/cancelar.png"));
        }
    }
    
    public static Connection getConnection() {
        if(Con == null) {
            new Conexao();
        }
        return Con;
    }
    
    public static void desconecta() {
        try {
            if(!Con.isClosed()) {
            Con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
//    public static void main(String args[] ) {
//        Conexao.getConnection();
//}
//}