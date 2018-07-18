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
import java.util.ArrayList;
import java.util.List;

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
}
