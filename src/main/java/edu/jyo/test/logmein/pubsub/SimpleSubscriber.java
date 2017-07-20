package edu.jyo.test.logmein.pubsub;

public class SimpleSubscriber extends AbstractSubscriber {

    private final String name;
    
    public SimpleSubscriber(String name){
        this.name = name;
    }
    
    @Override
    public void onMessage(Object message) {
        System.out.println("Subscriber:"+name+" Recived message:"+message);
    }

}
