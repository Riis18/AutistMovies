/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.model;

import autistmovies.be.Category;
import autistmovies.be.Movie;
import autistmovies.bll.CategoryManager;
import javafx.collections.ObservableList;

/**
 *
 * @author Jesper
 */
public class MainViewModel {
    
    private final CategoryManager cm;
    public ObservableList<Category> categoryList;
    public ObservableList<Category> selectedCategory;
    public ObservableList<Category> categories;
    
    public MainViewModel(){
        
            this.cm = new CategoryManager();

    }
    
    public void addCategory(Category category)
    {
        cm.add(category);
        categoryList.add(category);
    }
    
     public ObservableList<Category> getSelectedCategory() {
       return selectedCategory;
     }
     
     public void addSelectedCategory(Category category) {
       selectedCategory.add(category);
     }
     
     public ObservableList<Category> getCategories(){
      return categories;
     }
     
     public void loadCategories() {
      categories.clear();
      categories.addAll(cm.getAllCategories());
     }
     
     public void remove(Category selectedCategory) {
     categoryList.remove(this.selectedCategory);
     cm.remove(selectedCategory);
     }
    
     public void addMovieToCategories(Category category, Movie movie){
     cm.addMovieToCategories(category , movie);
     }
     
     public void loadMoviesInCategory() {
       cm.loadMoviesInCategory();
     }
}
