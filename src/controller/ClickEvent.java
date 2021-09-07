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
import model.DirectorModel;
import view.AddDirector;
import view.ControlsPanel;

/**
 *
 * @author casierrav
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            int idDirector           = ((DirectorModel)this.controlsPanel.getCbxDirectorsList().getSelectedItem()).getId();
  
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> directors = directorDAO.getAllDirectors();         
            this.controlsPanel.setTblResults(directors);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddArtPiece()) {
            AddDirector addArtPieceView = new AddDirector();
            addArtPieceView.setVisible(true);
    }   }
}