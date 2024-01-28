package bruno.corp.ApiSQS.listener;


import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMenssageListemer {

    @SqsListener("${sqsQueueName}")
    public  void  queueListener(String message){
        try {
            System.out.println(message);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
