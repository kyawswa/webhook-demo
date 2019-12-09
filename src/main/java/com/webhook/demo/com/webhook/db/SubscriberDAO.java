package com.webhook.demo.com.webhook.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberDAO extends JpaRepository<Subscriber, Integer> {
}
