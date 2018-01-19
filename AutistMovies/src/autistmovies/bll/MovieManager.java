/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.bll;

import autistmovies.be.Movie;
import autistmovies.dal.MovieDAO;
import com.jfoenix.controls.JFXSlider;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Jesper
 */
public class MovieManager {
    MovieDAO mDAO;
    private MediaPlayer mp;
    private String FileLink;
    
    /*
    * Constructor for MovieManager
    */
    public MovieManager() throws IOException {
        this.mDAO = new MovieDAO();
    }
    
    /*
    * a list that returns all movies
    */
    public List<Movie> getAllMovies() {
        return mDAO.getAllMovies();
    }
    
    
    /*
    * Sends information of movie information
    */
    public void add(Movie movie) {
        mDAO.createMovie(movie);
    }
    
    /*
    * Sends information of which movie should be removed
    */
    public void remove(Movie selectedMovie) {
        mDAO.remove(selectedMovie);
    }
    
    /*
    * Pauses the movie
    */
    public void pauseMovie(Movie movieplaying) {
            mp.pause();
    }

    /*
    * gets the specific file location of a the movie and plays it
    */
    public void PlayMovie(Movie moviePlaying) {
            moviePlaying = moviePlaying;
            File movieFile = new File(moviePlaying.getFileLink());
            if (FileLink == null || !FileLink.equals(movieFile.getAbsolutePath())) {
                FileLink = movieFile.toString();
                Media me = new Media(movieFile.toURI().toString());
                if (mp != null) {
                    mp.dispose();
                }
                mp = new MediaPlayer(me);
            }
            mp.play();
            
        }

    /*
    * sets the volume of the movie playing
    */
    public void setVolume(JFXSlider vSlider) {
            vSlider.setValue(mp.getVolume() * 100);
            vSlider.valueProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                mp.setVolume(vSlider.getValue() / 100);
              }
            });
        }

    /*
    * returns the Media Player
    */
    public MediaPlayer getMediaPlayer() {
        return mp;
    }
    
    /*
    Edits the selected movie
    */
    public void editMovie(Movie movie) {
        mDAO.edit(movie);
    }

    /*
    returns a list with all movie names
    */
    public List<String> getAllMoviesByName() {
        return mDAO.getAllMoviesByName();
    }
}
