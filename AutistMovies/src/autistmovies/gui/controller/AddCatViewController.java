/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import autistmovies.be.Category;
import autistmovies.gui.model.MainViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Captain
 */
public class AddCatViewController implements Initializable {

    @FXML
    private JFXButton saveBtnCT;
    @FXML
    private JFXButton cancelBtnCT;
    @FXML
    private JFXTextField txtCT;
    
    private MainViewModel mvm;

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
    }    

    /*
    Cancel the add category view
    */
    @FXML
    private void cancelAddCat(ActionEvent event) {
        
        mvm.getSelectedCategory().clear();
        
        Stage stage = (Stage) cancelBtnCT.getScene().getWindow();
        stage.close();
    }

    /*
    Saves the category
    */
    @FXML
    private void saveAddCat(ActionEvent event) {
         
            
            Category category = new Category();
            category.setName(txtCT.getText());
            category.setId(-1);
            
            mvm.addCategory(category);
        Stage stage = (Stage) saveBtnCT.getScene().getWindow();
        stage.close();
    }
    
}
