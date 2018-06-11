/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2maureenbotoman;

/**
 *
 * @author maureen
 */
public class Hw2MaureenBotoman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TASK 1
        int key = 13;
        String unencryptedMessage = "may the FORCE777&%$ Be With You";
        char[] encryptedMessage = new char[unencryptedMessage.length()];
        char[] decryptedMessage = new char[unencryptedMessage.length()];
        
        // I chose to interpret empty to include whitespace only messages too.
        if(unencryptedMessage == null && unencryptedMessage.isEmpty() && unencryptedMessage.trim().isEmpty()) {
            System.out.println("Original message: " + unencryptedMessage + "\n" +
                               "Sorry your message is not valid");
        }
        else {
            char[] oMessageArray = unencryptedMessage.toCharArray();
            
            for(int i = 0; i < unencryptedMessage.length(); i++) {
                if(Character.isAlphabetic(oMessageArray[i])) {
                    char charForEncryption = oMessageArray[i];
                    int lowerCaseWillLoopAt = 123 - key;
                    int upperCaseWillLoopAt = 91 - key;
                    
                    if(charForEncryption > lowerCaseWillLoopAt) {
                        int charForLooping = (charForEncryption - lowerCaseWillLoopAt) + 97;
                        charForEncryption = (char)charForLooping;
                    }  else if (charForEncryption > upperCaseWillLoopAt && charForEncryption < 91) {
                        int charForLooping = (charForEncryption - upperCaseWillLoopAt) + 65;
                        charForEncryption = (char)charForLooping;
                    } else {
                        charForEncryption += key;
                    }
                    
                    encryptedMessage[i] = charForEncryption;
                }
                else {
                    encryptedMessage[i] = oMessageArray[i];
                }
            }
            for(int i = 0; i < encryptedMessage.length; i++) {
                if(Character.isAlphabetic(encryptedMessage[i])) {
                    char charForDecryption = encryptedMessage[i];
                    int lowerCaseWillLoopAt = 96 + key;
                    int upperCaseWillLoopAt = 64 + key;
                    
                    if(charForDecryption <= lowerCaseWillLoopAt && charForDecryption > 96) {
                        int charForLooping = 122 - (lowerCaseWillLoopAt - charForDecryption);
                        charForDecryption = (char)charForLooping;
                    }  else if (charForDecryption <= upperCaseWillLoopAt && charForDecryption < 91) {
                        int charForLooping = 90 - (upperCaseWillLoopAt - charForDecryption);
                        charForDecryption = (char)charForLooping;
                    } else {
                        charForDecryption -= key;
                    }
                    
                    decryptedMessage[i] = charForDecryption;
                }
                else {
                    decryptedMessage[i] = oMessageArray[i];
                }
            }
        }
        System.out.println("Original message: " + unencryptedMessage + " \n" +
                            "Encrypted  message: " + new String(encryptedMessage) + " \n" +
                            "Decrypted message: message: " + new String(decryptedMessage) );
        
        //TASK 2
        String oString = "Rac%e%  car";
        String modifiedString = oString.toLowerCase().replace(" ", "");
        String isPalindrome = "is not";
        String cleanString = "";
        String reversedString = "";
        
        for(int i = 0; i < modifiedString.length(); i++) {
            char currentChar = modifiedString.toCharArray()[i];
            if(Character.isAlphabetic(currentChar)) {
                cleanString += currentChar;
                reversedString = currentChar + reversedString;
            }
        }
        
        if(cleanString.equals(reversedString)) {
            isPalindrome = "is";
        }
        
        System.out.println("The original string is: " + oString  + " \n" +
                            "The modified string is: " + modifiedString  + " \n" +
                            "The string " + isPalindrome + " a palindrome");
        
        //TASK 3
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] alphabetCount = new int[27];
        
        for(int i = 0; i < modifiedString.length(); i++) {
            char currentChar = modifiedString.toCharArray()[i];
            if(Character.isAlphabetic(currentChar)) {
                int alphabetIndex = alphabet.indexOf(currentChar);
                alphabetCount[alphabetIndex] += 1;
            }
        }
        
        int highestIndexValue = 0;
        int highestIndex = 0;
        
        for(int i = 0; i < alphabetCount.length; i++) {
            if(alphabetCount[i] > highestIndexValue) {
                highestIndexValue += alphabetCount[i];
                highestIndex = i;
            }
        }
        
        if(highestIndexValue <= 1) {
           System.out.println("No letter occurred more than once"); 
        } else {
            System.out.println("The most occuring alphabet is " + alphabet.toCharArray()[highestIndex]);
        }
        
    }
    
}
