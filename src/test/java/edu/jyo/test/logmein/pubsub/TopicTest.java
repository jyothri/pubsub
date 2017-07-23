package edu.jyo.test.logmein.pubsub;

import org.junit.Test;

import edu.jyo.test.logmein.pubsub.impl.SimpleNotifier;
import edu.jyo.test.logmein.pubsub.impl.SimpleSubscriber;
import edu.jyo.test.logmein.pubsub.impl.SlowSubscriber;

public class TopicTest {

    @Test
    public void simpleTest(){
        Topic topic = new Topic(new SimpleNotifier());
        Subscriber s1 = new SimpleSubscriber("simple sub1");
        Subscriber s2 = new SimpleSubscriber("simple sub2");
        topic.register(s1);
        topic.register(s2);
        topic.postMessage("First Simple Message");
        topic.postMessage("Second Simple Message");
    }
    
    @Test
    public void slowSubscriberTest(){
        Topic topic = new Topic();
        Subscriber s1 = new SlowSubscriber("slow sub1",5000);
        Subscriber s2 = new SlowSubscriber("slow sub2",5000);
        topic.register(s1);
        topic.register(s2);
        topic.postMessage("first Message");
        topic.postMessage("Second Message");
        topic.shutdown();
    }
}
