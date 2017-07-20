package edu.jyo.test.logmein.pubsub;

public class SlowSubscriber extends AbstractSubscriber {

    private final String name;
    private final long sleepTime;
    
    public SlowSubscriber(String name, long millis){
        this.name = name;
        this.sleepTime = millis;
    }
    
    @Override
    public void onMessage(Object message) {
        System.out.println("Subscriber:"+name+" Recived message:"+message+" Processing start"+" "+Utility.getTimeElapsed());
        try{
            Thread.sleep(sleepTime);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("Subscriber:"+name+" Recived message:"+message+" Processing complete"+" "+Utility.getTimeElapsed());
    }

}
