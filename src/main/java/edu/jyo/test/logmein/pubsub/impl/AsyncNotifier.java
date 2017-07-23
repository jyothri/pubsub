package edu.jyo.test.logmein.pubsub.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.jyo.test.logmein.pubsub.MessageNotifier;
import edu.jyo.test.logmein.pubsub.Subscriber;
import edu.jyo.test.logmein.pubsub.util.Constants;
import edu.jyo.test.logmein.pubsub.util.Utility;

/**
 * A subscriber which notifies subscribers in its own thread.
 * This improves performance against slow subscribers
 * @author jkurapati
 *
 */
public class AsyncNotifier implements MessageNotifier {

    final static ExecutorService es = Executors.newCachedThreadPool();
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Override
    public void notifyOnMessage(final Subscriber s, final Object message) {
        
        es.submit(new Runnable(){
            @Override
            public void run() {
                logger.log(Level.INFO,Utility.getTimeElapsed()+ " Start of:"+Thread.currentThread());
                s.onMessage(message);
                logger.log(Level.INFO,Utility.getTimeElapsed()+ " End of:"+Thread.currentThread());
            }
        });
        
    }

    @Override
    public void complete() {
        es.shutdown();
        try {
            es.awaitTermination(Constants.SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdownNow();
    }

}
