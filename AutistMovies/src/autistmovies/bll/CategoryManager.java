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

    /*
    constructor for the CategoryManager
    */
    public CategoryManager() {
        this.cDAO = new CategoryDAO();
    }
    
    /*
    sends information of the category
    */
    public void add(Category Category)
    {
        cDAO.createCategory(Category);
    }

    /*
    returns all categories
    */
    public List<Category> getAllCategories() {
      return cDAO.getAllCategories();
    }
    
    /*
    removes the selected category
    */
    public void remove(Category selectedCategory){
        cDAO.remove(selectedCategory);
    }
    
    /*
    adds a movie to a category
    */
    public void addMovieToCategories(Category category , Movie movie){
       cDAO.addMovieToCategory(category, movie);
    }
    
    /*
    gets all movies in the categories
    */
    public void loadMoviesInCategory(){
      cDAO.getAllCatMovies();
    }
    
    /*
    removes a movie from the a category
    */
    public void removeCategoryMovie(Movie selectedMovie, Category selectedCategory) {
        cDAO.removeCategoryMovie(selectedMovie, selectedCategory);
    }
    
}
