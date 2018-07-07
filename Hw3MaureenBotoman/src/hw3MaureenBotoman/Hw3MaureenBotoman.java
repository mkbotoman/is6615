/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3MaureenBotoman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Hw3MaureenBotoman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        

        ArrayList<String> wordArrayIn;
        String write;

        wordArrayIn = readWordsFromFile("words.txt");
        write = playHangman(wordArrayIn);
        writeStatsToFile(write);
        
    }

    public static ArrayList<String> readWordsFromFile(String fileName) throws IOException {

        BufferedReader inputBuff = null;
        String read = "";
        int count = 0;
        ArrayList<String> wordArray = new ArrayList<String>();
        
        try {
            inputBuff = new BufferedReader(new FileReader(fileName));
        
            while ((read = inputBuff.readLine()) != null) {
                wordArray.add(read);
            }
        } catch (FileNotFoundException fne) {
            System.err.println("file not found");
        } catch (IOException ioe) {
            System.err.println("IO Exception thrown");
        } finally {
            if(inputBuff != null) {
                inputBuff.close();
            }
        }
        
        return wordArray;  
    }

    public static String playHangman(ArrayList<String> words) {

        boolean play = true;
        boolean getNewWord = true;
        int rNum = -1;
        String guessedWord = "";
        int reply = 0;
        char letter =' ';
        String charInput="";
        String wordSelected = "";
        char[] interimGuess = null;
        int charGuessed = 0;
        float stat = 0;
        StringBuilder toWrite = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Let's play hangman. I will give you empty letters in a word. "
                + "You will guess what letter goes in the word one at a time.");

        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
       
        do {
            // the code inside the if will only be executed when a new game is to be started 
            // or startNewGame is true
            // this code selects a new random word and creates a temporary char[] array called interimGuess to hold the letters guessed

            if (getNewWord) {
                rNum = r.nextInt(words.size() - 1);
                
                wordSelected = words.get(rNum);             
                
                getNewWord = false;

                System.out.println("\nStarting New Game. Printing blanks for letters in the word selected for you.");
                
                interimGuess = new char[wordSelected.length()]; 
                
                for (int k = 0; k < interimGuess.length; k++) {
                    interimGuess[k] = '_';                 
                }            
                
                charGuessed = 0;
            }

            
            // finish the for loop below to print out the content of char[] array interimGuess separated by a space on a single line 
            for (int k = 0; k < interimGuess.length; k++) {
                /**** write code to print the character at index k of interimGuess array (which is '_') 
                 * followed by a space.
                 * use print() not println() *****/
                System.out.print(interimGuess[k] + " ");
            }
            System.out.println("");
            
            //you will need to add try-catch here if you want to handle exceptions in user inputs
            /*** start try{} here ***/
            try {
                System.out.println("Enter 1 if you want to guess the word or enter 2 to guess one char or 0 to quit : ");
                           
                /****write code to obtain the user's input using Scanner's nextInt() method 
                 * and store it in an int called reply  ****/
                
                reply = Integer.valueOf(sc.nextLine());   // always add an extra nextLine() after nextInt() of Scanner to remove the enter key left in the stream after a number is read.
            
                // series if if-else if to check whether the user entered 0 1 or 2
                
                if (reply == 0) {  //user wants to quit
                    play = false;
                    /*** set the boolean play to false 
                     * - indicating that the user wants to quit the game; notice that do-while loop terminates when play is false ***/
                
                } else if (reply == 1) {  //user wants to enter word guess
                    
                    System.out.println("Please enter your word guess: ");
                    /** write a line of code to obtain the user's name using nextLine() method of Scanner 
                     * and store it in a String guessedWord   ***/               
                    guessedWord = sc.nextLine();
                          
                    if (guessedWord.equals(wordSelected)) {
                        System.out.println("You guessed right! Nice Work!");
                        /*** print  message telling the user their guessed word is correct ***/                   
                        //calculate stat
                        stat = (float) wordSelected.length() / (float) charGuessed;  
                        /*** append to a String or StringBuilder toWrite the following: 
                         * the players name, \t, stat, \n - one line for each game played by user   ***/

                        toWrite.append(name + "\t" + stat + "\n");

                        //finish the current game by setting boolean startNewGame to true
                        getNewWord = true;    
                    } else { //user guess is incorrect
                    
                        System.out.println("no that word is not right");
                    }

                } else if (reply == 2) { //user wants to guess a letter

                    System.out.println("please enter a letter");
                    //write the next three lines of code
                    /*** write a line to read the user input using Scanner sc's nextLine() method and save it in a String charInput ***/
                    charInput = sc.nextLine();
                    /*** obtain the char at index 0 of String charInput (use charAt()) and save it in a char called letter  
                     (if user enters more than one letter we will use the first one ***/
                    letter = charInput.charAt(0);
                    /*** update the number of letters guessed by user by incrementing int charGuessed by 1  ***/
                    charGuessed++;
                    // next update the for loop to check whether letter guessed by user matches each char of wordSelected saved in char letter
                    boolean found = false;
                    for (int i = 0; i < wordSelected.length(); i++) {
                        
                        if (letter == wordSelected.charAt(i)) {  // yes letter matches
                            interimGuess[i] = letter;
                            found = true;
                            /*** set the char at index i of interimGuess equal to letter ***/
                        }
                        // if letter not found , we dont have to do anything, just leave the char as '_'                          
                    }
                    if (!found) {
                        System.out.println("Sorry your letter was not found");
                    }
                    // optional: you can use a boolean called found to keep track of whether a letter was found or not in each guessing turn, 
                    // and print a message that sorry the letter entered was not found, if it matched no chars in wordSelected
                    //define it above the for loop to be false, and change its value to true only when letter matches
                    //then here, check its value- if still false at the end, print "no that letter was not found"
                }
                else {  //user entered an invalid choice
                    
                    System.out.println("that choice is not valid");
                }   
            }
            catch (InputMismatchException ime) {
                System.err.println("IME - Please enter a valid input");
                sc.nextLine();
            }
            finally {
                System.out.println("Thank you for playing.");
            }
            
        } while (play == true);
        return toWrite.toString(); /*** returns a String that contains game stats, convert StringBuilder toWrite to a String using toString() method ****/
    }

    public static void writeStatsToFile(String playerStats) throws IOException {

        /**
         * **** write code to write the String playerStats to a file
         * gamestats.txt ******
         */
        // make sure to add try-catch-finally, and flush outBuff in try{}
        BufferedWriter outBuff = null;

        try {
            outBuff = new BufferedWriter(new FileWriter("gamestats.txt", true));
            outBuff.write(playerStats);
            outBuff.flush();
        } catch (IOException ioe) {
            System.err.println("file cannot be written");
        } finally {
            if (outBuff != null) {
                outBuff.close();
            }
        }
    }

}
