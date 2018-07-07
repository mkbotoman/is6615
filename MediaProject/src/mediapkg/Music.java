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
public class Music extends Media {
    public Music (int musicID, int musicYear, String musicName) {
        super (musicID, musicYear, musicName);
    }
    
    @Override
    public String getName() {
        return mName;
    }
    
    @Override
    public int getYear() {
        return yearReleased;
    }
    
    @Override
    public String getInfo() {
        return mID + ", " + mName + ", " + yearReleased;
    }
}
