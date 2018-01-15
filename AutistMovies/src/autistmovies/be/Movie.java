/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.be;

import java.util.List;

/**
 *
 * @author Jesper
 */
public class Movie {
   
    public String name;
    private int id;
    public float rating;
    public float personalrating;
//    public  filelink;
    public int lastview;

    
    public void setId(int aInt) {
        this.id = id;
    }

    public void setName(String string) {
       this.name = name;
    }

    public void setRating(String string) {
        this.rating = rating;
    }
         
            //needs to be fixed
    public void setFileLink(String string) {
//        this.filelink = filelink;
    }

    public void setLastview(int aInt) {
        this.lastview = lastview;
    }

    public void setPersonalrating(String string) {
        this.personalrating = personalrating;
    }

    
    
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getRating() {
        return rating;
    }
    
     // needs to be fixed
//    public filelink()
//           return filelink; 
           
    
    public float getPersonalrating() {
        return personalrating;
    }

    public int getLastview() {
        return lastview;
    }
    
    
      
}
