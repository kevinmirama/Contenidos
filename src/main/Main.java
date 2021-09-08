/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import access.DirectorDAO;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.DirectorModel;
import view.MainWindow;
/**
 *
 * @author Georgie
 */
public class Main {
     
      FondoPanel fondo = new FondoPanel();
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        DirectorDAO dir = new DirectorDAO();
        /*
        for (int i = 0; i < dir.getAllDirectors().size(); i++) {
            System.out.println("Directores");
              System.out.println("Nombre: "+dir.getAllDirectors().get(i).getNombre());
              System.out.println("Apellido: "+dir.getAllDirectors().get(i).getApellido());
              System.out.println("Nacionalidad: "+dir.getAllDirectors().get(i).getNacionalidad());
              System.out.println("----");
                      
        }
        */
        /*
        System.out.println("DIRECTOR 1:");
        System.out.println(dir.getDirector(101).getNombre());
        System.out.println(dir.getDirector(101).getApellido());
        System.out.println(dir.getDirector(101).getNacionalidad());
        */
         new MainWindow();
        //DirectorModel dm = new DirectorModel(101, "Gerogie", "Wild", "Colombiano");
        //dir.updateDirector(dm);
       //dir.deleteMuseum(101);
       
       
        
       
      
    }
    
    
    class FondoPanel extends JPanel {
    
        private Image imagen;
       
        
        @Override
        public void paint(Graphics g)
        {
        
          imagen = new ImageIcon(getClass().getResource("/imagenes/uno.jpg")).getImage();
           g.drawImage(imagen,0,0, getWidth(),getHeight(),this);
           
            setOpaque(false);
            super.paint(g);
        
        }
    
    
    
    } 
  
    
}
