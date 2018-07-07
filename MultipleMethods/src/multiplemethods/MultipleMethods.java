/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplemethods;

/**
 *
 * @author maureen
 */
public class MultipleMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String someString = "message";
        StringBuilder sb = new StringBuilder();
        sb.append(someString);
        
        StringBuilder sb2 = new StringBuilder(someString);
        
        secondMethod(sb);
        
        System.out.println("sb = " + sb);
        System.out.println("sb2 = " + sb2);
        
        thirdMethod(someString);
    }
    
    public static void secondMethod(StringBuilder sb) {
        sb.append(" for you");
    }
    
    public static int thirdMethod(String aString) {
        aString += " for you"; 
        return aString.length();
    }
}
