/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import autistmovies.be.Category;
import autistmovies.be.Movie;
import autistmovies.bll.MovieFilter;
import autistmovies.gui.model.MainViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jesper
 */
public class MainViewController implements Initializable {
    
    private MainViewModel mvm;
    DatePicker datePicker = new DatePicker(LocalDate.now());
    private final ObservableList<Movie> searchedMovies;
    private final MovieFilter movieFilter;

    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton playPause;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private MediaView media;
    @FXML
    private JFXButton fullscreen;
    @FXML
    private TableView<Category> cList;
    @FXML
    private TableView<Movie> mCatList;
    @FXML
     TableView<Movie> mList;
    @FXML
    private TableColumn<Movie, Float> IMDBClm;
    @FXML
    private TableColumn<Movie, String> NameClm;
    @FXML
     TableColumn<Movie, Float> PRClm;
    @FXML
    private TableColumn<Category, String> CClm;
    @FXML
    private TableColumn<Movie, String> MICClm;
    @FXML
    private TableColumn<Movie, String> LVClm;
    @FXML
    private JFXSlider vSlider;
    @FXML
    private MediaView media2;

    
    public MainViewController() {
        this.searchedMovies = FXCollections.observableArrayList();
        this.movieFilter = new MovieFilter();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        // Gets the instance of MainViewModel
        try {
           mvm = MainViewModel.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
                // Sets the items on movie table
        mList.setItems(mvm.getMovies());
        
                // Sets all cells to their values for Movie table
        IMDBClm.setCellValueFactory(
                new PropertyValueFactory("rating"));
        NameClm.setCellValueFactory(
                new PropertyValueFactory("name"));
        PRClm.setCellValueFactory(
                new PropertyValueFactory("personalrating"));
        LVClm.setCellValueFactory(
                new PropertyValueFactory("lastview"));
        
        // Loads all movies
        mvm.loadMovies();
        
        // Sets items in the Category table
        cList.setItems(mvm.getCategories());
        // Sets the cells to their values for Category table
        CClm.setCellValueFactory(
                new PropertyValueFactory("Name"));
        // Loads all Categories
        mvm.loadCategories();
        
        // Sets the cells to their values movies within categorylist
        MICClm.setCellValueFactory(
                new PropertyValueFactory("Name"));
        // Loads all the movies in every Categorylist
        mvm.loadMoviesInCategory();
        //mCatList.setItems(FXCollections.observableArrayList(cList.getSelectionModel().getSelectedItem().getMovieList()));
        searchMovie();
    }    

    @FXML
    private void play(ActionEvent event) {
        Movie moviePlaying = mList.getSelectionModel().getSelectedItem();
        if (playPause.getText().equals("Play")) {
        mvm.playMovie(moviePlaying);
        playPause.setText("Pause");
        media.setMediaPlayer(mvm.getMediaPlayer());
        media2.setMediaPlayer(mvm.getMediaPlayer());
        LocalDate localDate = datePicker.getValue();
        moviePlaying.setLastview(localDate.toString());
        mvm.editMovie(moviePlaying);
        mvm.loadMovies();
        mvm.setVolume(vSlider);
        } else {
            mvm.pauseMovie(moviePlaying);
            playPause.setText("Play"); 
        }
    }

    @FXML
    private void openPersonalRating(ActionEvent event) throws IOException {
        Movie movie = mList.getSelectionModel().getSelectedItem();
        mvm.addSelectedMovie(movie);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autistmovies/gui/view/PersonalRatingView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void AddCategory(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autistmovies/gui/view/AddCatView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void deleteMovie(ActionEvent event) {
        Movie selectedMovie = mList.getSelectionModel().getSelectedItem();
        
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Delete", ButtonType.YES, ButtonType.NO);
          deleteAlert.setContentText("OBS! Remember to delete movie from category! Are you sure you want to delete " + selectedMovie.getName() + "?");
          deleteAlert.showAndWait();
          if (deleteAlert.getResult() == ButtonType.YES) {
              mvm.deleteMovie(selectedMovie);
              mCatList.setItems(mvm.getMovies());
          } else {
              deleteAlert.close();
                 }
    }

    @FXML
    private void addMovie(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autistmovies/gui/view/AddMovieView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void getMoviesInCat(MouseEvent event) {
        mCatList.setItems(FXCollections.observableArrayList(cList.getSelectionModel().getSelectedItem().getMovieList()));
    }

    @FXML
    private void vSlider(MouseEvent event) {
        mvm.setVolume(vSlider);
    }
    
        /*
    * Searches through songs in song table
    */
    private void searchMovie() {
        txtSearch.textProperty().addListener((ObservableValue<? extends String> listener, String oldQuery, String newQuery)
        -> {
        searchedMovies.setAll(movieFilter.search(mvm.getMovies(), newQuery));
        mList.setItems(searchedMovies);
        });
    }

    @FXML
    private void editMovie(ActionEvent event) throws IOException {
        Movie movie = mList.getSelectionModel().getSelectedItem();
        mvm.addSelectedMovie(movie);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autistmovies/gui/view/AddMovieView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        AddMovieViewController controller = fxmlLoader.getController();
        controller.setModel(mvm);
        Stage stage = new Stage();
        
        stage.setScene(new Scene(root1));
        stage.show();
        
    }

    @FXML
    private void deleteMovieFromCategory(ActionEvent event) {
        Movie selectedMovie
                = mCatList.getSelectionModel().getSelectedItem();
        Category selctedCategory
                = cList.getSelectionModel().getSelectedItem();
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Delete", ButtonType.YES, ButtonType.NO);
        deleteAlert.showAndWait();
        if (deleteAlert.getResult() == ButtonType.YES) {
            mvm.removeCategoryMovie(selectedMovie, selctedCategory);
            mCatList.setItems(FXCollections.observableArrayList(cList.getSelectionModel().getSelectedItem().getMovieList()));
        } else {
            deleteAlert.close();
        }
    }

    @FXML
    private void deleteCategory(ActionEvent event) {
        Category selectedCategory
                = cList.getSelectionModel().getSelectedItem();
        if(!selectedCategory.getMovieList().isEmpty()) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING,"Category contains Movies, please remove them first");
            warningAlert.showAndWait();
        } else {
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Delete", ButtonType.YES, ButtonType.NO);
        deleteAlert.showAndWait();
        if (deleteAlert.getResult() == ButtonType.YES) {
            mvm.remove(selectedCategory);
            mvm.loadCategories();
        } else {
            deleteAlert.close();
        }
        }
    }

    @FXML
    private void fullscreen(ActionEvent event) {
        Stage stage = new Stage();
        
        final DoubleProperty width = media.fitWidthProperty();
        final DoubleProperty height = media.fitHeightProperty();
    
        width.bind(Bindings.selectDouble(media.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(media.sceneProperty(), "height"));
    
        media.setPreserveRatio(true);
    
        StackPane root = new StackPane();
        root.getChildren().add(media);
    
        final Scene scene = new Scene(root, 960, 540);
        scene.setFill(Color.BLACK);
    
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
