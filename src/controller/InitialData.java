/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import access.DirectorDAO;
import model.DirectorModel;


/**
 *
 * @author Georgie
 */
public class InitialData {
    private ArrayList<DirectorModel>       directors       = null;

    /**
     * Zero-parameters constructor
     */
    public InitialData(){
        DirectorDAO directorDAO = new DirectorDAO();
        this.directors = directorDAO.getAllDirectors();
       // this.directors.add(0, new DirectorModel(-1,"","", "Todos los directores"));
    }

    /**
     * @return the directors
     */
    public ArrayList<DirectorModel> getDirectors() {
        return directors;
    }

}