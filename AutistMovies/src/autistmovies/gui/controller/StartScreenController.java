/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jesper
 */
public class StartScreenController implements Initializable {

    @FXML
    private JFXButton delBtn;
    @FXML
    private TableView<?> PrList;
    @FXML
    private TableColumn<?, ?> PrName;
    @FXML
    private TableColumn<?, ?> PrClm;
    @FXML
    private TableView<?> LvList;
    @FXML
    private TableColumn<?, ?> LvName;
    @FXML
    private TableColumn<?, ?> LvClm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteMovie(ActionEvent event) {
    }

    @FXML
    private void getMoviesInCat(MouseEvent event) {
    }
    
}
