package edu.jyo.test.logmein.pubsub.util;

public class Utility {

    final static long start = System.currentTimeMillis();
    
    public static long getTimeElapsed(){
        return (System.currentTimeMillis()-start)/1000;
    }
    
}
