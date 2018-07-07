/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediapkg;

/**
 *
 * @author maureen
 */
public class Movie extends Media {
    
    MovieGenreEnum genre;
    
    public Movie (int movieID, int movieYear, String movieName) {
        super (movieID, movieYear, movieName);
    }
    
    public Movie (int movieID, int movieYear, String movieName, MovieGenreEnum gen) {
        super (movieID, movieYear, movieName);
        genre = gen;
    }
}
