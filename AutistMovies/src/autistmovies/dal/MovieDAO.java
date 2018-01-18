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
   
    private DataBaseConnector dbConnector;
    
    private DataBaseConnector cm = new DataBaseConnector();

    public List<Movie> getAllMovies() {

        List<Movie> allMovies = new ArrayList();

        try (Connection con = cm.getConnection()) {

            PreparedStatement pstmt
                  = con.prepareStatement("SELECT * FROM Movie");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("MovieId"));
                m.setName(rs.getString("name"));
                m.setRating(rs.getString("rating"));
                m.setFileLink(rs.getString("filelink"));
                m.setLastview(rs.getString("lastview"));
                m.setPersonalrating(rs.getString("personalrating"));

                allMovies.add(m);
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMovies;

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
                    + "(name, rating, filelink, lastview, personalrating) "
                    + "VALUES(?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, movie.getName());
            pstmt.setString(2, movie.getRating());
            pstmt.setString(3, movie.getFileLink());
            pstmt.setString(4, movie.getLastview());
            pstmt.setString(5, movie.getPersonalrating());
            
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
        try (Connection con = cm.getConnection()) {
            String sql
                    = "DELETE FROM Movie WHERE MovieId=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setInt(1, selectedMovie.getId());
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
        public void edit(Movie movie) {
        try (Connection con = cm.getConnection()) {
            String sql
                    = "UPDATE Movie SET "
                    +"name=?, rating=?, filelink=?, lastview=?, personalrating=? "
                    +"WHERE MovieId=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setString(1, movie.getName());
            pstmt.setString(2, movie.getRating());
            pstmt.setString(3, movie.getFileLink());
            pstmt.setString(4, movie.getLastview());
            pstmt.setString(5, movie.getPersonalrating());
            pstmt.setInt(6, movie.getId());
            
            int affected = pstmt.executeUpdate();
            if (affected<1)
                throw new SQLException("Can't edit movie");
            
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 }
