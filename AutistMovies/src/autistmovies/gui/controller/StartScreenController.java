/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import autistmovies.be.Movie;
import autistmovies.gui.model.MainViewModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jesper
 */
public class StartScreenController implements Initializable {
    
    private MainViewModel mvm;

    @FXML
    private JFXButton delBtn;
    @FXML
    private TableView<Movie> PrList;
    @FXML
    private TableColumn<Movie, String> PrName;
    @FXML
    private TableColumn<Movie, Float> PrClm;
    private TableView<Movie> LvList;
    @FXML
    private TableColumn<Movie, String> LvClm;
    @FXML
    private JFXButton cncBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           mvm = MainViewModel.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mvm.loadMovies();
        PrList.setItems(mvm.moviesPrList());
        LvClm.setCellValueFactory(
                new PropertyValueFactory("lastview"));
        PrName.setCellValueFactory(
                new PropertyValueFactory("name"));
        PrClm.setCellValueFactory(
                new PropertyValueFactory("personalrating"));
    }    

    /*
    deletes a movie from the table
    */
    @FXML
    private void deleteMovie(ActionEvent event) {
        Movie selectedMovie = PrList.getSelectionModel().getSelectedItem();
        
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Delete", ButtonType.YES, ButtonType.NO);
          deleteAlert.setContentText("OBS! Remember to delete movie from category! Are you sure you want to delete " + selectedMovie.getName() + "?");
          deleteAlert.showAndWait();
          if (deleteAlert.getResult() == ButtonType.YES) {
              mvm.deleteMovie(selectedMovie);
              mvm.moviesPrList().remove(selectedMovie);
              //PrList.setItems(mvm.moviesPrList());
          } else {
              deleteAlert.close();
                 }
    }

    /*
    cancels the start screen view and opens the main view
    */
    @FXML
    private void cancelStartScreen(ActionEvent event) throws IOException {
        Stage stage = (Stage) cncBtn.getScene().getWindow();
        stage.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autistmovies/gui/view/MainView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }
    
}
