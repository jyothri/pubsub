package edu.jyo.test.logmein.pubsub;

import org.junit.Test;

public class BrokerTest {

//    @Test
    public void simpleTest(){
        Broker broker = new Broker();
        Subscriber s1 = new SimpleSubscriber("simple sub1");
        Subscriber s2 = new SimpleSubscriber("simple sub2");
        broker.register(s1);
        broker.register(s2);
        broker.postMessage("First Simple Message");
        broker.postMessage("Second Simple Message");
    }
    
    @Test
    public void slowSubscriberTest(){
        Broker broker = new Broker();
        Subscriber s1 = new SlowSubscriber("slow sub1",5000);
        Subscriber s2 = new SlowSubscriber("slow sub2",5000);
        broker.register(s1);
        broker.register(s2);
        broker.postMessage("first Message");
        broker.postMessage("Second Message");
        broker.shutdown();
    }
}
