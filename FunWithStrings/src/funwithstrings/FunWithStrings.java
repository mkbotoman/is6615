/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithstrings;

/**
 *
 * @author maureen
 */
public class FunWithStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = new String("this");
        String s2 = "that";
        
        System.out.println("the content of string s1 is " + s1);
        
        s1 = "happy";
        s1 += " coding ";
        s1 += 2017;
        s1 += "!";
        
        System.out.println("the content of s1 is now: " + s1);
        
        int len = s1.length();
        System.out.println("the length of s1 is: " + len);
        
        char[] cArray = s1.toCharArray();
        for(int i = 0; i < cArray.length; i++) {
            System.out.println("the char in the array is: " + cArray[i]);
        }
        
        char ch = s1.charAt(2);
        System.out.println("the char at index 2 is: " + ch);
        
        System.out.println("substring ranging from index 0 to 5 is: " + s1.substring(0, 6));
        
        System.out.println("substring staring at index 6 is: " + s1.substring(6));
        
        int index = s1.indexOf("happy");
        System.out.println("the value of index is: " + index);
        
        index = s1.indexOf(s2);
        System.out.println("the value of index is: " + index);
        
        System.out.println(s1);
        s2 = "happy coding 2017!";
        
        if(s1 == s2) {
            System.out.println("These are equal using ==");
        }
        if(s1.equals(s2)) {
            System.out.println("These are equal using .equals");
        }
        
    }
    
}
