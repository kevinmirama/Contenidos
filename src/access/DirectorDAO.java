/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.DirectorModel;
import utils.ConnectionDB;
/**
 *
 * @author Georgie
 */
public class DirectorDAO {
    private Connection conn = null;
        
    /**
     * 
     * @return 
     */
    public ArrayList<DirectorModel> getAllDirectors() {
        ArrayList<DirectorModel> directors = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT dir_id, dir_nombre, dir_apellido, dir_nacionalidad FROM director;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                DirectorModel director = new DirectorModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                directors.add(director);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return directors;
    }

    
    /**
     * 
     * @param id
     * @return 
     */
    public DirectorModel getDirector(int id) {
        DirectorModel director = null;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "SELECT nombre, apellido, nacionalidad FROM director WHERE id_director = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                director = new DirectorModel(id, result.getString(1), result.getString(2), result.getString(3));
                break;
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
            System.out.println("Codigo:" +ex.getErrorCode()+"Error: "+ ex.getMessage());
        }
        return director;
    }

    
    /**
     * 
     * @param director 
     */
    public void insertDirector(DirectorModel director){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO director(dir_id, dir_nombre,dir_apellido,dir_nacionalidad) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, director.getId());
            statement.setString(2, director.getNombre());
            statement.setString(3, director.getApellido());
            statement.setString(4, director.getNacionalidad());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitósamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    /**
     * 
     * @param director
     */
    public void updateDirector(DirectorModel director) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE director SET dir_nombre = ?, dir_apellido = ?, dir_nacionalidad = ? WHERE dir_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, director.getNombre());
            statement.setString(2, director.getApellido());
            statement.setString(3, director.getNacionalidad());
            statement.setInt(4, director.getId());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }

    
    /**
     * 
     * @param id 
     */
    public void deleteMuseum(int id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM director WHERE dir_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "¡ El registro fue borrado exitósamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
