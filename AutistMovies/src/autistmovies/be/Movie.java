/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.be;

/**
 *
 * @author Jesper
 */
public class Movie {
   
    public String name;
    private int id;
    public float rating;
    public float personalrating;
    public String filelink;
    public int lastview;

    
    public void setId(int aInt) {
        this.id = id;
    }

    public void setName(String name) {
       this.name = name;
    }

    public void setRating(String string) {
        this.rating = rating;
    }
         
          
    public void setFileLink(String string) {
        this.filelink = filelink;
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
    
    public String getFileLink(){
        return filelink; 
     }
    
    public float getPersonalrating() {
        return personalrating;
    }

    public int getLastview() {
        return lastview;
    }
   
    
      
}
