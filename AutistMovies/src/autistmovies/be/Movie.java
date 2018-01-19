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
    public Float rating;
    public Float personalrating;
    public String filelink;
    public String lastview;

    
    /*
    sets the id of the movie
    */
    public void setId(int id) {
        this.id = id;
    }

    /*
    sets the name of the movie
    */
    public void setName(String name) {
       this.name = name;
    }

    /*
    sets the rating of the movie
    */
    public void setRating(Float rating) {
        this.rating = rating;
    }
         
    /*
    sets the filelink for the movie
    */     
    public void setFileLink(String filelink) {
        this.filelink = filelink;
    }

    /*
    sets the lastview for the movie
    */
    public void setLastview(String lastview) {
        this.lastview = lastview;
    }

    /*
    sets the personal rating for the movie
    */
    public void setPersonalrating(Float personalrating) {
        this.personalrating = personalrating;
    }

    /*
    gets the name of the movie
    */
    public String getName() {
        return name;
    }

    /*
    gets the id of the movie
    */
    public int getId() {
        return id;
    }

    /*
    gets the rating of the movie
    */
    public Float getRating() {
        return rating;
    }
    
    /*
    gets the filelink of the movie
    */
    public String getFileLink(){
        return filelink; 
     }
    
    /*
    gets the personal rating of the movie
    */
    public Float getPersonalrating() {
        return personalrating;
    }

    /*
    gets the lastview of the movie
    */
    public String getLastview() {
        return lastview;
    }
   
    
      
}
