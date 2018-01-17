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
    
    public Category() {
        this.Movielist = new ArrayList();
    }
                
    public void setId(int Int) {
        this.id = id;
    }

    public void setName(String string) {
       this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
     
    public List<Movie> getMovieList(){
        return Movielist;
    }
}
