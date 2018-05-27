/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1maureenbotoman;

/**
 *
 * @author maureen
 */
public class Hw1MaureenBotoman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TASK 1
        int num = 88;
        String desc = (num % 2 == 0) ? new String("even"): new String("odd");
        
        if(num > 100) {
            System.out.println("num=" + num + ". This is an " + desc + " number and more than 100");
        } 
        else if (num < 100) {
            System.out.println("num=" + num + ". This is an " + desc + " number and less than 100");
        } 
        else {
            System.out.println("num=" + num + ". This is an " + desc + " number and equal to 100");
        }
       
        
        //TASK 2
        int startNumber = 10;
        int endNumber = 50;
        
        while(startNumber <= endNumber) {
            if(startNumber % 5 == 0) {
                System.out.println(startNumber);
            }
            
            startNumber++;
        }
        
        //TASK 3
        int steps = 20;
        for(int i = 1; i <= steps; i++){
           for(int m = 1; m <= i; m++) {
               System.out.print("*");
               if(i == m) {
                   System.out.println("");
               }
           }
        }    
    }
    
}
