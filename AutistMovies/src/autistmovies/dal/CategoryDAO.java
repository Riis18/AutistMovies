/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.dal;

import autistmovies.be.Category;
import autistmovies.be.Movie;
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
 * @author Captain
 */
public class CategoryDAO {
    
        
    List<Category> allCategories = new ArrayList();
    private DataBaseConnector dbConnector;
    private DataBaseConnector cm = new DataBaseConnector();
    
            
        public List<Category> getAllCategories() {

        try (Connection con = cm.getConnection()) {

            PreparedStatement pstmt
                    = con.prepareStatement("Select * FROM Category");
                      ResultSet rs = pstmt.executeQuery();
                      
                      
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("CategoryId"));
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
               
        public void remove(Category selectedCategory) {
        try (Connection con = dbConnector.getConnection()) {
            String sql2
                    = "DELETE FFROM CategoryMovie WHERE categoryId=?";
            PreparedStatement pstmt2
                    = con.prepareStatement(sql2);
            pstmt2.setInt(1, selectedCategory.getId());
            pstmt2.execute();
            
            String sql
                    = "DELETE FROM Category WHERE categoryId=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setInt(1, selectedCategory.getId());
            
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
            public void createCategory(Category category) 
    {
        try (Connection con = cm.getConnection()) {
           String sql = "INSERT INTO category"
                   + "(Name)"
                   + "VALUES (?)";
           PreparedStatement pstmt
                   = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           pstmt.setString(1, category.getName());
           
           int affected = pstmt.executeUpdate();
           if (affected<1)
                   throw new SQLException("Can't save category");
                   
                   ResultSet rs = pstmt.getGeneratedKeys();
                   if (rs.next()) {
                       category.setId(rs.getInt(1));
                   }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void addMovieToCategory(Category category, Movie movie) {
        
                try (Connection con = cm.getConnection()) {
           String sql = "INSERT INTO CategoryMovie"
                   + "(MovieId, CategoryId)"
                   + "VALUES (?,?)";
           PreparedStatement pstmt
                   = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           pstmt.setInt(1, movie.getId());
           pstmt.setInt(2, category.getId());
           
           int affected = pstmt.executeUpdate();
           if (affected<1)
                   throw new SQLException("Can't save movie to Category");
                 
        }
        
        catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void getAllCatMovies() {
                  
            try (Connection con = cm.getConnection()) {

            PreparedStatement pstmt
                    = con.prepareStatement("Select * FROM CategoryMovie, Movie, Category " + "where CategoryMovie.MovieId = Movie.MovieId AND CategoryMovie.CategoryId = Category.CategoryId");
                      ResultSet rs = pstmt.executeQuery();
                      
                      
                while (rs.next()) {
                Category c = new Category();
                Movie m = new Movie();
                c.setId(rs.getInt("CategoryId"));
                m.setId(rs.getInt("MovieId"));
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
    
    public void removeCategoryMovie(Movie selectedMovie, Category selectedCategory) {
        try (Connection con = cm.getConnection()) {
            String sql
                    = "DELETE FROM CategoryMovie WHERE MovieId=? AND CategoryId=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setInt(1, selectedMovie.getId());
            pstmt.setInt(2, selectedCategory.getId());
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
