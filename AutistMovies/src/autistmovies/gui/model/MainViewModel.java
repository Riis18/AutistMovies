/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.model;

import autistmovies.be.Category;
import autistmovies.be.Movie;
import autistmovies.bll.CategoryManager;
import autistmovies.bll.MovieManager;
import com.jfoenix.controls.JFXSlider;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Jesper
 */
public class MainViewModel {
    
    private final CategoryManager cm;
    private final MovieManager mm;
    public ObservableList<Category> categoryList;
    public ObservableList<Category> selectedCategory;
    public ObservableList<Category> categories;
    public ObservableList<Movie> selectedMovie;
    public ObservableList<Movie> movieList;
    private static MainViewModel instance;
    
    public MainViewModel() throws IOException{
        
            this.cm = new CategoryManager();
            this.mm = new MovieManager();
            selectedMovie = FXCollections.observableArrayList();
            movieList = FXCollections.observableArrayList();
            categories = FXCollections.observableArrayList();
            categoryList = FXCollections.observableArrayList();
            selectedCategory = FXCollections.observableArrayList();

    }
    
    public void addCategory(Category category)
    {
        cm.add(category);
        categories.add(category);
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

    public ObservableList<Movie> getSelectedMovie() {
        return selectedMovie;
    }

    public void addMovie(Movie movie) {
        mm.add(movie);
        movieList.add(movie);
    }
    
    public void loadMovies() {
        movieList.clear();
        movieList.addAll(mm.getAllMovies());
    }
    
    public ObservableList<Movie> getMovies() {
        return movieList;
    }
    
    public void addSelectedMovie(Movie movie) {
        selectedMovie.add(movie);
    }
    
    public static MainViewModel getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new MainViewModel();
        }
        return instance;
    }
    
    public MediaPlayer getMediaPlayer() {
        return mm.getMediaPlayer();
    }
    
    public void playMovie(Movie moviePlaying) {
        mm.PlayMovie(moviePlaying);
    }
    
    public void editMovie(Movie movie) {
        mm.editMovie(movie);
    }
    
    public void pauseMovie(Movie moviePlaying) {
        mm.pauseMovie(moviePlaying);
    }
    
    public void setVolume(JFXSlider vSlider) {
        mm.setVolume(vSlider);
    }
    
    public void deleteMovie(Movie selectedMovie) {
        mm.remove(selectedMovie);
    }
}
