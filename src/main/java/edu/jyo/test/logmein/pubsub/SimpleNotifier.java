package edu.jyo.test.logmein.pubsub;

public class SimpleNotifier implements MessageNotifier {

    @Override
    public void notifyOnMessage(Subscriber s, Object message) {
        s.onMessage(message);
    }

    @Override
    public void complete() {
    }

}
