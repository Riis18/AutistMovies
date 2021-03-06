/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import autistmovies.be.Movie;
import autistmovies.gui.model.MainViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ollie
 */
public class PersonalRatingViewController extends MainViewController implements Initializable {

    ObservableList<String> comboList = FXCollections.observableArrayList(
    "0.0","0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0","5.1","5.2","5.3","5.4","5.5","5.6","5.7","5.8","5.9","6.0","6.1","6.2","6.3","6.4","6.5","6.6","6.7","6.8","6.9","7.0","7.1","7.2","7.3","7.4","7.5","7.6","7.7","7.8","7.9","8.0","8.1","8.2","8.3","8.4","8.5","8.6","8.7","8.8","8.9","9.0","9.1","9.2","9.3","9.4","9.5","9.6","9.7","9.8","9.9","10.0" 
);
    private MainViewModel mvm;
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXComboBox<String> comboP;

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
        comboP.getItems().addAll(comboList);
    }    
    
    /*
    saves the personal rating and sends information
    */
    @FXML
    private void SavePR(ActionEvent event) {
        
        Movie movie = new Movie();
        movie.setName(mvm.getSelectedMovie().get(0).getName());
        movie.setId(mvm.getSelectedMovie().get(0).getId());
        movie.setFileLink(mvm.getSelectedMovie().get(0).getFileLink());
        movie.setLastview(mvm.getSelectedMovie().get(0).getLastview());
        movie.setRating(mvm.getSelectedMovie().get(0).getRating());
        movie.setPersonalrating(Float.parseFloat(comboP.getValue()));
        mvm.editMovie(movie);
        mvm.loadMovies();
        mvm.getSelectedMovie().clear();
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
        
    }

    /*
    cancels the personal rating view
    */
    @FXML
    private void cancelPR(ActionEvent event) {
        mvm.getSelectedMovie().clear();
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}

