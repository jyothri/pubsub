package edu.jyo.test.logmein.pubsub;

/**
 * Represents a subscriber to message broker listening for messages
 * @author jkurapati
 *
 */
public interface Subscriber {

    /**
     * Method to be invoked on subscriber when message is received
     * @param message
     */
    public void onMessage(Object message);
    
    /**
     * Callback that would be invoked after successful registration with the Topic
     */
    public void onRegister();
    
    /**
     * Callback that would be invoked when Topic is shutting down
     * Allows for doing any cleanup
     */
    public void onDeRegister();
}
