/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwriteio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author maureen
 */
public class ReadWriteIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String fileName = "sample.txt";

        writeToFile(fileName);
        readFromFile(fileName);
    }

    public static void writeToFile(String fName) throws IOException {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fName, false));
            bw.write("This is a java course.\n");
            bw.write("we are working with IO streams.");
            bw.flush();
        } catch (IOException ioe) {
            System.err.println("file cannot be written");
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static void readFromFile(String file) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String readFromFile = "";
            while ((readFromFile = br.readLine()) != null) {
                System.out.println(readFromFile);
            }

        } catch (FileNotFoundException fne) {
            System.err.println("file not found");
        }
        catch (IOException ioe) {
            System.err.println("an IO exception occured");
        }
        finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
