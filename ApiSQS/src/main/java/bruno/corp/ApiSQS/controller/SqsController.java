package bruno.corp.ApiSQS.controller;

import bruno.corp.ApiSQS.service.SqsServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqsController {

    @Autowired
    private SqsServiceMessage sqsServiceMessage;

    @GetMapping
    public ResponseEntity<?> sennd(@RequestParam("message")String message){
        sqsServiceMessage.sendMessage(message);
        return  ResponseEntity.ok().build();
    }
}
