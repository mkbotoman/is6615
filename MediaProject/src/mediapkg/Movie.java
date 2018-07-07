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
    
    //overriding
    @Override
    public int getID() {
        return 1000+mID;
    }
    
    //hiding
    public static int getCount() {
        return 100+countMediaObjects;
    }
    
    //overloading
    public void resetName(String newName) {
        mName = newName;
    }
    
    public MovieGenreEnum getGenre() {
        return genre;
    }
    
    @Override
    public String getName() {
        return mName;
    }
    
    @Override
    public int getYear() {
        return yearReleased;
    }
    
    @Override
    public String getInfo() {
        return mID + ", " + mName + ", " + yearReleased + ", " + genre;
    }
}
