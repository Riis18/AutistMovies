/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Captain
 */
public class AddMovieViewController implements Initializable {

    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField txtTitle;
    @FXML
    private JFXTextField txtCategory;
    @FXML
    private JFXTextField txtFilePath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveSong(ActionEvent event) {
    }

    @FXML
    private void cancelAddMovieView(ActionEvent event) {
    }

    @FXML
    private void chooseFile(ActionEvent event) {
    }
        
}
