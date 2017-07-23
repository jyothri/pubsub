package edu.jyo.test.logmein.pubsub.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.jyo.test.logmein.pubsub.util.Utility;

/**
 * A simple subscriber which notifies subscribers in the same running thread.
 * An alternative is {@link AsyncNotifier}
 * @author jkurapati
 *
 */
public class SimpleSubscriber extends AbstractSubscriber {

    final Logger logger = Logger.getLogger(SimpleSubscriber.class.getName());
    private final String name;
    
    public SimpleSubscriber(String name){
        this.name = name;
    }
    
    @Override
    public void onMessage(Object message) {
        logger.log(Level.INFO, Utility.getTimeElapsed()+ " Subscriber:"+name+" Recived message:"+message);
    }

}
