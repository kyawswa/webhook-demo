package com.webhook.demo.com.webhook.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

@Service
public class NotifyService {

    Logger logger = Logger.getLogger(NotifyService.class.getName());

    @Autowired
    SubscriberDAO subscriberDAO;

    @Autowired
    RestTemplate restTemplate;

//    @Async
//    @EventListener
//    public void publishEvent(WebhookEvent event) {
//        logger.info("sending event "+event.getName());
//        for(Subscriber sub: subscriberDAO.findAll()) {
//            restTemplate.postForEntity(sub.getUrl(), sub, String.class);
//            logger.info("Subscriber "+ sub.getName()+" sent.");
//        }
//    }


    @Async
    @EventListener
    public void listenEvent(WebhookEvent event) {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        for(Subscriber sub: subscriberDAO.findAll()) {
            executor.submit(() -> {
                System.out.println("Subscriber " + sub.getName() + " sent.");
                try {
                    restTemplate.postForEntity(sub.getUrl(), sub, String.class);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Subscriber " + sub.getName() + " sent.");
            });
        }
    }
}
