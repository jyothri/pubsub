package edu.jyo.test.logmein.pubsub;

import org.junit.Test;

import edu.jyo.test.logmein.pubsub.impl.MessageServiceImpl;
import edu.jyo.test.logmein.pubsub.impl.SlowSubscriber;
import junit.framework.Assert;

public class MessageServiceTest {

    @Test
    public void test() {
        MessageService service = new MessageServiceImpl();
        Topic topic1 = service.createTopicConnection("topic1");
        Topic topic2 = service.createTopicConnection("topic1");
        Assert.assertEquals(topic1, topic2);
        System.out.println(topic1.toString());
    }

}
