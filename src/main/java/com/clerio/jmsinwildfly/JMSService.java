package com.clerio.jmsinwildfly;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;

@ApplicationScoped
public class JMSService {

    @Resource(mappedName = "java:/jms/queue/CleriosQueue")
    private Queue cleriosQueue;

    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext jmsContext;

    public void send(String  message){
        try{
            TextMessage textMessage =   jmsContext.createTextMessage(message);
            JMSProducer jmsProducer = jmsContext.createProducer();
            jmsProducer.send(cleriosQueue,textMessage );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
