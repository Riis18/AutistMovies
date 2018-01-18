/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.bll;

import autistmovies.be.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Captain
 */
public class MovieFilter {
        /*
    * A filter that searches for movies by making a new list
    */
    public ArrayList<Movie> search(List<Movie> movies, String searchQuery) {
        ArrayList<Movie> result = new ArrayList<>();
        
        for (Movie movie : movies) {
            String name = movie.getName().trim().toLowerCase();
            String personalrating = movie.getPersonalrating().trim().toLowerCase();
//            String rating = movie.getRating().trim().toLowerCase();
            
            if(name.contains(searchQuery.toLowerCase().trim())
//                    || rating.contains(searchQuery.toLowerCase().trim())
                    || personalrating.contains(searchQuery.toLowerCase().trim())
                    && !result.contains(movie)) {
                result.add(movie);
            }
            
        }
        return result;
    }
}
