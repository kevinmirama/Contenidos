/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.DirectorModel;
import model.PeliculaModel;


/**
 *
 * @author Georgie
 */
public class ControlsPanel extends JPanel {
 
    private JLabel                       lblMuseums;
    private JComboBox<DirectorModel>       cbxDirectorsList;
    private JLabel                       lblPresentations;
    //private JComboBox<PresentationModel> cbxPresentationsList;
    private JLabel                       lblName;
    private JTextField                   txtName;
    private JButton                      btnSearch;
    private JButton                      btnAddArtPiece;
    private JTable                       tblResults;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();
        
        // Complete Directors info
        this.setTblResults(initialData.getDirectors());
        
        // Director selection
        this.lblMuseums = new JLabel("Directors");
        add(this.getLblDirectors());
        
        this.cbxDirectorsList = new JComboBox();
        this.cbxDirectorsList.setModel(new DefaultComboBoxModel<>(initialData.getDirectors().toArray(new DirectorModel[initialData.getDirectors().size()])));
        this.cbxDirectorsList.setSelectedIndex(0);
        add(this.getCbxDirectorsList());
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxDirectorsList().addActionListener(changeEvent);
    
        // Name patttern 
        this.lblName = new JLabel(" Nombre del Director");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        
        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);
        
        // Insert  button
        this.btnAddArtPiece = new JButton("Agregar Nuevo Director");
        add(this.getBtnAddArtPiece());
        this.getBtnAddArtPiece().addActionListener(clickEvent);
    }

    /**
     * @return the lblDirectors
     */
    public JLabel getLblDirectors() {
        return lblMuseums;
    }

    /**
     * @return the cbxDirectorsList
     */
    public JComboBox getCbxDirectorsList() {
        return cbxDirectorsList;
    }


    /**
     * @return the lblName
     */
    public JLabel getLblName() {
        return lblName;
    }

    /**
     * @return the txtName
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

       /**
     * @param directors
     */
    public void setCbxDirectorsList(ArrayList<DirectorModel> directors) {
        this.cbxDirectorsList.setModel(new DefaultComboBoxModel<>(directors.toArray(new DirectorModel[directors.size()])));
        this.getCbxDirectorsList().setSelectedIndex(0);
    }
    /**
     * @param Directors
     */
    public void setTblResults(ArrayList<DirectorModel> directors) {
        String[] headers = {"ID", "Nombre", "Apellido", "Nacionalidad"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<directors.size(); i++){
            tableModel.addRow(directors.get(i).toArray() );
        }
    }

    /**
     * @return the btnAddArtPiece
     */
    public JButton getBtnAddArtPiece() {
        return btnAddArtPiece;
    }

    

   
}