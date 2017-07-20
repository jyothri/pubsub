package edu.jyo.test.logmein.pubsub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncNotifier implements MessageNotifier {

    final static ExecutorService es = Executors.newCachedThreadPool();
    
    @Override
    public void notifyOnMessage(final Subscriber s, final Object message) {
        
        es.submit(new Runnable(){
            @Override
            public void run() {
                System.out.println("Start "+Thread.currentThread()+" "+Utility.getTimeElapsed());
                s.onMessage(message);
                System.out.println("End "+Thread.currentThread()+" "+Utility.getTimeElapsed());
            }
        });
        
    }

    @Override
    public void complete() {
        es.shutdown();
        try {
            es.awaitTermination(7, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdownNow();
    }

}
