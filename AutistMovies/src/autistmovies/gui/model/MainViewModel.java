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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Jesper
 */
public class MainViewModel {
    
    private final CategoryManager cm;
    private final MovieManager mm;
    DatePicker datePicker = new DatePicker(LocalDate.now());
    public ObservableList<Category> categoryList;
    public ObservableList<Category> selectedCategory;
    public ObservableList<Category> categories;
    public ObservableList<Movie> selectedMovie;
    public ObservableList<Movie> movieList;
    public ObservableList<Movie> moviePrList;
    public ObservableList<Movie> mCatList;
    private static MainViewModel instance;
    
    /*
    constructor for the MainViewModel
    */
    public MainViewModel() throws IOException{
        
            this.cm = new CategoryManager();
            this.mm = new MovieManager();
            selectedMovie = FXCollections.observableArrayList();
            movieList = FXCollections.observableArrayList();
            categories = FXCollections.observableArrayList();
            categoryList = FXCollections.observableArrayList();
            selectedCategory = FXCollections.observableArrayList();
            moviePrList = FXCollections.observableArrayList();

    }
    
    /*
    sends information for the category and adds it to a list
    */
    public void addCategory(Category category)
    {
        cm.add(category);
        categories.add(category);
    }
    
    /*
    returns the selected category
    */
     public ObservableList<Category> getSelectedCategory() {
       return selectedCategory;
     }
     
     /*
     adds the selected category to a list
     */
     public void addSelectedCategory(Category category) {
       selectedCategory.add(category);
     }
     
     /*
     returns the list of categories
     */
     public ObservableList<Category> getCategories(){
      return categories;
     }
     
     /*
     loads all categories
     */
     public void loadCategories() {
      categories.clear();
      categories.addAll(cm.getAllCategories());
     }
     
     /*
     sends information of the selected category and removes it from category list
     */
     public void remove(Category selectedCategory) {
     categories.remove(selectedCategory);
     cm.remove(selectedCategory);
     }
    
     /*
     sends information of the selected movie and category
     */
     public void addMovieToCategories(Category category, Movie movie){
     cm.addMovieToCategories(category , movie);
     }
     
     /*
     sends information of movies in what categories
     */
     public void loadMoviesInCategory() {
       cm.loadMoviesInCategory();
     }

     /*
     returns the selected movie
     */
    public ObservableList<Movie> getSelectedMovie() {
        return selectedMovie;
    }

    /*
    sends information of the movie and adds it to a list
    */
    public void addMovie(Movie movie) {
        mm.add(movie);
        movieList.add(movie);
    }
    
    /*
    clear the movie list and adds all movies from database
    */
    public void loadMovies() {
        movieList.clear();
        movieList.addAll(mm.getAllMovies());
    }
    
    /*
    returns the list of movies
    */
    public ObservableList<Movie> getMovies() {
        return movieList;
    }
    
    /*
    adds the selected movie to a list
    */
    public void addSelectedMovie(Movie movie) {
        selectedMovie.add(movie);
    }
    
    /*
    returns the instance of MainViewModel
    */
    public static MainViewModel getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new MainViewModel();
        }
        return instance;
    }
    
    /*
    returns the mediaplayer
    */
    public MediaPlayer getMediaPlayer() {
        return mm.getMediaPlayer();
    }
    
    /*
    sends information of the movie to play
    */
    public void playMovie(Movie moviePlaying) {
        mm.PlayMovie(moviePlaying);
    }
    
    /*
    sends information of the movie to edit
    */
    public void editMovie(Movie movie) {
        mm.editMovie(movie);
    }
    
    /*
    pauses the movie
    */
    public void pauseMovie(Movie moviePlaying) {
        mm.pauseMovie(moviePlaying);
    }
    
    /*
    controls the volume of the movie
    */
    public void setVolume(JFXSlider vSlider) {
        mm.setVolume(vSlider);
    }
    
    /*
    sends information of the movie and removes it from the movie list
    */
    public void deleteMovie(Movie selectedMovie) {
        mm.remove(selectedMovie);
        movieList.remove(selectedMovie);
        
    }
    
    /*
    sends information and removes the selected movie from the category
    */
    public void removeCategoryMovie(Movie selectedMovie, Category selectedCategory) {
        cm.removeCategoryMovie(selectedMovie, selectedCategory);
        categories.remove(selectedCategory.getMovieList().remove(selectedMovie));
    }
    
    /*
    Looks at the last view date and check to see if it has been over two years
    and check to see if personal rating is below 6. if that is true it adds it
    to a list
    */
    public ObservableList<Movie> moviesPrList() {
        for (int i = 0; i < movieList.size(); i++) {
            LocalDateTime dateMinusTwoYears = LocalDateTime.now().minusYears(2);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate lastViewDate = LocalDate.parse(movieList.get(i).getLastview(), formatter);
            LocalDateTime localLastViewDate = LocalDateTime.of(lastViewDate, LocalDateTime.now().toLocalTime());
            boolean afterTwoYears = localLastViewDate.isBefore(dateMinusTwoYears);
            if(afterTwoYears == true && movieList.get(i).getPersonalrating() < 6)
                moviePrList.add(movieList.get(i));
        }
        return moviePrList;
    }
    
    /*
    returns a list with all names of the movies
    */
    public List<String> getAllMoviesByName() {
        return mm.getAllMoviesByName();
    }
    
    
}
