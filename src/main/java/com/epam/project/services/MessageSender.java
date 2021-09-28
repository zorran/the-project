package com.epam.project.services;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageSender {

    private static final String QUEUE_NAME = "https://sqs.us-east-2.amazonaws.com/263349140960/the-project-sqs";

    @Autowired
    private final AmazonSQSAsync amazonSqs;

    @Autowired
    public MessageSender(final AmazonSQSAsync amazonSQSAsync) {
        this.amazonSqs = amazonSQSAsync;
    }

    public boolean send(final String messagePayload) {
        MessageChannel messageChannel = new QueueMessageChannel(amazonSqs, QUEUE_NAME);

        Message<String> msg = MessageBuilder.withPayload(messagePayload)
            .setHeader("sender", "app1")
            .setHeaderIfAbsent("country", "AE")
            .build();

        long waitTimeoutMillis = 5000;
        boolean sentStatus = messageChannel.send(msg,waitTimeoutMillis);
        log.info("message sent");
        return sentStatus;
    }
}
