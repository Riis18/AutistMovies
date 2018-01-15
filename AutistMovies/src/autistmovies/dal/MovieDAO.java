/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.dal;

import autistmovies.be.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesper
 */
public class MovieDAO {
   
        private DataBaseConnector dbConnector;
    
    private DataBaseConnector cm = new DataBaseConnector();

    public List<Movie> getAllMovies(
            String nationality) {

        List<Movie> allMovies = new ArrayList();

        try (Connection con = cm.getConnection()) {

            PreparedStatement pstmt
                    = con.prepareStatement("Select * FROM Movie");
                      ResultSet rs = pstmt.executeQuery();
                      
                      
            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setRating(rs.getString("rating"));
                m.setFileLink(rs.getString("filelink"));
                m.setLastview(rs.getInt("lastview"));
                m.setPersonalrating(rs.getString("personalrating"));

                allMovies.add(m);
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return allMovies;

}
}
