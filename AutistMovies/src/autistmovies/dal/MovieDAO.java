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
import java.sql.Statement;
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
            
                /*
    * Inserts the values of a movie into the database table "Movie"
    */
    public void createMovie(Movie movie)
    {
        try (Connection con = cm.getConnection())
        {
            String sql
                    = "INSERT INTO Movie"
                    + "(name, IMDBRating, filelink) "
                    + "VALUES(?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Movie m = new Movie();
            pstmt.setString(1, m.getName());
            pstmt.setFloat(2, m.getRating());
            pstmt.setString(3, m.getFileLink());
            
            int affected = pstmt.executeUpdate();
            if(affected<1)
                throw new SQLException("Can't save movie");
            
            //Get Database generated id and set movie id
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                movie.setId(rs.getInt(1));
            }
              
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }         
            public void remove(Movie selectedMovie) {
        try (Connection con = dbConnector.getConnection()) {
            String sql
                    = "DELETE FROM Movie WHERE MovieID=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setInt(1, selectedMovie.getId());

            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 }
