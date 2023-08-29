package jms.nav;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;
import javax.xml.soap.Text;

public class JmsNavReseiver {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.3.9.47:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);

        Destination destination = new ActiveMQTopic("mq_topic");
        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(textMessage.getText());
                message.acknowledge();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

//        TextMessage message=(TextMessage) consumer.receive();
//        System.out.println(message.getText());
//        message.acknowledge();
//
//        session.commit();
//        session.close();
//        connection.close();
    }
}