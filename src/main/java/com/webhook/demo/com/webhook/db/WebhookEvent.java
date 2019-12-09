package com.webhook.demo.com.webhook.db;

public class WebhookEvent {
    private String name;

    public WebhookEvent(){}

    public WebhookEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
