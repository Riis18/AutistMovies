/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Captain
 */
public class Category {
    
    private int id;
    public String name;
    public final List<Movie> Movielist;
    
    /*
    Constructor for Category class
    */
    public Category() {
        this.Movielist = new ArrayList();
    }
    
    /*
    sets the id for the category
    */
    public void setId(int id) {
        this.id = id;
    }

    /*
    sets the name for the category
    */
    public void setName(String name) {
       this.name = name;
    }

    /*
    gets the id of the category
    */
    public int getId() {
        return id;
    }

    /*
    gets the name of the category
    */
    public String getName() {
        return name;
    }
    
    /*
    gets the list of movies in the category
    */
    public List<Movie> getMovieList(){
        return Movielist;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", Movielist=" + Movielist + '}';
    }
    
}
