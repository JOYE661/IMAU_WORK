package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.io.FileUtils;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //ActiveMq服务所在的地址和端口
    private static final String BROKER_URL = "tcp://localhost:61616";
    //用户订阅的TOPIC，只有相同的TOPIC才能收到相同的消息（即群聊）
    private static final String CHAT_TOPIC = "chatTopic";
    //用户的用户名，用于唯一辨识一个用户，后续也会作为ClientID使用
    private static final String USER_NAME = "user2";

    public static void main(String[] args) {
        try {
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
                if (message instanceof TextMessage) {
                    //如果是TextMessage即为普通聊天消息
                    try {
                        String receivedMessage = ((TextMessage) message).getText();
                        System.out.println("Received: " + receivedMessage);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                } else if (message instanceof BytesMessage) {
                    //如果是BytesMessage即为文本消息
                    try {
                        BytesMessage bytesMessage = (BytesMessage) message;
                        byte[] fileBytes = new byte[(int) bytesMessage.getBodyLength()];
                        bytesMessage.readBytes(fileBytes);

                        // 指定保存文件的路径，此处以文本文件为例
                        String fileName = message.getStringProperty("fileName");
                        String filePath = "C:\\Users\\CC507\\Desktop\\output\\" + fileName;
                        FileUtils.writeByteArrayToFile(new File(filePath), fileBytes);

                        System.out.println("File received and saved: " + filePath);
                    } catch (JMSException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            //创建了MessageProducer对象，用于发送消息到主题
            MessageProducer producer = session.createProducer(topic);

            // 简单的命令行输入输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String messageText = reader.readLine();

                if (messageText.startsWith("/file")) {
                    //如果以/file开头即为发送文件，后跟文件路径即可
                    String filePath = messageText.substring(6); // 提取文件路径

                    File file = new File(filePath);
                    String fileName = file.getName();
                    if (!file.exists() || !file.isFile()) {
                        System.out.println("Invalid file path!");
                        continue; // 如果文件不存在或者不是一个普通文件，则继续下一次循环
                    }

                    byte[] fileBytes = FileUtils.readFileToByteArray(file); // 读取文件内容

                    BytesMessage bytesMessage = session.createBytesMessage();
                    bytesMessage.setStringProperty("fileName", fileName);
                    bytesMessage.writeBytes(fileBytes);
                    producer.send(bytesMessage); // 发送字节消息
                } else {
                    //发送普通消息
                    TextMessage textMessage = session.createTextMessage(USER_NAME + ": " + messageText);
                    producer.send(textMessage); // 发送文本消息
                }
            }

        } catch (JMSException | IOException e) {
            e.printStackTrace();
        }
    }
}
