package edu.jyo.test.logmein.pubsub;

public interface MessageNotifier {

    public void notifyOnMessage(Subscriber s, Object message);

    public void complete();
}
