/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.dal;

import autistmovies.be.Movie;
import autistmovies.be.Category;
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
    
    List<Category> allCategories = new ArrayList();
   
    private DataBaseConnector dbConnector;
    
    private DataBaseConnector cm = new DataBaseConnector();

    public List<Movie> getAllMovies(
            String Movie) {

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
        
        public List<Category> getAllCategories(
            String Category) {

        try (Connection con = cm.getConnection()) {

            PreparedStatement pstmt
                    = con.prepareStatement("Select * FROM Category");
                      ResultSet rs = pstmt.executeQuery();
                      
                      
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));


                allCategories.add(c);
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return allCategories;
    
     }
            public void getAllCatMovies() {
                  
            try (Connection con = cm.getConnection()) {

            PreparedStatement pstmt
                    = con.prepareStatement("Select * FROM CatMovie, Movie, Category" + "where CatMovie.MovieId = Movie.id AND CatMovie.CategoryId = Category.id");
                      ResultSet rs = pstmt.executeQuery();
                      
                      
                while (rs.next()) {
                Category c = new Category();
                Movie m = new Movie();
                c.setId(rs.getInt("id"));
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setRating(rs.getString("rating"));
                m.setFileLink(rs.getString("filelink"));
                m.setPersonalrating(rs.getString("personalrating"));

                    for (int i = 0; i < allCategories.size(); i++) { 
                    if(allCategories.get(i).getId() == c.getId() ) 
                    {
                        allCategories.get(i).getMovieList().add(m);
                    } else {
                    }
                }
            }
                allCategories.clear();
        }
            catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
}
}
