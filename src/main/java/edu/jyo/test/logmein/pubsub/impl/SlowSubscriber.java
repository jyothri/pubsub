package edu.jyo.test.logmein.pubsub.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.jyo.test.logmein.pubsub.util.Utility;

public class SlowSubscriber extends AbstractSubscriber {

    private final String name;
    private final long sleepTime;
    final Logger logger = Logger.getLogger(SlowSubscriber.class.getName());
    
    public SlowSubscriber(String name, long millis){
        this.name = name;
        this.sleepTime = millis;
    }
    
    @Override
    public void onMessage(Object message) {
        logger.log(Level.INFO, Utility.getTimeElapsed()+ " Subscriber:"+name+" Received message:"+message+" Processing start");
        try{
            Thread.sleep(sleepTime);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        logger.log(Level.INFO,Utility.getTimeElapsed()+ " Subscriber:"+name+" Received message:"+message+" Processing complete");
    }

}
