package com.webhook.demo.com.webhook.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private SubscriberDAO subscriberDAO;

    public void publishAnEvent() {
        System.out.println("Publishing custom event. ");
        WebhookEvent customSpringEvent = new WebhookEvent("Webhook_Event");
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

    public void saveSubscriber(Subscriber subscriber) {
        subscriberDAO.save(subscriber);
        publishAnEvent();
    }

    public List<Subscriber> findAll() {
        return subscriberDAO.findAll();
    }
}
