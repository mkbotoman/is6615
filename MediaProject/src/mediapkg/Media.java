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
public class Media {
    
    int mID;
    String mName;
    int yearReleased;
    
    public Media(int id, int year, String mName) {
        mID = id;
        yearReleased = year;
        this.mName = mName;
    }
}


