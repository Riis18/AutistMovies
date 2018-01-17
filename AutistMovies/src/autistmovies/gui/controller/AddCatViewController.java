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

    @FXML
    private void cancelAddCat(ActionEvent event) {
        
        mvm.getSelectedCategory().clear();
        
        Stage stage = (Stage) cancelBtnCT.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveAddCat(ActionEvent event) {
         
//        if (!mvm.getSelectedCategory().isEmpty()) { 
//                
//            Category Category = new Category();
//            Category.setName(txtCT.getText());
//            Category.setId(mvm.getSelectedCategory().get(0).getId());
//            mvm.getSelectedCategory().clear();
//            mvm.loadMoviesInCategory();
//            
//        } else {
            
            Category category = new Category();
            category.setName(txtCT.getText());
            category.setId(-1);
            
            mvm.addCategory(category);
//        }
        Stage stage = (Stage) saveBtnCT.getScene().getWindow();
        stage.close();
    }
    
}
