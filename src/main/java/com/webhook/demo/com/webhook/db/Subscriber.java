package com.webhook.demo.com.webhook.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String token;
    private String url;
    private String secretKey;
    private String name;

    public Subscriber() {}

    public Subscriber(int id, String token, String url, String secretKey, String name) {
        this.id = id;
        this.token = token;
        this.url = url;
        this.secretKey = secretKey;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
