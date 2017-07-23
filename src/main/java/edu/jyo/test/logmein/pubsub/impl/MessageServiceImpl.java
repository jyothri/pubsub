package edu.jyo.test.logmein.pubsub.impl;

import java.util.concurrent.ConcurrentHashMap;

import edu.jyo.test.logmein.pubsub.MessageService;
import edu.jyo.test.logmein.pubsub.Topic;

public class MessageServiceImpl implements MessageService {

    ConcurrentHashMap<String,Topic> topics = new ConcurrentHashMap<>();
    
    @Override
    public Topic createTopicConnection(String topicName) {
        Topic topic = new Topic(topicName);
        Topic existing = topics.putIfAbsent(topicName,topic);
        return existing==null?topic:existing;
    }

}
