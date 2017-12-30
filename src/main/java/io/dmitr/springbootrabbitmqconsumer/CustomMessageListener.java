package io.dmitr.springbootrabbitmqconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import io.dmitr.springbootrabbitmq.CustomMessage;

@Service
public class CustomMessageListener {
    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

//    @RabbitListener(queues = SpringBootRabbitmqConsumerApplication.QUEUE_GENERIC_NAME)
//    public void receiveMessage(final Message message) {
//        log.info("Received message as generic: {}", message.toString());
//    }

    @RabbitListener(queues = SpringBootRabbitmqConsumerApplication.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final CustomMessage customMessage) throws InterruptedException {
        log.info("Received message as specific class: {}", customMessage.toString());
        Thread.sleep(1000);
    }
}
