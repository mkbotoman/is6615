/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediapkg;

/**
 *
 * @author maureen
 */
public class ManageMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Movie aMovie = new Movie(1, 2017, "Sample1");
        Movie anotherMovie = new Movie (2, 1998, "Sample2", MovieGenreEnum.HORROR);
        
        Music aSong = new Music(100, 2016, "Stairway to Heaven");
        
        Media[] mediaArray = new Media[3];
        
        mediaArray[0] = aMovie;
        mediaArray[1] = anotherMovie;
        mediaArray[2] = aSong;
        
        MediaInterface[] mIArray = new MediaInterface[3];
        
        mIArray[0] = aMovie;
        mIArray[1] = anotherMovie;
        mIArray[2] = aSong;
        
        for(int j = 0; j<mediaArray.length; j++) {
            if(mediaArray[j] instanceof Movie) {
                System.out.println("Movie name is: " + mediaArray[j].getName());
            } else {
                System.out.println("Song name is: " + mediaArray[j].getName());    
            }
            
        }
        
        for(int j = 0; j<mIArray.length; j++) {
            System.out.println(mIArray[j].getInfo());
        }
    }
    
}
