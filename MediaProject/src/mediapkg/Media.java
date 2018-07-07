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
public abstract class Media implements MediaInterface {
    
    int mID;
    String mName;
    int yearReleased;
    static int countMediaObjects = 0;
    
    public Media(int id, int year, String mName) {
        mID = id;
        yearReleased = year;
        this.mName = mName;
        
        countMediaObjects++;
    }
    
    public int getID() {
        return mID;
    }
    
    public static int getCount() {
        return countMediaObjects;
    }
    
    public void resetName() {
        mName = "";
    }
    
    public abstract int getYear();
    public abstract String getName();
}


