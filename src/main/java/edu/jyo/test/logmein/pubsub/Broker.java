package edu.jyo.test.logmein.pubsub;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    
    List<Subscriber> subscribers = new ArrayList<Subscriber>();
    private final MessageNotifier notifier = new AsyncNotifier();
    private final boolean DEBUG = true;
    
    public void postMessage(Object o){
        if(DEBUG)
            System.out.println("Recieved message at:"+Utility.getTimeElapsed());
        for(Subscriber s: subscribers){
            if(DEBUG)
                System.out.println("Dispatching to "+ s +" at:"+Utility.getTimeElapsed());
            notifier.notifyOnMessage(s, o);
        }
    }
    
    public void register(Subscriber s){
        s.onRegister();
        subscribers.add(s);
    }
    
    public void shutdown(){
        notifier.complete();
    }
}
