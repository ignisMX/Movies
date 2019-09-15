/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egym.movies;

import org.junit.jupiter.api.Test;
import com.egym.movies.DownloadMovies;
import org.junit.jupiter.api.Assertions;
/**
 *
 * @author ignis
 */
public class DownloadMoviesTest {
    
    @Test
    public void testDownloadMovies(){
        String [] movies = DownloadMovies.getMovieTitles("Spiderman");
        Assertions.assertEquals(movies.length, 13);
        for(String movie: movies){
            //System.out.println(movie);
        }
    }
    
    @Test
    public void testDownloadMoviesUsinPOJO(){
        String [] movies = DownloadMovies.getMoviesTitlesUsingPOJO("Spiderman");
        Assertions.assertEquals(movies.length, 13);
        for(String movie: movies){
            System.out.println(movie);
        }
    }
}
