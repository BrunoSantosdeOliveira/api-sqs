package bruno.corp.ApiSQS.service;


import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqsServiceMessage {
    @Value("${sqsQueueName}")
    private String queueName;

    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public void SqsMesageService(AmazonSQSAsync amazonSQSAsync){
        this.queueMessagingTemplate=new QueueMessagingTemplate(amazonSQSAsync);
    }

    public SqsServiceMessage(String queueName) {
        this.queueName = queueName;
    }

    public  void  sendMessage(String message){
        this.queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(message).build());
    }


}
