package com.webhook.demo.controller;

import com.webhook.demo.com.webhook.db.Subscriber;
import com.webhook.demo.com.webhook.db.SubscriberDAO;
import com.webhook.demo.com.webhook.db.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @PostMapping("/save")
    public ResponseEntity saveSubscriber(@RequestBody Subscriber subscriber) {
        subscriberService.saveSubscriber(subscriber);
        return ResponseEntity.ok(subscriberService.findAll());
    }
}
