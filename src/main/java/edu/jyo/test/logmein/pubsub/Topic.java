package edu.jyo.test.logmein.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.jyo.test.logmein.pubsub.impl.AsyncNotifier;
import edu.jyo.test.logmein.pubsub.util.Utility;

public class Topic {
    
    private List<Subscriber> subscribers;
    private final MessageNotifier notifier;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final String name;
    
    /** 
     * Initializes a new Pub/Sub system
     * By default notifies subscribers in separate thread so that 
     * a slow processing subscriber does not delay notification
     * to other subscribers
     */
    public Topic(){
        subscribers = new ArrayList<Subscriber>();
        notifier = new AsyncNotifier();
        name = null;
    }
    
    public Topic(String name){
        subscribers = new ArrayList<Subscriber>();
        notifier = new AsyncNotifier();
        this.name = name;
    }
    
    /** 
     * Initializes a new Pub/Sub system
     * @param notifier The notifier which handles notification to subscribers
     */
    public Topic(String name,MessageNotifier notifier){
        subscribers = new ArrayList<Subscriber>();
        this.notifier = notifier;
        this.name = name;
    }
    
    public void postMessage(Object o){
        logger.log(Level.INFO,Utility.getTimeElapsed()+ " Recieved message");
        
        for(Subscriber s: subscribers){
            logger.log(Level.INFO,Utility.getTimeElapsed()+ " Dispatching to "+ s);
            notifier.notifyOnMessage(s, o);
        }
    }
    
    public void register(Subscriber s){
        subscribers.add(s);
        s.onRegister();
    }
    
    public void shutdown(){
        notifier.complete();
    }
    
    @Override
    public String toString(){
        return "topic name:"+name+" notifier:"+notifier;
    }
}
