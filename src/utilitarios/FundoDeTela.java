/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


/**
 *
 * @author Edson Dias
 */
public class FundoDeTela extends JDesktopPane {
    
    private Image Imagem;
    
    public FundoDeTela(String Imagem) {
        this.Imagem  = new ImageIcon(Imagem).getImage();
      }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Imagem, 0, 0, getWidth(),getHeight(), this);
    }
}