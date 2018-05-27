/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author maureen
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num1 = 10;
        int num2;
        
        num2 = 20;
        num2 = -10;
        
        boolean answer = true;
        double dbl = 100.50;
        double dbl2 = 100;
        
        int anotherNum = 100;
        
        // Arithmetic Operations
        
        int sum = num1 + num2;
        System.out.println("The sum of num1 and num2 is: " +  sum);
        
        int difference = num1 - num2;
        System.out.println("The difference of num1 and num2 is: " + difference);
        
        System.out.println("The product of num1 and num2 = " + (num1 * num2));
        
        System.out.println("The quotient of num1 divided by num2 is = " + (num1 / num2));
        
        System.out.println("The remainder of num1 divided by num2 is " + (num1 % num2));
        
        num1 = 11;
        
        System.out.println("The remainder of num1 divided by num2 is " + (num1 % num2));
        
        
    }
    
}
