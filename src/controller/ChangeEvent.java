/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.DirectorModel;
import access.DirectorDAO;
import view.ControlsPanel;

/**
 *
 * @author Georgie
 */
public class ChangeEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    
    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getCbxDirectorsList()) {
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> directors = null;
            int director     = ((DirectorModel)this.controlsPanel.getCbxDirectorsList().getSelectedItem()).getId();
            if(director == -1) {
                directors = directorDAO.getAllDirectors();
            }
            else {
               
            }
            this.controlsPanel.setCbxDirectorsList(directors);
        }
    }
    
}
