/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DirectorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DirectorModel;
import view.AddDirector;
import view.ControlsPanel;
import view.DeleteDirector;
import view.EditDirector;

/**
 *
 * @author casierrav
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    private JTable tablita;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
        this.tablita = controlsPanel.getTblResults();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
          //  int idDirector           = ((DirectorModel)this.controlsPanel.getCbxDirectorsList().getSelectedItem()).getId();
           
           // System.out.println(idDirector + " " );
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> directors = directorDAO.getAllDirectors();         
            this.controlsPanel.setTblResults(directors);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddDirector()) {
            AddDirector addDirectorView = new AddDirector();
            addDirectorView.setVisible(true);
        }else if(actionEvent.getSource() == this.controlsPanel.getBtnEditDirector()){
             EditDirector editDirectorView = new EditDirector(tablita);            
                editDirectorView.setVisible(true);
        }else if(actionEvent.getSource() == this.controlsPanel.getBtnDeleteDiector()){
            if(tablita.getSelectedRow() > -1){
              int i = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el director? "+tablita.getValueAt(tablita.getSelectedRow(), 0));
                switch (i) {
                    case 0:
                        DeleteDirector deleteDirector = new DeleteDirector(tablita);
                        JOptionPane.showMessageDialog(null, "Director eliminado correctamente!");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Operación abortada!");
                        break;  
                    default:
                        break;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "¡Seleccione un director!");
            }
                       
             
        }
    
    }
    
}