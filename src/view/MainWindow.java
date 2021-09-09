/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import main.Main;


/**
 *csc
 * @author Georgie
 */
public class MainWindow extends JFrame {
   
    FondoPanel fondo = new FondoPanel();
    
    public MainWindow(){
        
       
        initComponents();
        
        
    }
    
    private void initComponents(){
        
        
        
        setTitle("Directores - MVC");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        ResultsPanel resultsPanel = new ResultsPanel();
        resultsPanel.getTblResults();
        setContentPane(resultsPanel);
        add(new ControlsPanel(resultsPanel));
        
        setBounds(58, 11, 540, 517);        
        setSize(720, 720);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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