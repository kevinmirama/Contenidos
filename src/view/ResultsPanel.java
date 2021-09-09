/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Georgie
 */
public class ResultsPanel extends JPanel {
    
    
   
    private JTable      tblResults;
    private JScrollPane jspPane;
    
    public ResultsPanel(){
        
        
        initComponents();
        
    }
    
    private void initComponents(){
        this.tblResults = new JTable();
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        this.jspPane = new JScrollPane(this.tblResults);
        setBounds(58, 11, 540, 517);
        add(jspPane, BorderLayout.CENTER);
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    
    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
 
    
}
