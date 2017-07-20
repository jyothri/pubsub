package edu.jyo.test.logmein.pubsub;

/**
 * Provides a convenient no-op implementation which concrete subscribers can extend
 * @author jkurapati
 *
 */
public abstract class AbstractSubscriber implements Subscriber {

    public abstract void onMessage(Object message);

    public void onRegister() {

    }

    public void onDeRegister() {

    }

}
