package edu.jyo.test.logmein.pubsub.impl;

import edu.jyo.test.logmein.pubsub.MessageNotifier;
import edu.jyo.test.logmein.pubsub.Subscriber;

public class SimpleNotifier implements MessageNotifier {

    @Override
    public void notifyOnMessage(Subscriber s, Object message) {
        s.onMessage(message);
    }

    @Override
    public void complete() {
    }

}
