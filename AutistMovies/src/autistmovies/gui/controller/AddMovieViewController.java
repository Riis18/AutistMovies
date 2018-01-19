/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.gui.controller;

import autistmovies.be.Category;
import autistmovies.be.Movie;
import autistmovies.gui.model.MainViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Captain
 */
public class AddMovieViewController implements Initializable {
  
    ObservableList<String> comboList = FXCollections.observableArrayList(
    "0.0","0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0","5.1","5.2","5.3","5.4","5.5","5.6","5.7","5.8","5.9","6.0","6.1","6.2","6.3","6.4","6.5","6.6","6.7","6.8","6.9","7.0","7.1","7.2","7.3","7.4","7.5","7.6","7.7","7.8","7.9","8.0","8.1","8.2","8.3","8.4","8.5","8.6","8.7","8.8","8.9","9.0","9.1","9.2","9.3","9.4","9.5","9.6","9.7","9.8","9.9","10.0" 
);
    MainViewModel mvm;
    DatePicker datePicker = new DatePicker(LocalDate.now());
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtFileLink;
    @FXML
    private JFXComboBox<String> combo;
    @FXML
    private JFXComboBox<Category> comboCat1;
    @FXML
    private JFXComboBox<Category> comboCat2;
    @FXML
    private JFXComboBox<Category> comboCat3;
    @FXML
    private JFXComboBox<String> comboRat;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboRat.getItems().addAll(comboList);
        combo.getItems().addAll(comboList);
        
        try {
            mvm = MainViewModel.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(AddMovieViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!mvm.getSelectedMovie().isEmpty()) 
        {
        txtName.setText(mvm.getSelectedMovie().get(0).getName());
        txtFileLink.setText(mvm.getSelectedMovie().get(0).getFileLink());
        }
        
        // sets the buttonCell for comboBox 1
        final ListCell<Category> buttonCell1 = new ListCell<Category>() {
        @Override
        protected void updateItem(Category category, boolean empty) {
            super.updateItem(category, empty);
            if (category != null){
            setText(category.getName());
            }else{
                setText(null);
            }
        }
    };
        // sets the buttonCell for comboBox 2
        final ListCell<Category> buttonCell2 = new ListCell<Category>() {
        @Override
        protected void updateItem(Category category, boolean empty) {
            super.updateItem(category, empty);
            if (category != null){
            setText(category.getName());
            }else{
                setText(null);
            }
        }
    };
        // sets the buttonCell for comboBox 3
        final ListCell<Category> buttonCell3 = new ListCell<Category>() {
        @Override
        protected void updateItem(Category category, boolean empty) {
            super.updateItem(category, empty);
            if (category != null){
            setText(category.getName());
            }else{
                setText(null);
            }
        }
    };
        comboCat1.setItems(mvm.getCategories());
        comboCat2.setItems(mvm.getCategories());
        comboCat3.setItems(mvm.getCategories());
        
        //sets the cells for comboBox 1
        comboCat1.setCellFactory(new Callback<ListView<Category>, ListCell<Category>>(){
            @Override
            public ListCell<Category> call(ListView<Category> p) {
                final ListCell<Category> cell = new ListCell<Category>(){
                    @Override
                    protected void updateItem(Category category, boolean empty) {
                        super.updateItem(category, empty);
                        if(category != null){
                            setText(category.getName());;
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });
        
        // sets the cell for comboBox 2
        comboCat2.setCellFactory(new Callback<ListView<Category>, ListCell<Category>>(){
            @Override
            public ListCell<Category> call(ListView<Category> p) {
                final ListCell<Category> cell = new ListCell<Category>(){
                    @Override
                    protected void updateItem(Category category, boolean empty) {
                        super.updateItem(category, empty);
                        if(category != null){
                            setText(category.getName());;
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });
        
        // sets the cells for comboBox 3
        comboCat3.setCellFactory(new Callback<ListView<Category>, ListCell<Category>>(){
            @Override
            public ListCell<Category> call(ListView<Category> p) {
                final ListCell<Category> cell = new ListCell<Category>(){
                    @Override
                    protected void updateItem(Category category, boolean empty) {
                        super.updateItem(category, empty);
                        if(category != null){
                            setText(category.getName());;
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        comboCat1.setButtonCell(buttonCell1);
        comboCat2.setButtonCell(buttonCell2);
        comboCat3.setButtonCell(buttonCell3);
        combo.getSelectionModel().selectFirst();
        comboRat.getSelectionModel().selectFirst();
            
    }
    
    /*
    gets the information from the user and save or edit the movie
    */
    @FXML
    private void saveMovie(ActionEvent event) {
        Alert saveAlert = new Alert(Alert.AlertType.WARNING);
        // if a movie is selected edits the movie.
        if(!mvm.getSelectedMovie().isEmpty()) {
        Movie movie = new Movie();
        movie.setName(txtName.getText());
        movie.setId(mvm.getSelectedMovie().get(0).getId());
        movie.setPersonalrating(Float.parseFloat(comboRat.getValue()));
        movie.setRating(Float.parseFloat(combo.getValue()));
        movie.setFileLink(txtFileLink.getText());
        movie.setLastview(mvm.getSelectedMovie().get(0).getLastview());
        mvm.editMovie(movie);
        mvm.loadMovies();
        mvm.getSelectedMovie().clear();
        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.close();
            
        } 
        // adds a new movie
        else {
        
        LocalDate localDate = datePicker.getValue();
        Movie movie = new Movie();
        movie.setId(-1);
        movie.setName(txtName.getText());
        movie.setFileLink(txtFileLink.getText());
        movie.setPersonalrating(Float.parseFloat(comboRat.getValue()));
        movie.setRating(Float.parseFloat(combo.getValue()));
        movie.setLastview(localDate.toString());
        Category selectedCategory1 = comboCat1.getValue();
        // checks to see if the same name is already in the database
        if(mvm.getAllMoviesByName().contains(txtName.getText())) {
                    saveAlert.setContentText("OBS! Movie with that title already exists ");
                    saveAlert.showAndWait();
                    saveAlert.close();
                
        }else{
        mvm.addMovie(movie);
        selectedCategory1.getMovieList().add(movie);
        mvm.addMovieToCategories(selectedCategory1, movie);
        if(!comboCat2.getButtonCell().isEmpty()) {
            Category selectedCategory2 = comboCat2.getValue();
            selectedCategory2.getMovieList().add(movie);
            mvm.addMovieToCategories(selectedCategory2, movie);
        } if(!comboCat3.getButtonCell().isEmpty()) {
            Category selectedCategory3 = comboCat3.getValue();
            selectedCategory3.getMovieList().add(movie);
            mvm.addMovieToCategories(selectedCategory3, movie);
         }
        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.close();
            } 
        }
     }
    
    /*
    Cancels the add movie view
    */
    @FXML
    private void cancelAddMovieView(ActionEvent event) {
        mvm.getSelectedMovie().clear();
        
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    /*
    looks through the local system for a filelink
    */
    @FXML
    private void chooseFile(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("Videos File", "*.mp4", "*.mpeg4");
            fileChooser.getExtensionFilters().add(extFilter);
            Window stage = null;
            File file = fileChooser.showOpenDialog(stage);
            txtFileLink.setText(file.getPath());
             
        } catch (Exception e) {

        }

    
    }
    
    
    /*
    sets the model for MainViewModel
    */
    public void setModel(MainViewModel model) {
        this.mvm = model;
    }
    
}
