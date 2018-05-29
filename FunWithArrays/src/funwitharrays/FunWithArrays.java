/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwitharrays;

import java.util.Arrays;

/**
 *
 * @author maureen
 */
public class FunWithArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] name = {'m', 'a', 'u', 'r', 'e', 'e', 'n'};
        
        int[] testScores = new int[5];
        
        testScores[0] = 67;
        testScores[1] = 88;
        testScores[2] = 95;
        testScores[3] = 90;
        testScores[4] = 74;
        
        int sum = 0;
        for(int i = 0; i < testScores.length; i++) {
          sum = testScores[i] + sum;  
          System.out.println("Intermediate sum: " + sum);
        }
        double average = (double)sum/testScores.length;
        System.out.println("The average test score is: " + average);
        
        int maxScore = 0;
        int count = 0;
        while(count < testScores.length) {
            if(testScores[count] > maxScore) {
                maxScore = testScores[count];
            }
            count++;
        }
        System.out.println("The max score is: " + maxScore);
        
        int minScore = testScores[0];
        for(int i = 0; i < testScores.length; i++) {
            if(testScores[i] < minScore) {
                minScore = testScores[i];
            }
        }
        System.out.println("The min score is: " + minScore);
        
        System.out.println("\n\n");
        for (int number : testScores) {
            System.out.print(number + "\t");
        }
        System.out.println("");
        
        char[] artist = {'p', 'r', 'i', 'n', 'c', 'e'};
        char[] artist2 = {'p', 'r', 'i', 'n', 'c', 'e'};
        
        if(artist == artist2) {
            System.out.println("The two arrays are the same using ==");
        }
        
        if(Arrays.equals(artist, artist2)) {
            System.out.println("The two arrays are the same using equals");
        }
        
        int x;
        for (x = 0; x < 5; x++) {
            System.out.println("this is X" + x);
        }
        System.out.println("this is also X" + x);
    }
    
}
