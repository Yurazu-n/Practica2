package org.example.control;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.example.model.EventPublisher;

import javax.jms.*;

public class PredictionPublisher implements EventPublisher {
    @Override
    public void publishEvent(String jsonPrediction) throws MyExecutionException {
        try {
            String url = ActiveMQConnection.DEFAULT_BROKER_URL;
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("prediction.weather");
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();

            message.setText(jsonPrediction);
            producer.send(message);
            connection.close();

        } catch (JMSException e) {
            throw new MyExecutionException("Execution Error");
        }
    }
}