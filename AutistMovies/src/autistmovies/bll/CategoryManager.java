/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.bll;

import autistmovies.be.Category;
import autistmovies.be.Movie;
import autistmovies.dal.CategoryDAO;
import autistmovies.dal.MovieDAO;
import java.util.List;

/**
 *
 * @author Captain
 */
public class CategoryManager {
    
    CategoryDAO cDAO;
    MovieDAO mDAO;
       
    public void add(Category Category)
    {
        cDAO.createCategory(Category);
    }

    public List<Category> getAllCategories() {
        String Category = null;
      return cDAO.getAllCategories(Category);
    }
    public void remove(Category selectedCategory){
        cDAO.remove(selectedCategory);
    }
    
    public void addMovieToCategories(Category category , Movie movie){
       cDAO.addMovieToCategory(category, movie);
    }
    
    public void loadMoviesInCategory(){
      mDAO.getAllCatMovies();
    }
    
}
