package org.example;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQFileMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String BROKER_URL = "tcp://localhost:61616";
    //用户订阅的TOPIC，只有相同的TOPIC才能收到相同的消息（即群聊）
    private static final String CHAT_TOPIC = "chatTopic";
    //用户的用户名，用于唯一辨识一个用户，后续也会作为ClientID使用
    private static final String USER_NAME = "user2";

    public static void main(String[] args) throws JMSException, IOException {
        //与ActiveMq建立连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID(USER_NAME);
        connection.start();

        //设定消息确认模式（此处是自动确认）和TOPIC
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(CHAT_TOPIC);

        //创建消息监听事件，便于收到其他用户消息
        MessageConsumer consumer = session.createDurableSubscriber(topic, USER_NAME);
        consumer.setMessageListener(message -> {
            if (message instanceof ActiveMQFileMessage) {
                try {
                    File file = ((ActiveMQFileMessage) message).getFile();
                    System.out.println("收到文件");
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String messageText = reader.readLine();
            MessageProducer producer = session.createProducer(topic);
            producer.send(((ActiveMQSession) session).createFileMessage(new File(messageText)));
        }
    }
}