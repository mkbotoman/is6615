/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

/**
 *
 * @author maureen
 */
public class Loops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int count = 0;
        while(count < 10) {
            System.out.println("The count is: " + (count + 1));
            count++;
        }
        
        System.out.println("\n\n");
        count = 10;
        do {
            System.out.println("The count is " + count);
            count--;
        } while(count > 0);
        
        System.out.println("\n\n");
        
        for(count = 0; count<=10; count = count+2) {
            System.out.println("The count is " + count);
        }
        
        count += 2;
        count -= 2;
        count *= 2;
        count /= 2;
                
    } //end of main
    
} //end of class
