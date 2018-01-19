/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.be;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Jesper
 */
public class Movie {
   
    public String name;
    private int id;
    public Float rating;
    public Float personalrating;
    public String filelink;
    public String lastview;

    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
       this.name = name;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
         
          
    public void setFileLink(String filelink) {
        this.filelink = filelink;
    }

    public void setLastview(String lastview) {
        this.lastview = lastview;
    }

    public void setPersonalrating(Float personalrating) {
        this.personalrating = personalrating;
    }

    
    
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Float getRating() {
        return rating;
    }
    
    public String getFileLink(){
        return filelink; 
     }
    
    public Float getPersonalrating() {
        return personalrating;
    }

    public String getLastview() {
        return lastview;
    }
   
    
      
}
