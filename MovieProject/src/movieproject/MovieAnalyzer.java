/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author maureen
 */
public class MovieAnalyzer {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        List<Movie> moviesArrayList;
        moviesArrayList = readInData("movies.txt");
        System.out.println("the size of the list is " + moviesArrayList.size());
        
        //printMovies(moviesArrayList);
        
        //listOps(moviesArrayList);
        Movie aMovie = moviesArrayList.get(100);
        Queue<Movie> movieQ = new ArrayDeque<>();
        Deque<Movie> movieS = new ArrayDeque<>();
//        addMoviesToQs(movieQ, movieS, aMovie);
        
        aMovie = moviesArrayList.get(200);
//        addMoviesToQs(movieQ, movieS, aMovie);
        
        aMovie = moviesArrayList.get(300);
//        addMoviesToQs(movieQ, movieS, aMovie);
        
//        System.out.println("the size of the queue: " + movieQ.size());
//        System.out.println("the size of the stack: " + movieS.size());
//        
//        watchMoviesinQS(movieQ, movieS);

        
    }
    
    public static List<Movie> readInData(String fileName) {

        List<Movie> movieasArrayList = new ArrayList<>();
        String readFromFile;
        String[] lineFromFile;
        int movieID;
        String movieName;
        int movieYear;
        boolean gAction;
        boolean gAdventure;
        boolean gAnimation;
        boolean gChildren;
        boolean gComedy;
        boolean gCrime;
        boolean gDocumentary;
        boolean gDrama;
        boolean gFantasy;
        boolean gFilmNoir;
        boolean gHorror;
        boolean gMusical;
        boolean gMystery;
        boolean gRomance;
        boolean gSciFi;
        boolean gThriller;
        boolean gWar;
        boolean gWestern;

        Movie newMovie;
        try {
            BufferedReader inputBuff = new BufferedReader(new FileReader(fileName));

            while ((readFromFile = inputBuff.readLine()) != null) {
                lineFromFile = readFromFile.split("\t");

                movieID = Integer.parseInt(lineFromFile[0].trim());
                //System.out.print(movieID + " ");
                movieName = lineFromFile[1].trim();
                movieYear = Integer.parseInt(lineFromFile[2].trim());
                gAction = (Integer.parseInt(lineFromFile[3].trim()) == 1);
                gAdventure = (Integer.parseInt(lineFromFile[4].trim()) == 1);
                gAnimation = (Integer.parseInt(lineFromFile[5].trim()) == 1);
                gChildren = (Integer.parseInt(lineFromFile[6].trim()) == 1);
                gComedy = (Integer.parseInt(lineFromFile[7].trim()) == 1);
                gCrime = (Integer.parseInt(lineFromFile[8].trim()) == 1);
                gDocumentary = (Integer.parseInt(lineFromFile[9].trim()) == 1);
                gDrama = (Integer.parseInt(lineFromFile[10].trim()) == 1);
                gFantasy = (Integer.parseInt(lineFromFile[11].trim()) == 1);
                gFilmNoir = (Integer.parseInt(lineFromFile[12].trim()) == 1);
                gHorror = (Integer.parseInt(lineFromFile[13].trim()) == 1);
                gMusical = (Integer.parseInt(lineFromFile[14].trim()) == 1);
                gMystery = (Integer.parseInt(lineFromFile[15].trim()) == 1);
                gRomance = (Integer.parseInt(lineFromFile[16].trim()) == 1);
                gSciFi = (Integer.parseInt(lineFromFile[17].trim()) == 1);
                gThriller = (Integer.parseInt(lineFromFile[18].trim()) == 1);
                gWar = (Integer.parseInt(lineFromFile[19].trim()) == 1);
                gWestern = (Integer.parseInt(lineFromFile[20].trim()) == 1);

                newMovie = new Movie(movieID, movieName, movieYear, gAction, gAdventure,
                        gAnimation, gChildren, gComedy, gCrime, gDocumentary, gDrama,
                        gFantasy, gFilmNoir, gHorror, gMusical, gMystery,
                        gRomance, gSciFi, gThriller, gWar, gWestern);

                movieasArrayList.add(newMovie);
            }
            
        } catch (FileNotFoundException fnf) {
            System.err.println("FNF exception");
        } catch (IOException ioe) {
            System.err.println("IO exception");
        }
        return movieasArrayList;
    }
    
    public static void printMovies(List<Movie> moviesAsList) {
        int i = 0;
        Movie m;
        while(i<moviesAsList.size()) {
            m = moviesAsList.get(i);
            System.out.println("Movie ID: " + m.getID() + ", title: " + m.getName() + ", release year: " + m.getYear());
            i++;
        }
    }
    
    public static void listOps(List<Movie> moviesArList) {
        List<Movie> movieLiList = new LinkedList<>(moviesArList);
        
        //obtain a movie
        long start = System.nanoTime();
        moviesArList.get(1000);
        long end = System.nanoTime();
        System.out.println("the time to get an object from arraylist = " + (end-start));
        
        start = System.nanoTime();
        movieLiList.get(1000);
        end = System.nanoTime();
        System.out.println("the time to get an object from linkedlist = " + (end-start));
        
        // insert
        Movie aMovie = new Movie(2000, "NewMovie", 2017);
        start = System.nanoTime();
        moviesArList.add(50, aMovie);
        end = System.nanoTime();
        System.out.println("the time to insert an object from arraylist = " + (end-start));
        
        start = System.nanoTime();
        movieLiList.add(50, aMovie);
        end = System.nanoTime();
        System.out.println("the time to insert an object from linkedlist = " + (end-start));
        
        // delete
        start = System.nanoTime();
        moviesArList.remove(50);
        end = System.nanoTime();
        System.out.println("the time to remove an object from arraylist = " + (end-start));
        
        start = System.nanoTime();
        movieLiList.remove(50);
        end = System.nanoTime();
        System.out.println("the time to remove an object from linkedlist = " + (end-start));
        
    }
    
    public static void addMoviesToQs(Queue<Movie> movieQueue, Deque<Movie>movieStack, Movie movieToWatch) {
        movieQueue.add(movieToWatch);
        movieStack.push(movieToWatch);
    }
    
    public static void watchMoviesinQS(Queue<Movie> movieQueue, Deque<Movie>movieStack) {
        Movie m;
        while(!movieQueue.isEmpty()) {
            m = movieQueue.poll();
            System.out.println("The queue movie watched is: " + m.getName());
        }
        
        while(!movieStack.isEmpty()) {
            m = movieStack.pop();
            System.out.println("The stack movie watched is: " + m.getName());
        }
    }
}
