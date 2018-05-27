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
        
        int n1 = 10;
        n1 = n1 +1;
        n1++;
        n1--;
        n1 = n1 -1;
        System.out.println(n1);
        
        int n2 = n1++;
        int n3 = n1+1;
        int n4 = ++n3;
        
        System.out.println("\n\n\n");
        System.out.println("The value of n1 = " + n1);
        System.out.println("The value of n2 = " + n2);
        System.out.println("The value of n3 = " + n3);
        System.out.println("The value of n4 = " + n4);
        
        int a = 5;
        int b = 5;
        
        int max;
        
        if(a > b) {
            max = a;
        } 
        else {
            max = b;
        }
        
        System.out.println("\n\nThe max value is " + max);
        
        if (a > b) {
            max = a;
        }
        else if (a < b) {
            max = b;
        }
        else {
            System.out.println("The two numbers are equal");
        }
        
        if (a < 10) {
            System.out.println("The value of a is less than 10");
        }
        
        System.out.println("\n\n");
        a = -20; b = -25;
        if (a > 0) {
            if (b > 0) {
                System.out.println("Both are positive");
            } 
            else {
                System.out.println("A is positive and B is not positive");
            }
        } 
        else {
           if (b > 0) {
               System.out.println("B is positive and A is not positive");
           } 
           else {
               System.out.println("Neither is positive");
           }
        }
        
        a = 10;
        b = 10;
        
        if (a > 0 && b > 0) {
            System.out.println("Both numbers are positive");
        }
        else if (a > 0 || b > 0) {
            System.out.println("At least one of them is positive");
        }
        
        System.out.println("\n\n");
        if (a > 0 || b > 0) {
            System.out.println("At least one of them is positive");
        }
        else if (a > 0 && b > 0) {
            System.out.println("Both numbers are positive");
        }
        
        a = 9; b = 4;
        
        double quotient = (double)a / (double)b;
        System.out.println(quotient);
    }
    
}
